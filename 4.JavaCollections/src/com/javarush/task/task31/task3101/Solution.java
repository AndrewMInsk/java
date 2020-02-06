package com.javarush.task.task31.task3101;

import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {
// Рекурсией
    public  Map<String,String> temp = new TreeMap<String,String>();
    public void getAllFiles(File folder){
        for(File files:folder.listFiles()){
            if(files.length()<=50&&files.isFile()&&!files.getName().equals("allFilesContent.txt")) {
                temp.put(files.getName(), files.getAbsolutePath());
            }
            if(files.isDirectory()){
                getAllFiles(files.getAbsoluteFile());
            }
        }

    }


    public static void main(String[] args) throws IOException {
        Solution test = new Solution();
        File folder = new File(args[0]);
        File file = new File(args[1]);
        String pathFinal="";
        //if(FileUtils.isExist(file)){
        String path= file.getParent();
        pathFinal = path+ "/allFilesContent.txt";
        //file.renameTo(pathFinal);
        FileUtils.renameFile(file,new File(pathFinal));

        test.getAllFiles(folder);

        //}
        //System.out.println(folder.getCanonicalPath());



        System.out.println(test.temp);
        FileWriter writer = new FileWriter(pathFinal);


        for(Map.Entry<String,String> filename: test.temp.entrySet()){
            File file1 = new File(filename.getValue());
            FileReader reader = new FileReader(file1);
            while (reader.ready()){
                writer.write(reader.read());
            }
            writer.write("\n");
            reader.close();
            writer.flush();
        }
        writer.close();
    }
}
