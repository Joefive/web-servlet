package com.sunrise;

import java.util.Random;

/**
 * 随机生成验证码数字
 */
public class TestNum {
    public static void main(String[] args) {
        System.out.println("返回数据：" + num());
    }

    public static String num() {
        Random random = new Random();
        //边界是123，最大122，3位数
        String s = random.nextInt(123) + "";
        StringBuilder sb = new StringBuilder();
        //如果小于3位数，自动补0
        for (int i = 0; i < 3 - s.length(); i++) {
            sb.append("0");
        }
        System.out.println(s);
        System.out.println(sb);
        return s + sb.toString();
    }
}
