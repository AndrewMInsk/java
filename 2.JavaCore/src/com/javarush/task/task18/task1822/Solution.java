package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = reader.readLine();
        //String filename="D:\\1.txt";
       // System.out.println(args[0]);

        BufferedReader reader2 = new BufferedReader(new FileReader(filename));
        String line="";
        while(true){
            line = reader2.readLine();
            if(line==null) break;

            int nomer = line.indexOf(" ");
            if(nomer!=-1) {
                String id = line.substring(0, nomer);
                //System.out.println(id);
                if (id.equals(args[0])) {
                    System.out.println(line);
                    break;
                }
            }


        }
        reader2.close();
    }
}
