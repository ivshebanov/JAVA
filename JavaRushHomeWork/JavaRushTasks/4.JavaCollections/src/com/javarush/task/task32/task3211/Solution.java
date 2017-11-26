package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] bytesMd5 = digest.digest(byteArrayOutputStream.toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bytesMd5){
            sb.append(String.format("%02x", b));
        }
        String stringMd5 = sb.toString();
        return md5.equals(stringMd5);
    }
}
