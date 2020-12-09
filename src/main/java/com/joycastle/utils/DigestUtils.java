package com.joycastle.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 *
 * @author  wencai.xu
 * @date  2020/12/9,0009
 * @version  V1.0
 **/

public class DigestUtils {
    public static String encode(String text) {
        try {
            byte[] secretBytes;
            secretBytes = MessageDigest.getInstance("md5").digest(text.getBytes());
            String md5 = new BigInteger(1, secretBytes).toString(16);
            StringBuilder code = new StringBuilder(md5);
            for (int i = 0; i < 32 - code.length(); i++) {
                code.insert(0, "0");
            }
            return code.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }
}
