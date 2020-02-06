package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = "";
        FileInputStream reader2=null;
        try{
            filename = reader.readLine();
            reader2 = new FileInputStream(filename);
            int max = 0;
            while (reader2.available()>0){
                int readme = reader2.read();
                if (max<readme){max=readme;}
            }
            System.out.println(max);
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
