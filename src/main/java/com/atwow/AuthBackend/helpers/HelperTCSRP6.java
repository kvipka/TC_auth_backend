package com.atwow.AuthBackend.helpers;

import org.apache.commons.lang3.ArrayUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;

import static com.atwow.AuthBackend.helpers.HelperSHA1.makeSHA1fromArgs;

public class HelperTCSRP6 {
    private static BigInteger getX(byte[] salt, String username, String password) {
        // generate h1 - username:password
        String prepared = String.format("%s:%s", username, password).toUpperCase();
        byte[] h1 = makeSHA1fromArgs(prepared.getBytes(StandardCharsets.UTF_8));

        // generate h2 - salt + h1
        byte[] hashX = makeSHA1fromArgs(salt, h1);

        // reverse h2
        ArrayUtils.reverse(hashX);

        // construct h2bigint
        return new BigInteger(hashX);
    }

    private static byte[] finishVerifier(BigInteger source) {
        // reverse ver
        byte[] reverseVer = source.toByteArray();
        ArrayUtils.reverse(reverseVer);
        return reverseVer;
    }

    public static byte[] calculateSRP6TCVerifier(String username, String password, byte[] salt){
        BigInteger TC_g = BigInteger.valueOf(7);
        BigInteger TC_N = new BigInteger("894B645E89E1535BBDAD5B8B290650530801B18EBFBF5E8FAB3C82872A3E9BB7", 16);

        //compute x
        BigInteger x = getX(salt, username, password);

        //return g.modPow(x, N);
        BigInteger ver = TC_g.modPow(x, TC_N);
        return finishVerifier(ver);
    }

    public static Boolean verifySRP6(String username, String password, byte[] salt, byte[] verifier){
        byte[] generated = calculateSRP6TCVerifier(username, password, salt);
        return Arrays.equals(generated, verifier);
    }

    public static byte[] generateRandomSalt(int numBytes) {
        byte[] salt = new byte[numBytes];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return salt;
    }

}
