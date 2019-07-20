package com.xiaomi.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Li Enzhen
 * 2019/6/29 0029 下午 12:09
 */
public class RandomUtils {
    public static String createActiveCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str1 = sdf.format(new Date());
        String str2 = Integer.toHexString(new Random().nextInt(99999));
        return str1 + str2;
    }

}
