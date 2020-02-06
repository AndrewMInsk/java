package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) throws IOException {
        try{
        Path test = Paths.get(pathToFile);


            //fileData.isDirectory();



        fileData= new ConcreteFileData(Files.isHidden(test),Files.isExecutable(test),
                Files.isDirectory(test), Files.isWritable(test));
        }
        catch(Exception e){
            fileData=new NullFileData(new Exception());
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
