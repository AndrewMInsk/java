package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prop = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1="";


        try {
            filename1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
       // filename1 = "D:\\1.txt";

        FileInputStream reader1 = new FileInputStream(filename1);
        load(reader1);
        System.out.println(properties);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties test = new Properties();
        test.putAll(properties);
        test.store(outputStream,"");


    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
                   prop.load(inputStream);
                for(String item: prop.stringPropertyNames()){
                properties.put(item,prop.getProperty(item));
                }
    }

    public static void main(String[] args) throws Exception {
        String filename2="";
        filename2 = "D:\\3.txt";
        Solution test = new Solution();
        test.fillInPropertiesMap();
        FileOutputStream writer = new FileOutputStream(filename2);
        test.save(writer);
    }
}
