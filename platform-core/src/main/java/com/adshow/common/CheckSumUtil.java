package com.adshow.common;


import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CheckSumUtil {


    public static boolean checkMd5(String md5, File updateFile) {
        String calculatedDigest = calculateMd5(updateFile);
        if (calculatedDigest == null) {
            return false;
        }

        return calculatedDigest.equalsIgnoreCase(md5);
    }


    public static boolean checkMd5(String md5, InputStream inputStream) {
        String calculatedDigest = calculateMd5(inputStream, "MD5");
        if (calculatedDigest == null) {
            return false;
        }
        return calculatedDigest.equalsIgnoreCase(md5);
    }


    public static String calculateMd5(File updateFile) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "";
        }

        InputStream is;
        try {
            is = new FileInputStream(updateFile);
        } catch (FileNotFoundException e) {
            return "";
        }

        byte[] buffer = new byte[8192]; //8x1024 = 8MB
        int read;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            // Fill to 32 chars
            output = String.format("%32s", output).replace(' ', '0');
            return output;
        } catch (IOException e) {
            throw new RuntimeException("Unable to process file for MD5", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }


    public static String calculateMd5(InputStream stream, String checksumAlgorithm) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(checksumAlgorithm);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }

        InputStream input = null;
        StringBuffer sb = new StringBuffer();
        try {
            input = stream;
            byte[] buffer = new byte[8192];   //8x1024 = 8MB
            do {
                int read = input.read(buffer);
                if (read <= 0)
                    break;
                digest.update(buffer, 0, read);
            } while (true);
            byte[] sum = digest.digest();

            for (int i = 0; i < sum.length; i++) {
                sb.append(Integer.toString((sum[i] & 0xff) + 0x100, 16).substring(1));
            }

        } catch (IOException e) {
        } finally {
            try {
                input.close();
            } catch (IOException e) {
            }
        }

        return sb.toString();
    }
}