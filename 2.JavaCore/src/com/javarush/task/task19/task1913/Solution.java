package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream temp = System.out;
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream prstr = new PrintStream(test);
        System.setOut(prstr);

        testString.printSomething();
        String newStr = test.toString().replaceAll("[^0-9]","");
        System.setOut(temp);
        System.out.println(newStr);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
