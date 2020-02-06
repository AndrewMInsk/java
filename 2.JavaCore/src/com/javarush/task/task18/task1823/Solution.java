package com.javarush.task.task18.task1823;

import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\\1.txt
        while (true){
            String line = reader.readLine();
            if(line.toLowerCase().equals("exit")) break;
            new ReadThread(line).start();
        }


    }

    public static class ReadThread extends Thread {
        public String filename="";
        public Map<Integer,Integer> spis = new HashMap<Integer,Integer>();
        public ReadThread(String fileName) {
            this.filename=fileName;
        }
        public void run(){
            try {
                FileInputStream reader = new FileInputStream(filename);
                while (reader.available()>0){
                    int symbol = reader.read();
                    if(spis.containsKey(symbol))
                        spis.put(symbol,spis.get(symbol)+1);
                    else
                        spis.put(symbol,1);
                }
                SortedSet<Integer> set = new TreeSet<Integer>(spis.values());


                for(Map.Entry<Integer,Integer> item: spis.entrySet()){
                    if(item.getValue()==set.last()){
                        resultMap.put(filename,item.getKey());
                    }
                }
                reader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("!");
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
