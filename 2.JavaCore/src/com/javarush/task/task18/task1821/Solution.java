package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution{
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream(args[0]);
        Map<Character,Integer> list = new TreeMap<Character,Integer>();
        while (reader.available()>0){
            char temp = (char)reader.read();
            if(list.containsKey(temp)){
                list.put(temp,list.get(temp)+1);
            }
            else list.put(temp,1);
        }

        for(Map.Entry<Character,Integer> item: list.entrySet()){
            System.out.println(item.getKey() +" "+item.getValue());
        }
        reader.close();
    }


}
