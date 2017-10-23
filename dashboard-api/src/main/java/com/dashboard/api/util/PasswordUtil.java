package com.dashboard.api.util;

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
public class PasswordUtil {

    private static String algorithm;

    private PasswordUtil() {}

    /**
     * @param password
     * @return
     */
    public static String encode(String password) {
        return encode(password, algorithm);
    }

    /**
     * @param password
     * @param algorithm
     * @return
     */
    public static String encode(String password, String algorithm) {
        final MessageDigest md;
        byte[] newPassword;
        try {
            md = MessageDigest.getInstance(algorithm);
            newPassword = password.getBytes("UTF-8");
            newPassword = md.digest(newPassword);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        return Base64.getEncoder().encodeToString(newPassword);
    }

    @Value("${application.password.algorithm}")
    public void setAlgorithm(String algorithm) {
        PasswordUtil.algorithm = algorithm;
    }
}
