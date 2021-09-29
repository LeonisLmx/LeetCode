import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Main {
    public static void main(String[] args) {
        String paramString = "GET\napi-uat.matrix.co\n/v1/account/accounts/balance\nAAAADJ4O0HtJCixW6CVL3ET2\nHmacSHA256\n1\n1619077179137";
        calculateSignature1(paramString.getBytes());
    }

    private static byte[] hash(String paramString) {
        try {
            MessageDigest localMessageDigest;
            localMessageDigest = MessageDigest.getInstance("SHA-256");
            try {
                localMessageDigest.update(paramString.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            byte[] paramByte = localMessageDigest.digest();
            System.out.println("Hash: " + Base64.getEncoder().encodeToString(paramByte));
            return paramByte;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        byte[] CDRIVES = "\u0000".getBytes();

        return CDRIVES;
    }

    public static void calculateSignature(byte[] paramArrayOfByte) {
        String Algor = "HmacSHA256";
        Mac localMac;
        try {
            localMac = Mac.getInstance(Algor);
            byte[] key = "ZSuEWZa97mgjHd71".getBytes();
            try {
                localMac.init(new SecretKeySpec(key, Algor));
            } catch (InvalidKeyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            localMac.update(paramArrayOfByte);
            paramArrayOfByte = localMac.doFinal();
            System.out.println("Signature: " + Base64.getEncoder().encodeToString(paramArrayOfByte));
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void calculateSignature1(byte[] paramArrayOfByte) {
        Mac localMac;
        try {
            localMac = Mac.getInstance("HmacSHA256");
            byte[] key = "ZSuEWZa97mgjHd71".getBytes();
            try {
                localMac.init(new SecretKeySpec(key, "HmacSHA256"));
            } catch (InvalidKeyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            localMac.update(paramArrayOfByte);
            paramArrayOfByte = localMac.doFinal();
            System.out.println(Arrays.toString(paramArrayOfByte));
            System.out.println("Signature: " + Base64.getEncoder().encodeToString(paramArrayOfByte));
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}