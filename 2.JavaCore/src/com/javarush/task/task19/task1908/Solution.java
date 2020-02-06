package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename2,true));
        StringJoiner sj = new StringJoiner(" ");

        while (fileReader.ready()){
            String line = fileReader.readLine();
            //line = line.replaceAll("[^0-9\\s]", "");
            //line = line.replaceAll("  ", " ");
            String[] itog = line.split(" ");
            for(String s:itog) {
                try {
                    int temp = Integer.parseInt(s);
                    sj.add(s);
                }
                catch (NumberFormatException e){
                    //System.out.println("нет");
                }

            }
        }
        //System.out.println(sj);
        fileWriter.write(sj.toString());
        fileReader.close();
        fileWriter.close();
    }
}
