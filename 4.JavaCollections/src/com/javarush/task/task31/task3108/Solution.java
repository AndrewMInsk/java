package com.javarush.task.task31.task3108;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Исследуем Path
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("D:/test/data/firstDir");
        Path path2 = Paths.get("D:/test/data/secondDir/third");
        Path resultPath = getDiffBetweenTwoPaths(path1, path2);
        System.out.println(resultPath);
        InputStream test = new FileInputStream("dsf");
        Properties properties = new Properties();
        properties.load(new FileReader("sdf"));
PrintWriter er = new PrintWriter(new FileWriter("dfsd"),true);
    //expected output '../secondDir/third' or '..\secondDir\third'
    }

    public static Path getDiffBetweenTwoPaths(Path path1, Path path2) {

        return path1.relativize(path2);
    }
}
