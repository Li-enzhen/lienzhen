package com.xiaomi.utils;

/**
 * Created by Li Enzhen
 * 2019/6/28 0028 下午 9:18
 */
public class StringUtils {
    public static boolean isEmpty(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;


        }
        return false;
    }

}
