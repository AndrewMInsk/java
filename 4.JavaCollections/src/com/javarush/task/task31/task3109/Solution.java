package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {

        fileName = fileName.replace("/", File.separator);
        Properties prop = new Properties();


        try {
            if (fileName.endsWith(".xml")) {
                prop = new Properties();
                prop.loadFromXML(new FileInputStream(fileName));

            } else {
                prop = new Properties();
                prop.load(new FileInputStream(fileName));
            }
        }
        catch (Exception e){
            System.out.println("oops");
            //e.printStackTrace();
        }
        return prop;
    }
}
