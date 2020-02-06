package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.out.println(args[0]);

        FileInputStream inputStream = new FileInputStream(args[0]);
        int counter=0;
        while(inputStream.available()>0) {
            int test = inputStream.read();
            //System.out.println(test);
            if(65<=test&&test<=90) {
                counter++;
            }
            if(97<=test&&test<=122) {
                counter++;
            }
        }
        System.out.println(counter);
        inputStream.close();

    }
}
