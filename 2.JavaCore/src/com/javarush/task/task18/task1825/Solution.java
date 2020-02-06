package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String,String> list = new TreeMap<String,String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\\1.txt
        String namer ="";

        for (int i=0;true;i++){
            String line = reader.readLine();
            if(line.equals("end")){
                break;
            }

            String name = line.substring(line.lastIndexOf(".")+1);
            if(i==0) {
                namer = line.substring(0, line.lastIndexOf("."));
                //System.out.println(namer);
            }
            list.put(name,line);
        }
        System.out.println(list);
        FileOutputStream outputStream = new FileOutputStream(namer);

        for(Map.Entry<String,String> item: list.entrySet()) {
            FileInputStream inputStream = new FileInputStream(item.getValue());
            byte[] buffer = new byte[1000];
            while (inputStream.available()>0){
                int counter = inputStream.read(buffer);
                outputStream.write(buffer, 0,counter);
            }
            inputStream.close();
        }
        outputStream.close();
        reader.close();

    }
}
