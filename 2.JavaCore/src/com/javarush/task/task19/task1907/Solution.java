package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:\1.txt
        String filename1="";

        try {
            filename1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        String itog="";
        int counter=0;

        while ((itog = fileReader.readLine())!=null){

            itog = itog.replaceAll("[^a-zA-Zа-яА-Я]", " ");


            String[] str = itog.split(" ");

            for (int i=0;i<str.length;i++) {
               // System.out.println(str[i]);
                if(str[i].equals("world")) {
                    counter++;
                }
            }

        }


        System.out.println(counter);
        fileReader.close();
        reader.close();
    }
}
