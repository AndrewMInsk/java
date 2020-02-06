package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String line = "";
        List<String> lines=new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.addAll(Arrays.asList(line.split(" ")));
            Iterator<String> iterator = lines.iterator();
            while(iterator.hasNext()){
                String item = iterator.next();
                if(item.length()<7){
                    iterator.remove();
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(String item: lines){
            sb.append(item).append(",");
        }

        int finals  = sb.toString().lastIndexOf(",");
       // System.out.println(finals);
        String finalsStr = sb.toString().substring(0, finals);
        writer.write(finalsStr);
        reader.close();
        fileReader.close();
        writer.close();
        fileWriter.close();
    }
}
