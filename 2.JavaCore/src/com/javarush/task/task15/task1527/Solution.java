package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        if(line.contains("?")) {

            int index = line.indexOf("?");
            String newLine = line.substring(index+1); //обрезка
            List<String> list = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            List<Double> list3 = new ArrayList<Double>();
            List<String> list4 = new ArrayList<String>();

            for (String item : newLine.split("&", 0))
            {

                if(item.contains("=")){
                    int index2 = item.indexOf("=");
                    String newLine1 = item.substring(0,index2);
                    String newLine2 = item.substring(index2+1);
                    list.add(newLine1);
                    list2.add(newLine2);

                    if (newLine1.indexOf("obj") != -1) {
                        try {
                            double d1 = Double.parseDouble(newLine2);
                            list3.add(d1);
                        } catch
                        (Exception e) {
                            list4.add(newLine2);
                        }
                    }

                }
                else{
                    list.add(item);
                }


            }


            for(String item: list){
                System.out.print(item+" ");
            }
            System.out.println();
            for(double item: list3){
                    alert(item);
            }
            for(String item: list4){
                    alert(item);
            }


        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
