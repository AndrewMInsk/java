package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\\1.txt
        String filename = reader.readLine();
        //String filename = "D:\\1.txt";
        if(args.length != 0 && args[0].equals("-c")) {
            BufferedReader readerFile = new BufferedReader(new FileReader(filename));
            int maxId=0;
            while(true){
                String line = readerFile.readLine();
                if(line==null||line.isEmpty()){
                    break;
                }
                // get IDs
                String idStr = line.substring(0,8).trim();
                int id = Integer.parseInt(idStr);
                if(id>maxId){
                    maxId=id;
                }
                //System.out.println(id);
                //get names
                String name = line.substring(8,38);
                name = name.trim();
                //System.out.println(name);
                //get prices
                String priceStr = line.substring(38,46);
                priceStr = priceStr.trim();
                double price = Double.parseDouble(priceStr);
                //System.out.println(price);
                //get quantity
                String quantityStr = line.substring(46,50);
                quantityStr = quantityStr.trim();
                int quantity = Integer.parseInt(quantityStr);
                //System.out.println(quantity);
                // нахера я распарсил все? Нужен был только Id же....
            }
            FileWriter writerFile = new FileWriter(filename,true);
            String line = "\n";
            String idStr = String.valueOf(maxId+1);
            while(idStr.length()<8){
                idStr= idStr+" ";
            }
            String nameStr = args[1];
            while(nameStr.length()<30){
                nameStr= nameStr+" ";
            }
            String priceStr = args[2];
            while(priceStr.length()<8){
                priceStr= priceStr+" ";
            }
            String quantityStr = args[3];
            while(quantityStr.length()<4){
                quantityStr= quantityStr+" ";
            }
            writerFile.write(line+idStr+nameStr+priceStr+quantityStr);
            writerFile.close();
            readerFile.close();

        }
        reader.close();


    }
}
