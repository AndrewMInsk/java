package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filename1);
        byte[] temper = new byte[inputStream.available()];
        for (int i=0;inputStream.available()>0;i++){
            temper[i]=(byte)inputStream.read();
        }

        FileOutputStream outputStream1 = new FileOutputStream(filename1);
        FileInputStream inputStream1 = new FileInputStream(filename2);

        while(inputStream1.available()>0){
            outputStream1.write(inputStream1.read());
        }
        for (int i=0;temper.length>i;i++){
            outputStream1.write(temper[i]);
        }
        outputStream1.close();
        inputStream1.close();
        inputStream.close();



    }
}
