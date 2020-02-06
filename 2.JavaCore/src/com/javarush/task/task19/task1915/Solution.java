package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:\1.txt
        String filename1="";

        try {
            filename1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //filename1 = "D:\\3.txt";


        PrintStream temp = System.out;
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(test);
        System.setOut(printStream);

        testString.printSomething();

        System.setOut(temp);
        System.out.println(test.toString());
        FileOutputStream fileWriter = new FileOutputStream(filename1);
        test.writeTo(fileWriter);
        reader.close();
        fileWriter.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

