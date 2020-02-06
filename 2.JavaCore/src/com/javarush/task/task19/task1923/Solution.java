package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter writer = new FileWriter(args[1]);
        String line ="";
        List<String> list = new ArrayList<String>();
        while ((line=reader.readLine())!=null){

            String[] minilist = line.split(" ");
            for(int i=0;i<minilist.length;i++) {
                Pattern pattern = Pattern.compile("(\\d+)");
                Matcher matcher = pattern.matcher(minilist[i]);
                if (matcher.find()) {
                    list.add(minilist[i]);
                }
            }

        }

        StringBuffer sb = new StringBuffer();
        for(String item : list){
            sb.append(item).append(" ");
        }
        writer.write(sb.toString());
        reader.close();
        writer.close();
        fileReader.close();

    }
}
