package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\1.txt
        String filename = "";
        String filename2 = "";

        filename = reader.readLine();
        filename2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filename);
        FileOutputStream outputStream = new FileOutputStream(filename2);
        Integer[] list = new Integer[inputStream.available()];
        int limit= inputStream.available();
        for (int i =0;i<limit;i++){
            int data = inputStream.read();
            list[i]=data;
            //System.out.println(data);
        }
        for (int i =limit-1;i>=0;i--){
            //System.out.println(list[i]);

            outputStream.write(list[i]);
        }
        reader.close();
        outputStream.close();
        inputStream.close();
    }
}
