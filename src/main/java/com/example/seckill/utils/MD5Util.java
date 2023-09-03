package com.example.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {
    /*
    * md5两次加密
    * 第一次：前端输入密码后传入后端，实现后端固定盐值+前端输入密码的加密
    * 第二次：将后端加密后的密码进行第二次加密，实现后端加密后密码+数据库盐值的加密
    * */
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    //盐值
    private static final String salt = "1a2b3c4d";

    //第一次加密
    public static String inputPassToFormPass(String inputPass){
        String str = "" + salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(4)+salt.charAt(5);
        return md5(str);
    }

    //第二次加密
    public static String formPassToDBPass(String formPass,String salt){
        String str = "" + salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(4)+salt.charAt(5);
        return md5(str);
    }

    //最终调用
    public static String inputPassToDBPass(String inputPass,String salt){
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("123456"));
        System.out.println(formPassToDBPass("f2266f92e31d032983464ea05d6fb4e4","1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }
}
