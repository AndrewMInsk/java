package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));// с клавы

        String name1="";
        String name2="";
        try{
        name1 = reader.readLine();
        name2 = reader.readLine();
        }
        catch (Exception e){
            System.out.println("Не читается");
        }
        try{
        FileReader fileReader = new FileReader(name1); // поток, который подключается к текстовому файлу D:\1.txt D:\2.txt
        BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader
        while(bufferedReader.ready()){
            allLines.add(bufferedReader.readLine());
        }


        }
        catch (Exception e){
            System.out.println("Не читается файл");
        }
        try{
            FileReader fileReader = new FileReader(name2); // поток, который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader
            while(bufferedReader.ready()){
                forRemoveLines.add(bufferedReader.readLine());
            }
        }
        catch (Exception e){
            System.out.println("Не читается файл");
        }
        try{
            new Solution().joinData();
        }

        catch (CorruptedDataException e){
            System.out.println("CorruptedDataException");
        }
        //System.out.println(allLines);
    }

    public void joinData() throws CorruptedDataException {

                for(String item:forRemoveLines){
                    if(allLines.contains(item)){
                        allLines.remove(item);
                    }
                    else {
                        allLines.clear();
                        throw new CorruptedDataException();
                    }
                }


    }
}
