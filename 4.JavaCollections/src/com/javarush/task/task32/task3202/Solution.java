package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:/1.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if(is==null){
            sw.write(" ");
            return sw;
        }
        InputStreamReader reader = new InputStreamReader(is);
        while(is.available()!=0){
            char[] temp = new char[1024];
            int long1 = reader.read(temp);
            sw.write(temp, 0, long1);
        }
        return sw;
    }
}