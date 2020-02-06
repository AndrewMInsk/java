package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            Pattern pattern = Pattern.compile("[^a-zA-Zа-яА-Я-]");
            String[] test = pattern.split(line);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < test.length; i++) {
                sb.append(test[i] + " ");
            }



            Pattern pattern3 = Pattern.compile("\\d+"); // все числа

            line = line.replaceAll("[a-zA-Zа-яА-Я-]","").trim();
            line = line.replaceAll("  "," ");
            String[] test2 = line.split(" ");

            Date date = new Date();
            date.setDate(Integer.parseInt(test2[0]));
            date.setMonth(Integer.parseInt(test2[1])-1);
            date.setYear(Integer.parseInt(test2[2])-1900);
            //System.out.println(date);
            PEOPLE.add(new Person(sb.toString().trim(),date));
        }
        //System.out.println(PEOPLE);
        fileReader.close();

    }
}
