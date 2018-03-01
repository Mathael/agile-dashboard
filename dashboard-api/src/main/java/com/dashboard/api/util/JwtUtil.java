package com.dashboard.api.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Utilities class for JWT
 * CLAIM_KEY_USERNAME = "sub";
 * CLAIM_KEY_AUDIENCE = "aud"
 * CLAIM_KEY_CREATED = "iat"
 *
 * @see <a href="https://jwt.io/">JWT Official website</a>
 * @see <a href="https://github.com/jwtk/jjwt">JWT Official possible impl library (3 differents availables)</a>
 * @author LEBOC Philippe
 */
@Slf4j
@Component
public final class JwtUtil {

    private static final String AUDIENCE_WEB = "web";
    private static final String AUDIENCE_MOBILE = "mobile";
    private static final String AUDIENCE_TABLET = "tablet";

    @Value("${application.auth.jwt.secret}")
    private String secret;

    @Value("${application.auth.jwt.expiration}")
    private long expiration;

    /**
     * Retrieve the username from the token
     * @param token The request token
     * @return  The username from the given token
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * Retrieve the issuedAtDate from the token
     * @param token The request token
     * @return  The Issued Date from the given token
     */
    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    /**
     * Retrieve the Expiration date from the token
     * @param token The request token
     * @return The expiration date
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * Retrieve the audience type from the token
     * @param token The request token
     * @return The audience type
     */
    public String getAudienceFromToken(String token) {
        return getClaimFromToken(token, Claims::getAudience);
    }

    /**
     * Apply a fonction the the token body
     * @param token The request token
     * @param claimsResolver The Function resolver to apply to all Claim from the token body
     * @param <T> The return type of the given Function
     * @return  The given Function return type
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Retrieve all Claim from the token body
     * @param token The request token
     * @return A Claims object containing token body
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Check token expiration
     * @param token The request token
     * @return True if token is expired, false otherwise
     */
    private Boolean isTokenExpired(String token) {
        final Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate.before(new Date()); // new Date() = now()
    }

    /**
     * Check if the token is expired due to the last password reset
     * @param created The created date
     * @param lastPasswordReset The last password reset date
     * @return True if token is created before last password reset, false otherwise
     */
    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    /**
     * Check if the token expiration can be ignored
     * @param token The token from request
     * @return True if token audience is MOBILE or TABLET
     */
    private Boolean ignoreTokenExpiration(String token) {
        String audience = getAudienceFromToken(token);
        return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
    }

    /**
     * Generate a new Token (HASHED + SIGNED) for the given UserDetails
     * @param userDetails The user (only username will be taken) to be linked to the token
     * @return The generated token String Hashed and Signed
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setAudience(AUDIENCE_WEB)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * Check if the token can be refreshed
     * @param token The Token from Request header
     * @param lastPasswordReset Last password reset date
     * @return True if the token can be refreshed, false otherwise
     */
    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getIssuedAtDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    /**
     * Refresh the given token
     * @param token The token from the Request header
     * @return The newly created token
     */
    public String refreshToken(String token) {
        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate);

        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(createdDate);
        claims.setExpiration(expirationDate);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * Validate the given token
     * @param token The token from the Request header
     * @param userDetails The user details to be used to validate the token
     * @return True if the token is valid, false otherwise
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        final User user = new User(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        final String username = getUsernameFromToken(token);

        return username.equals(user.getUsername()) &&
                !isTokenExpired(token) &&
                //&& !isCreatedBeforeLastPasswordReset(tokenCreationDate, user.getLastPasswordResetDate())
                user.isEnabled() &&
                user.isCredentialsNonExpired()
                ;
    }

    /**
     * Calculate the expiration date (now + expiration)
     * @param createdDate The token creation date
     * @return The expiration date
     */
    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }
}