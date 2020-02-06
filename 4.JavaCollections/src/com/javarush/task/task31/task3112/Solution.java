package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt",
                Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
       // System.out.println(downloadDirectory);
        URL test = new URL(urlString);
        InputStream inputStream = test.openStream();
        Path tempFile = Files.createTempFile("", ".txt");
        Files.copy(inputStream,tempFile, StandardCopyOption.REPLACE_EXISTING);
        String finalPath  =downloadDirectory+"/"+ test.toString().substring(test.toString().lastIndexOf("/"));
        Files.move(tempFile,Paths.get(finalPath));
        return Paths.get(finalPath);
    }
}
