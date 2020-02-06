package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream out = System.out;
        ByteArrayOutputStream arrayBytes = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(arrayBytes);
        System.setOut(stream);


        testString.printSomething();
        System.setOut(out);
        String test = arrayBytes.toString();

            String[] temp = test.split("\\n|\\r\\n");

            for(int i=0;i<temp.length;i++) {
                if(i%2==0&&i!=0) {
                    System.out.println("JavaRush - курсы Java онлайн");
                }
                System.out.println(temp[i]);

            }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
