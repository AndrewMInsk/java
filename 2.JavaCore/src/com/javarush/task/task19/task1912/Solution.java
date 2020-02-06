package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream temp = System.out;
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream prstr = new PrintStream(test);
        System.setOut(prstr);

        testString.printSomething();
        String newStr = test.toString().replaceAll("te","??");
        System.setOut(temp);
        System.out.println(newStr);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
