package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream tempSystem = System.out;
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(test);
        System.setOut(printStream);
        testString.printSomething();
        String finish = test.toString().toUpperCase();
        System.setOut(tempSystem);
        System.out.println(finish);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
