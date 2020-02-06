package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\1.txt
        String filename = "";
        String filename2 = "";
        String filename3 = "";
        filename = reader.readLine();
        filename2 = reader.readLine();
        filename3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filename);
        FileOutputStream outputStream = new FileOutputStream(filename2);
        FileOutputStream outputStream2 = new FileOutputStream(filename3);

        int sum=0;
        System.out.println(inputStream.available());
        int limit = inputStream.available()/2;

        while (inputStream.available()>limit){
            int data = inputStream.read();
            outputStream.write(data);
        }
        while (inputStream.available()>0){
            int data = inputStream.read();
            outputStream2.write(data);
        }
        reader.close();
        inputStream.close();
        outputStream.close();
        outputStream2.close();
        System.out.println(sum);
    }
}