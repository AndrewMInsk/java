package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter{
    private FileWriter fileWriter ;


    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter=new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter=new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter=new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter=new FileWriter(fd);
    }


    public void write(int c) throws IOException {
        System.out.println(c);
        fileWriter.write(c);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {


for(int i=0;i<len;i++){
    System.out.print(cbuf[off+i]);
}

       // fileWriter.write(cbuf);
      //  fileWriter.write("\n");
        fileWriter.write(cbuf, off, len);
    }


    public void write(String str, int off, int len) throws IOException {
        String newstr = str;
        newstr= newstr.substring(off,off+len);
        System.out.println(newstr);
        fileWriter.write(str, off, len);
    }


    public void close() throws IOException {
        fileWriter.close();
    }


    public void write(char[] cbuf) throws IOException {
        System.out.println(cbuf);
        fileWriter.write(cbuf);    }


    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public static void main(String[] args) throws IOException {
        String filename1 = "D:\\1.txt";
       FileConsoleWriter consWriter = new FileConsoleWriter(filename1);
       char[] test = new char[33];
       for(int i=0;i<test.length;i++){
           test[i]=(char)(30+i);
       }

        consWriter.write(test,5,5);

        consWriter.close();

    }

}
