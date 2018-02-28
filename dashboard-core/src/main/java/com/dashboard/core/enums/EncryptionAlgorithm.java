package com.dashboard.core.enums;

import lombok.Getter;

/**
 * Documentation <a>https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html</a>
 * @author LEBOC Philippe
 */
public enum EncryptionAlgorithm {

    NONE("NONE"),
    AES("AES"),
    BLOWFISH("Blowfish"),
    DES("DES"),
    DESEDE("DESede"),
    DIFFIE_HELLMAN("DiffieHellman"),
    DSA("DSA"),
    OAEP("OAEP"),
    PBE("PBE"),
    RC2("RC2");

    @Getter
    private String name;

    /**
     * Default constructor
     * @param name The given name
     */
    EncryptionAlgorithm(String name) {
        this.name = name;
    }
}
