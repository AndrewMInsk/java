package com.javarush.task.task31.task3103;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* 
Своя реализация
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        System.out.println("!");
        List<String> test= readLines("D:\\1.txt");
        System.out.println(test);
    }
    public static byte[] readBytes(String fileName) throws IOException {
        byte[] test = Files.readAllBytes(Paths.get(fileName));
        return test;
    }

    public static List<String> readLines(String fileName) throws IOException {


        List<String> test = Files.readAllLines(Paths.get(fileName));

        return test;
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.write(Paths.get(fileName),bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        byte[] tet = Files.readAllBytes(Paths.get(resourceFileName));
        Files.write(Paths.get(destinationFileName),tet);
    }
}
