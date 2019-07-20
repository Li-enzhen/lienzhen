package com.xiaomi.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by Li Enzhen
 * 2019/6/29 0029 下午 2:19
 */
public class MD5Utils {
    public static void main(String[] args) {
        String s = md5("123456");
        System.out.println(s);
    }
    public static String md5(String str) {
        //1创建MessageDigist对象
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            //2.更新加密
            messageDigest.update(str.getBytes("utf-8"));
            //3.获取结果
            byte[] digest = messageDigest.digest();
            //4.把加密结果变成字符串
            BigInteger bigInteger = new BigInteger(1, digest);
            return bigInteger.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
