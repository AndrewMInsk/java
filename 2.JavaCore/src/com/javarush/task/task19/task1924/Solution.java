package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
        static{

            map.put(0, "ноль");
            map.put(1, "один");
            map.put(2, "два");
            map.put(3, "три");
            map.put(4, "четыре");
            map.put(5, "пять");
            map.put(6, "шесть");
            map.put(7, "семь");
            map.put(8, "восемь");
            map.put(9, "девять");
            map.put(10, "десять");
            map.put(11, "одиннадцать");
            map.put(12, "двенадцать");

        }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:\1.txt
        String filename1="";

        try {
            filename1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        filename1 = "D:\\1.txt";
        FileReader reader1 = new FileReader(filename1);
        BufferedReader fileReader = new BufferedReader(reader1);
        String line="";
        List<Integer> listInt = new ArrayList<Integer>();
        while ((line=fileReader.readLine())!=null) {
            Pattern pattern = Pattern.compile("([^а-яA-ZА-Яa-z]\\d+)"); // все числа
            boolean stop=false;

                Matcher matcher = pattern.matcher(line);
                // матчер в шоке после сдвигания элементов. Я тоже.
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    int number = Integer.parseInt(line.substring(start, end).trim());
                    //System.out.println(number + " " + start + " " + end);

                    if (map.containsKey(number)) {
                        //System.out.println("Нашли "+ number);
                        listInt.add(number);
                    }
                //System.out.println(line);
            }
            for(Integer item: listInt){
               //System.out.println(item);
                line = line.replaceAll("\\b"+String.valueOf(item)+"\\b", map.get(item));

            }
            System.out.println(line);
        }


        reader1.close();
        fileReader.close();


    }
}
