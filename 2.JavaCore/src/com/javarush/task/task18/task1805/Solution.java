package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\1.txt
        String filename = "";
        Set<Integer> set = new TreeSet<Integer>();

        FileInputStream reader2=null;
        try{
            filename = reader.readLine();
            reader2 = new FileInputStream(filename);

            while (reader2.available()>0){
                int readme = reader2.read();

                    set.add(readme);

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
        StringJoiner sj = new StringJoiner(" ");

        for(Integer item: set)
        {
            sj.add(String.valueOf(item));

        }
        System.out.println(sj);

    }
}