package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(args[0],"rw");
        if(file.length()>args[2].length()+Integer.parseInt(args[1])){
        file.seek(Integer.parseInt(args[1]));
        file.write(args[2].getBytes());
            //System.out.println("!");
        }
        else {
           // System.out.println("?");
            file.seek(file.length());
            file.write(args[2].getBytes());
        }
    }
}
