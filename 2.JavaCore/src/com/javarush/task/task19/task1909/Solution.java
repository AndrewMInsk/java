package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:\1.txt
        String filename1="";
        String filename2="";

        try {
            filename1 = reader.readLine();
            filename2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        //filename1 = "D:\\1.txt";
        //filename2 = "D:\\2.txt";

        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename2));

        while (fileReader.ready()){
            String line = fileReader.readLine();
            line = line.replaceAll("\\.","!");
            fileWriter.write(line);
            //System.out.println(line);
        }
        //System.out.println(sj);
        fileReader.close();
        fileWriter.close();
    }
}
