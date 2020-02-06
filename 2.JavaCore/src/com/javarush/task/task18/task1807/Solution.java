package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\1.txt
        String filename = "";
        filename = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filename);
        int sum=0;
        System.out.println(inputStream.available());
        while (inputStream.available()>0){
        }
        reader.close();
        inputStream.close();
        System.out.println(sum);
    }
}
