package com.javarush.task.task18.task1813;

import com.sun.javafx.binding.StringFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    private static String fileName = "C:/tmp/result.txt";
    public FileOutputStream stream;
    public AmigoOutputStream (FileOutputStream file) throws FileNotFoundException {
        super(String.valueOf(file));
        this.stream = file;
    }
    public void close() throws IOException {
        stream.flush();
        String test = "JavaRush © All rights reserved.";
        stream.write(test.getBytes());
        stream.close();
    }
    public void write(byte[] b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        stream.write(b, off, len);
    }

    public void flush() throws IOException {
        stream.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {

        new AmigoOutputStream(new FileOutputStream(fileName));

    }
}

