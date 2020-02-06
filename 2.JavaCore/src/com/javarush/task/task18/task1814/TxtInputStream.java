package com.javarush.task.task18.task1814;

import com.sun.javafx.binding.StringFormatter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
            super(fileName);
            fileName.length();
            String firstChar = fileName.substring(fileName.length()-4);
            if(!firstChar.equals(".txt"))
            {
                super.close();
                throw new UnsupportedFileNameException();
            }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        String fileName= "swerewr.txt";
        String firstChar = fileName.substring(fileName.length()-3);
       // System.out.println(firstChar);
            new TxtInputStream(fileName);

    }
}

