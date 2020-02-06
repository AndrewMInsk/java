package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1="";
        String filename2="";
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        try {
            filename1 = reader.readLine();
            filename2 = reader.readLine();
            //filename1="D:\\1.txt";
           // filename2="D:\\2.txt";
        }
        catch (Exception e){
            System.out.println("Ошибка чтения");
        }
        try {
            inputStream = new FileInputStream(filename1);
            outputStream = new FileOutputStream(filename2);
        }
        catch (Exception e){
            System.out.println("Ошибка открытия файла");
        }
        String lineStrings = "";
        List<Integer> listDoubles = new ArrayList<Integer>();
        while (inputStream.available()>0){
            int temp = inputStream.read();
                lineStrings+=(char)temp;
        }
        for (String item : lineStrings.split(" ", 0)){
            Double temp = Double.parseDouble(item);
            int cel = (int)Math.round(temp);
            listDoubles.add(cel);
        }
        //System.out.println(listDoubles);
        for(int i=0;listDoubles.size()>i;i++){
            outputStream.write(String.valueOf(listDoubles.get(i)).getBytes());
            outputStream.write(32);
        }

        inputStream.close();
        outputStream.close();

    }
}
