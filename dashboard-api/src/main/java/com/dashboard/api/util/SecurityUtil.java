package com.dashboard.api.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

/**
 * @author Leboc Philippe.
 */
@Slf4j
@Component
public final class SecurityUtil {

    // Logger
    private static final String WARN_CHARSET_OR_ALGO_NOT_FOUND = "Cannot use the given charset or hash algorithm does not exist";

    // Utils
    private static final String CHARSET_ENCODE = "UTF-8";
    private static final String UUID_SEPARATOR = "-";
    private static final String BLANK = "";

    // Attributes
    private static String algorithm;

    /**
     * Never create instance of an Util class
     */
    private SecurityUtil() {}

    /**
     * Encode a String with default properties configured algorithm
     * @param str The str as clear text
     * @return The str HASH (NOT ENCRYPTION !)
     */
    public static String hash(String str) {
        return hash(str, algorithm);
    }

    /**
     * Encore a String with the given algorithm
     * @param str The str as clear text
     * @param algorithm The algorithm to be used
     * @return The encoded password or null if operation unsuccessful
     */
    public static String hash(String str, String algorithm) {
        final MessageDigest md;
        byte[] newPassword;
        try {
            md = MessageDigest.getInstance(algorithm);
            newPassword = str.getBytes(CHARSET_ENCODE);
            newPassword = md.digest(newPassword);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | NullPointerException e) {
            log.warn(WARN_CHARSET_OR_ALGO_NOT_FOUND, e);
            return null;
        }

        return base64Encode(newPassword);
    }

    public static String decode(String url) {
        try {
            String prevURL="";
            String decodeURL = url;
            while(!prevURL.equals(decodeURL))
            {
                prevURL = decodeURL;
                decodeURL = URLDecoder.decode( decodeURL, CHARSET_ENCODE);
            }
            return decodeURL;
        } catch (UnsupportedEncodingException e) {
            return "Issue while decoding" +e.getMessage();
        }
    }

    public static String encode(String url) {
        try {
            return URLEncoder.encode( url, CHARSET_ENCODE);
        } catch (UnsupportedEncodingException e) {
            return "Issue while encoding" +e.getMessage();
        }
    }

    /**
     * Encode the given String to Base64 using default UTF-8 charset
     * @param str The given String to encode
     * @return The Base64 encoded String
     */
    public static String base64Encode(String str) {
        return base64Encode(str, StandardCharsets.UTF_8.name());
    }

    /**
     * Encode the given String to Base64 with the given charset
     * @param str The given String to encode
     * @param charset the given charset to encode str
     * @return The Base64 encoded String
     */
    public static String base64Encode(String str, String charset) {
        String encoded = null;
        try {
            encoded = base64Encode(str.getBytes(charset));
        } catch (UnsupportedEncodingException | NullPointerException e) {
            log.warn(WARN_CHARSET_OR_ALGO_NOT_FOUND, e);
        }
        return encoded;
    }

    /**
     * Encode Byte array to Base64
     * @param bytes The given Byte array
     * @return The Base64 encoded Byte array
     */
    public static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Decode String from Base64
     * @param str The given Base64 String
     * @return The String decoded from Base64
     */
    public static String base64Decode(String str) {
        return base64Decode(str, StandardCharsets.UTF_8.name());
    }

    /**
     * Decode String from Base64
     * @param str The given Base64 String
     * @param charset The given charset to encode str
     * @return The String decoded from Base64
     */
    public static String base64Decode(String str, String charset) {
        String decoded = null;
        try {
             decoded = base64Decode(str.getBytes(charset));
        } catch (UnsupportedEncodingException | NullPointerException e) {
            log.warn(WARN_CHARSET_OR_ALGO_NOT_FOUND, e);
        }
        return decoded;
    }

    /**
     * Decode Byte array from Base64
     * @param bytes The given Base64 Byte array
     * @return The Byte array decoded from Base64
     */
    public static String base64Decode(byte[] bytes) {
        return new String(Base64.getDecoder().decode(bytes));
    }

    /**
     * Create a random token string from UUID and current date format yyyymmdd
     * @return the generated token
     */
    public static String generateToken() {
        final String uid = UUID.randomUUID().toString().replaceAll(UUID_SEPARATOR, BLANK);
        final String hash = hash(uid);
        if(hash == null) return null;
        return encode(hash.substring(0, hash.length() - 2));
    }

    @Value("${application.auth.password.algorithm}")
    public void setAlgorithm(String algorithm) {
        SecurityUtil.algorithm = algorithm;
    }
}