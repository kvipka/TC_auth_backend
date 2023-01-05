package com.atwow.AuthBackend.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HelperSHA1 {
    public static byte[] makeSHA1fromArgs(byte[]... args) {
        MessageDigest md = null;
        byte[] result = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            for (int i = 0; i < args.length; i++) {
                md.update(args[i]);
            }
            result = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

}
