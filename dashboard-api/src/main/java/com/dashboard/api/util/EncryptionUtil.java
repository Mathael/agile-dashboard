package com.dashboard.api.util;

import com.dashboard.api.exception.security.AlgorithmNotFoundException;
import com.dashboard.api.exception.security.CipherEngineException;
import com.dashboard.api.exception.security.EncryptEmptyStrException;
import com.dashboard.api.exception.security.InvalidEncryptionKeyException;
import com.dashboard.core.enums.EncryptionAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author LEBOC Philippe
 */
@Slf4j
@Component
public class EncryptionUtil {

    // Logger
    private static final String WARN_CANNOT_ENCRYPT_NULL_OR_EMPTY = "Cannot encrypt null or empty string";
    private static final String WARN_CANNOT_GENERATE_SECRET_KEY = "Cannot generate Cipher SecretKeySpec with an empty secret [{}]";
    private static final String WARN_CANNOT_GENERATE_SECRET_KEY_WITH_NULL_ALGORITHM = "Cannot generate SecretKey with null algorithm !";

    // Exception
    private static final String NO_SUCH_ALGORITHM_EXCEPTION = "Cannot get Cipher instance for the given algorithm";
    private static final String INVALID_KEY_EXCEPTION = "The given SecretKeySpec is invalid !";
    private static final String GLOBAL_ENCRYPTION_EXCEPTION = "Cannot execute Cipher.doFinal() method !";
    private static final String ALGORITHM_CANNOT_BE_NULL = "Encryption Algorithm cannot be null";
    private static final String SECRET_KEY_IS_NULL_OR_EMPTY = "The given secret key string cannot be null or empty !";

    // Attributes
    private String secretKey;

    /**
     * Encrypt a given String with the desired algorithm
     * @param str the given str to encrypt
     * @param algorithm the given algorithm to be used
     * @return The encrypted result as byte array
     */
    public byte[] encrypt(String str, EncryptionAlgorithm algorithm) {
        final SecretKey key = generateSecretKey(secretKey, algorithm);
        return encrypt(str, key, algorithm);
    }

    /**
     * Generate a SecretKey object from the string secret key defined in properties
     * @param key The given secret key from properties
     * @param algorithm The algorithm to be used with this secret
     * @return Java SecretKey object corresponding to our secret
     */
    private SecretKey generateSecretKey(final String key, final EncryptionAlgorithm algorithm) {
        if(key == null || key.isEmpty()) {
            log.warn(WARN_CANNOT_GENERATE_SECRET_KEY, key);
            throw new RuntimeException(SECRET_KEY_IS_NULL_OR_EMPTY);
        }

        if(algorithm == null) {
            log.warn(WARN_CANNOT_GENERATE_SECRET_KEY_WITH_NULL_ALGORITHM);
            throw new AlgorithmNotFoundException(ALGORITHM_CANNOT_BE_NULL);
        }

        final byte[] data = key.getBytes();
        return new SecretKeySpec(data, algorithm.getName());
    }

    /**
     * Encrypt the given str with the given algorithm and secret key
     * @param str The given string to be encrypted
     * @param key The given SecretKey object previously generated
     * @param algorithm The algorithm to be used
     * @return The byte array of the encrypted str
     * @throws EncryptEmptyStrException if the given str is null or empty
     * @throws AlgorithmNotFoundException if the algorithm does not correspond to a valid algorithm
     * @throws InvalidEncryptionKeyException if the given SecretKey is invalid
     * @throws CipherEngineException if the Cipher engine throws an exception during encryption
     */
    private byte[] encrypt(final String str, final SecretKey key, final EncryptionAlgorithm algorithm) {
        if(str == null || str.isEmpty()) {
            log.warn(WARN_CANNOT_ENCRYPT_NULL_OR_EMPTY);
            throw new EncryptEmptyStrException(WARN_CANNOT_ENCRYPT_NULL_OR_EMPTY);
        }

        final byte[] result;
        try
        {
            // create a cipher based upon the given algorithm
            final Cipher cipher = Cipher.getInstance(algorithm.getName());

            // initialise cipher with secret key
            cipher.init(Cipher.ENCRYPT_MODE, key);

            // encrypt message
            result = cipher.doFinal(str.getBytes());

        } catch (NoSuchAlgorithmException e) {
            log.warn(NO_SUCH_ALGORITHM_EXCEPTION, e);
            throw new AlgorithmNotFoundException(NO_SUCH_ALGORITHM_EXCEPTION);
        } catch(InvalidKeyException e) {
            log.warn(INVALID_KEY_EXCEPTION, e);
            throw new InvalidEncryptionKeyException(INVALID_KEY_EXCEPTION);
        } catch (NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            log.warn(GLOBAL_ENCRYPTION_EXCEPTION, e);
            throw new CipherEngineException(GLOBAL_ENCRYPTION_EXCEPTION);
        }

        return result;
    }

    @Value("${application.security.encryption.secret}")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
