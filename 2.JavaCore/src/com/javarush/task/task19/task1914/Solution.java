package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream temp = System.out;
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream prstr = new PrintStream(test);
        System.setOut(prstr);

        testString.printSomething();
        String all = test.toString();

        all = all.replace(System.lineSeparator(), "");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(all);
        System.setOut(temp);
        List<Integer> list = new ArrayList<Integer>();
        while (matcher.find()) {
            int start=matcher.start();
            int end=matcher.end();


            int number = Integer.parseInt(all.substring(start,end));

            list.add(number);
        }
        Pattern pattern2 = Pattern.compile("\\+|\\-|\\*|\\/");
        Matcher matcher2 = pattern2.matcher(all);

        String oper="";
        while (matcher2.find()) {
            int start=matcher2.start();
            int end=matcher2.end();
            oper = all.substring(start,end);
            //System.out.println(oper);
        }
        //System.out.println(list);

        if (oper.equals("+")){
            System.out.println(all + (list.get(0)+list.get(1)));
        }
        if (oper.equals("-")){
            System.out.println(all + (list.get(0)-list.get(1)));
        }
        if (oper.equals("*")){
            System.out.println(all + (list.get(0)*list.get(1)));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

