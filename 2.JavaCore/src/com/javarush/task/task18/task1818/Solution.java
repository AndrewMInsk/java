package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream inputStream1 = new FileOutputStream(br.readLine());
        FileInputStream inputStream2 = new FileInputStream(br.readLine());
        FileInputStream inputStream3 = new FileInputStream(br.readLine());


        while (inputStream2.available()>0){
            inputStream1.write(inputStream2.read());
        }
        while (inputStream3.available()>0){
            inputStream1.write(inputStream3.read());
        }
        inputStream1.close();
        inputStream2.close();
        inputStream3.close();


    }
}
