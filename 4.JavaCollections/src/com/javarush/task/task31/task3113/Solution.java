package com.javarush.task.task31.task3113;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/* 
Что внутри папки?
*/


public class Solution {

    public static class Solution2 extends SimpleFileVisitor<Path> {
        public long numberFolders = 0;
        public long numberFiles = 0;
        public long sizeAll = 0;
        public Path temp;

        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            numberFiles++;
            sizeAll+=Files.size(file);
            return FileVisitResult.CONTINUE;
            //return super.visitFile(file, attrs);

        }

        public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
            //System.out.println(file.getFileName()+" "+Files.size(file));
            if(Files.isSameFile(file,temp)){

                return FileVisitResult.CONTINUE;
            }

            numberFolders++;

            return FileVisitResult.CONTINUE;
        }
    }
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        reader.close();
        Path filename = Paths.get(line);
       // System.out.println(filename.getFileName());
        if(!Files.isDirectory(filename)){
            System.out.println(filename+ " - не папка"); // D:/test/
            return;
        }
        Solution2 test = new Solution2();
        test.temp=filename;
            Files.walkFileTree(filename, test);
        System.out.println("Всего папок - "+test.numberFolders);
        System.out.println("Всего файлов - "+test.numberFiles);
        System.out.println("Общий размер - "+test.sizeAll);

    }
}
