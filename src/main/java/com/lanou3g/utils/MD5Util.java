package com.lanou3g.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dllo on 17/11/17.
 */
public class MD5Util {
    public static String MD5(String str){
        StringBuffer md5Code = new StringBuffer();

        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            //将字符串转化为字节数组,字符串中每个字符转换为对应的ASCII值作为字节数组中的一个元素
            //将字节数组通过固定算法转化为16个元素的有符合哈希值字节数组
            byte[] digest = instance.digest(str.getBytes());
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 0xff);
                if (hexString.length() < 2) {
                    //将不足2位的无符号16进制的字符串前面加0
                    hexString = "0" + hexString;

                }

                md5Code = md5Code.append(hexString);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str;
        }
        return md5Code.toString();
    }

}
