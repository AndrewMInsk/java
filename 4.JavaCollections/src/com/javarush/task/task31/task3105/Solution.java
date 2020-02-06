package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Path file1 = Paths.get(args[0]).getFileName();

        ZipEntry entry;
        Map<String,ByteArrayOutputStream> allFiles = new HashMap<>();
        FileInputStream zipFile = new FileInputStream(args[1]);
        ZipInputStream zip =  new ZipInputStream(zipFile);

        String temp = "new/" + Paths.get(args[0]).getFileName();
        Path path1 = Paths.get(temp);

      //  System.out.println(Files.exists(path1));
      //  System.out.println(path1.toString());

        boolean checkerIsExists =false;
            while ((entry = zip.getNextEntry()) != null) {

               // System.out.println(entry.getName());
               // System.out.println(temp);
                if(temp.equals(entry.getName())){
                    continue;
                }

                if (!entry.isDirectory()) {
                    ByteArrayOutputStream strem = new ByteArrayOutputStream();
                    byte[] massiv = new byte[1024];
                    int ostatok = 0;
                    while ((ostatok = zip.read(massiv)) != -1) {
                        strem.write(massiv, 0, ostatok);
                    }
                    for (int i = 0; i < massiv.length; i++) {
                        //System.out.print((char)massiv[i]);
                    }



                        allFiles.put(entry.getName(), strem);

                }
                zip.closeEntry();
            }
                zip.close();
                zipFile.close();
                //System.out.println(allFiles);


           FileOutputStream zipFileOut = new FileOutputStream(args[1]);
           ZipOutputStream zipOut = new ZipOutputStream(zipFileOut);

            for (Map.Entry<String, ByteArrayOutputStream> item : allFiles.entrySet()) {
                zipOut.putNextEntry(new ZipEntry(item.getKey()));
                zipOut.write(item.getValue().toByteArray());
                zipOut.closeEntry();
            }

        try {



        if(!Files.exists(path1)) {
            zipOut.putNextEntry(new ZipEntry("new/" + Paths.get(args[0]).getFileName()));
            Files.copy(Paths.get(args[0]), zipOut);
            zipOut.closeEntry();
        }
        }
        catch (ZipException e){
            e.printStackTrace();
            System.out.println("пох");
        }
        zipOut.close();
        zipFileOut.close();

    }
}
