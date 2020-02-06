package com.javarush.task.task32.task3211;

import sun.security.provider.MD5;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //ObjectOutputStream oos = new ObjectOutputStream(bos);
        bos.write(("test string").getBytes());
        bos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");


        byte[] hash2 =md.digest(byteArrayOutputStream.toByteArray());

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < hash2.length; j++) {
            sb.append(String.format("%02x",hash2[j]));
        }
        if(md5.equals(sb.toString())){
            return true;
        }
        return false;
    }
}
