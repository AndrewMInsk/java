package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\\1.txt
        String filename = reader.readLine();
        //String filename = "D:\\1.txt";
        if(args.length != 0 && args[0].equals("-u")) {
            BufferedReader readerFile = new BufferedReader(new FileReader(filename));
            List<String> list = new ArrayList<String>();
            while(true) {
                String line = readerFile.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                // get IDs
                String idOld = line.substring(0, 8);
                String idStr = line.substring(0, 8).trim();

                int id = Integer.parseInt(idStr);

                if(!(id==Integer.parseInt(args[1]))){
                    list.add(line);
                }
                else{

                    String nameStr = args[2];
                    while(nameStr.length()<30){
                        nameStr= nameStr+" ";
                    }
                    String priceStr = args[3];
                    while(priceStr.length()<8){
                        priceStr= priceStr+" ";
                    }
                    String quantityStr = args[4];
                    while(quantityStr.length()<4){
                        quantityStr= quantityStr+" ";
                    }

                    line = idOld+nameStr+priceStr+quantityStr;
                    list.add(line);

                }
            }

            FileWriter writer = new FileWriter(filename);
                for(String item: list){
                    writer.write(item+"\n");
                }
            readerFile.close();
            writer.close();
        }
        if(args.length != 0 && args[0].equals("-d")) {
            BufferedReader readerFile = new BufferedReader(new FileReader(filename));
            List<String> list = new ArrayList<String>();
            while(true) {
                String line = readerFile.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                // get IDs
                String idStr = line.substring(0, 8).trim();
                int id = Integer.parseInt(idStr);

                if(!(id==Integer.parseInt(args[1]))){
                    list.add(line);
                }
            }

            FileWriter writer = new FileWriter(filename);
            for(String item: list){
                writer.write(item+"\n");
            }
            readerFile.close();
            writer.close();

        }
        reader.close();
    }
}
