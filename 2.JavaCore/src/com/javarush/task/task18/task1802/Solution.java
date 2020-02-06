package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = "";
        FileInputStream reader2=null;
        try{
            filename = reader.readLine();
            reader2 = new FileInputStream(filename);
            int min = Integer.MAX_VALUE;
            while (reader2.available()>0){
                int readme = reader2.read();
                if (min>readme){min=readme;}
            }
            System.out.println(min);
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

    }
}
