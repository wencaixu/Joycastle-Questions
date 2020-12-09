package com.joycastle.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigestUtilsTest {


    @Test
    public void encode(){
        // Md5验证32位
        assertTrue(DigestUtils.encode("wencai.xu").length() == 32);
    }

}