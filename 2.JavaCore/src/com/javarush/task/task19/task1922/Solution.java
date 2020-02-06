package com.javarush.task.task19.task1922;

import sun.security.util.Length;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("А");
        words.add("Б");
        words.add("В");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:\1.txt
        String filename1="";
        String filename2="";

        try {
            filename1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

       //filename1 = "D:\\1.txt";

        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        String line="";
        int counter=0;
        while ((line=fileReader.readLine())!=null){
            counter=0;
            String ImLine = line;

            line = line.replaceAll("A-zА-а ","");

            String[] test = line.split(" ");


            for(int i = 0; i<test.length;i++){

                for(String item: words) {
                    if (item.equals(test[i])){
                        counter++;
                    }
                }


            }

            //System.out.println(ImLine+" Остаток: "+line+" "+counter);

            if(counter==2){
                System.out.println(ImLine);
            }
            //System.out.println(counter);
        }
        reader.close();
        fileReader.close();
    }
}
