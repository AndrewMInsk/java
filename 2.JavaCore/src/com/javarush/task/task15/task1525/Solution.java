package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

        static{
            FileInputStream fileReader = null;
            try {
                fileReader = new FileInputStream(Statics.FILE_NAME);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // поток, который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
            // соединяем FileReader с BufferedReader
            String line="";
            while (true){
                try {
                    if (!((line=bufferedReader.readLine())!=null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                lines.add(line);
            }
        }
    public static void main(String[] args) throws IOException {




        System.out.println(lines);

    }
}
