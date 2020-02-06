package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.util.Collections.enumeration;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        for(String item: args){
            //System.out.println(item);
        }
        Arrays.sort(args,1,args.length);

        Map<String,FileInputStream> test = new TreeMap<String,FileInputStream>();
        for(int i=1;i<args.length;i++){
            FileInputStream temp = new FileInputStream(args[i]);
            test.put(args[i],temp);
           // temp.close();
        }



        System.out.println(test);
        Enumeration enum1 = enumeration(test.values());
        SequenceInputStream sis = new SequenceInputStream(enum1);
        ZipInputStream zIn = new ZipInputStream(sis);
        FileOutputStream outputFile = new FileOutputStream(args[0],true);
        ZipEntry test2=null;
        while ((test2 = zIn.getNextEntry())!=null){
            System.out.println(test2.getName());
            byte[] zinread = new byte[1024];
            int ostatok=0;
            while ((ostatok=zIn.read(zinread))!=-1){
                //System.out.println(zinread);
                outputFile.write(zinread,0,ostatok);
            }
        }

        sis.close();
        zIn.close();
        outputFile.close();


    }
}
