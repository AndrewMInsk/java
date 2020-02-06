package com.javarush.task.task32.task3203;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/*
Пишем стек-трейс
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) throws IOException {
        FileWriter eww = new FileWriter("sdf");
        StringWriter blabla = new StringWriter();
        PrintWriter writer = new PrintWriter(eww);
        throwable.printStackTrace(writer);

        return blabla.toString();
    }
}