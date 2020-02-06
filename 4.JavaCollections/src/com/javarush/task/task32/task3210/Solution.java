package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile file = new RandomAccessFile(args[0],"rw");
            file.seek(Integer.parseInt(args[1]));
            byte[] byteArray = new byte[args[2].length()];
            file.read(byteArray, 0,args[2].length());
            String finalTest = new String(byteArray);
            if (finalTest.equals(args[2])){
                file.seek(file.length());
                file.write("true".getBytes());
            }
            else
            {
                file.seek(file.length());
                file.write("false".getBytes());
            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
