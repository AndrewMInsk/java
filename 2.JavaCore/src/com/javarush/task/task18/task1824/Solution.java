package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //D:\\1.txt
        while (true){
            String line = reader.readLine();
            FileInputStream read = null;

            try{
                read = new FileInputStream(line);
            }
            catch(FileNotFoundException e){
                System.out.println(line);
                break;
            }
            finally {
                if(!(read==null)) {
                    read.close();
                }
            }

        }
    }
}
