package com.atguigu;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test01 {
    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println("encode = " + encode);


    }
}
