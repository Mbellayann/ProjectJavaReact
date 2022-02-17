package com.epita.finalproject;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class TestBycrypt {
    public static String password;
    public static String encryptedPass;

    @Before
            public void test() {
        password = "yann";
        encryptedPass = BCrypt.hashpw(password, BCrypt.gensalt(10));

    }

    @Test
            public void test2() {
            System.out.println(encryptedPass);
        System.out.println(BCrypt.checkpw(password, encryptedPass));
    }

}
