package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:\1.txt
        String filename1="";

        try {
            filename1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

       //filename1 = "D:\\1.txt";

        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        String line="";
        String fline="";
        //System.out.println(args[0]);
        while ((line=fileReader.readLine())!=null) {
            fline+=line;
        }
        Document doc = Jsoup.parse(fline,"", Parser.xmlParser());
//        Elements span = doc.select("span");
//        for (Element item: span) {
//            System.out.println(item);
//        }
       // System.out.println(doc);

        Elements tag = doc.select(args[0]);

        for (Element item: tag) {
            System.out.println(item);
        }
        fileReader.close();
        reader.close();
    }
}
