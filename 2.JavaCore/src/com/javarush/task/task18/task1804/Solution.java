package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\1.txt
        String filename = "";
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        FileInputStream reader2=null;
        try{
            filename = reader.readLine();
            reader2 = new FileInputStream(filename);

            while (reader2.available()>0){
                int readme = reader2.read();
                if(map.containsKey(readme)){map.put(readme,map.get(readme)+1); }
                else {
                    map.put(readme, 1);
                }
                //System.out.println(readme);
            }
        }
        catch (Exception e){
            System.out.println("Ошибка чтения");
        }
        finally {
            try {
                reader.close();
                reader2.close();
            }
            catch (Exception e){
                System.out.println("Ошибка закрытия");
            }
        }
        Integer minValue=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> item : map.entrySet()) {
            if(item.getValue()<minValue){
                minValue = item.getValue();
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> item : map.entrySet()) {
            if(item.getValue()==minValue){
                list.add(item.getKey());
            }
        }

        StringJoiner sj = new StringJoiner(" ");

        for(Integer item: list)
        {
            sj.add(String.valueOf(item));

        }
        System.out.println(sj);

    }
}
