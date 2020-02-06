package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:\1.txt
        String filename1="";

        try {
            filename1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        filename1 = "D:\\1.txt";
        FileReader reader1 = new FileReader(filename1);
        BufferedReader fileReader = new BufferedReader(reader1);
        String line="";
        String newLine="";
        while ((line=fileReader.readLine())!=null) {
            newLine="";
            char sd2 = 0;
            for(int i = line.length()-1;i>=0; i--){
               sd2 = line.charAt(i);
               newLine+=sd2;
            }
            System.out.println(newLine);
        }
        reader.close();
        reader1.close();
        fileReader.close();

    }
}
