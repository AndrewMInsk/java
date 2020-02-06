package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(args[0]);
        if(args[0].equals("-e")){
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            while (inputStream.available()>0){
                int chars = inputStream.read();
                outputStream.write(chars+1);
            }
            inputStream.close();
            outputStream.close();
        }
        if(args[0].equals("-d")){
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            while (inputStream.available()>0){
                int chars = inputStream.read();
                outputStream.write(chars-1);
            }
            inputStream.close();
            outputStream.close();
        }
    }

}
