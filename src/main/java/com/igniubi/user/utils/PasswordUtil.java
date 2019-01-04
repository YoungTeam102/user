package com.igniubi.user.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Random;

/**
 */
public class PasswordUtil {

    private final Logger logger = LoggerFactory.getLogger(PasswordUtil.class);

    public static String makePass(String code) {
        String rmd = getRandomString(32);
        String crypt = string2MD5(code + rmd);
        return crypt + ":" + rmd;
    }

    public static String makePassword(String code,String rmd){
        String crypt = string2MD5(code + rmd);
        return crypt ;
    }

    /**
     * 生成一定长度的随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append('0');
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 生成8位字母数字组合的初始密码
     *
     * @return
     */
    public static String getRandomPwd() {
        String charBase = "abcdefghijklmnopqrstuvwxyz";
        String numAndCharBase = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        sb.append(random.nextInt(10));

        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(numAndCharBase.length());
            sb.append(numAndCharBase.charAt(number));
        }

        int num = random.nextInt(charBase.length());
        sb.append(charBase.charAt(num));

        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(numAndCharBase.length());
            sb.append(numAndCharBase.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 注册校验密码，密码规则，英文字母或者数字
     *
     * @param password
     *            string
     * @return
     */
    public static boolean registerValidatePassword(String password) {
        if (StringUtils.isBlank(password)) {
            return false;
        }
        //String reg = "^[a-zA-Z0-9~!@#$%^&*()-_+=<,>./?;:\"'{\\[}\\]\\|]{6,20}$";
        String reg = "^(?![0-9]+$)(?![a-zA-Z]+$)[a-zA-Z0-9]{6,20}$";
        return password.matches(reg);
    }

    /**
     * @param inputPassword   输入密码
     * @param encryptPassword 数据库密码
     * @return
     */
    private static  boolean validata(String inputPassword, String encryptPassword) {
        if (StringUtils.isEmpty(encryptPassword)) {
            return false;
        }
        //取出encryptPassword后面的32位随机数
        String[] rdm32 = encryptPassword.split(":", 0);
        String crypt = rdm32[0];
        String rdm = "";
        if (rdm32.length == 2) {
            rdm = rdm32[1];
        }


        String md5passSso = makePassword(inputPassword , rdm);
        //(2)与sso加密方式的密码进行对比
        if (crypt.equals(md5passSso)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(makePass("abc123"));
        System.out.println(validata("abc123",makePass("abc123")));
    }
}
