package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
       // System.out.println(args[0]);
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        String line ="";
        Map<String, Double> list = new TreeMap<String,Double>();
        while((line = reader.readLine())!=null){
            //System.out.println(line);
            Pattern pattern = Pattern.compile("\\s{1}");
            String[] test = pattern.split(line);
            if(list.containsKey(test[0])){
                list.put(test[0], list.get(test[0]) + Double.parseDouble(test[1]));
            }
            else {
                list.put(test[0], Double.parseDouble(test[1]));
            }
        }
        for(Map.Entry<String,Double> item: list.entrySet() ){
            System.out.println(item.getKey() + " " + item.getValue());
        }
        fileReader.close();

    }
}
