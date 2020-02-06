package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1="";
        String filename2="";
        try {
            filename1 = reader.readLine();
            filename2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileReader fileReader=null;
        FileWriter fileWriter=null;
        try {
            fileReader = new FileReader(filename1);
            fileWriter = new FileWriter(filename2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=1;
        while (fileReader.ready()){
            int temp = fileReader.read();
           if(i%2==0) {
                    fileWriter.write(temp);
           }
           i++;
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
