package com.dashboard.api.util;

import com.dashboard.api.exception.PasswordEncodeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Leboc Philippe.
 */
@Component
public class SecurityUtil {

    private String algorithm;

    private SecurityUtil() {}

    public String hash(String password) {
        return hash(password, algorithm);
    }

    public String hash(String password, String algorithm) {
        final MessageDigest md;
        byte[] newPassword;
        try {
            md = MessageDigest.getInstance(algorithm);
            newPassword = password.getBytes("UTF-8");
            newPassword = md.digest(newPassword);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new PasswordEncodeException("Cannot hash the given password", e);
        }

        return Base64.getEncoder().encodeToString(newPassword);
    }

    @Value("${application.password.algorithm}")
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
