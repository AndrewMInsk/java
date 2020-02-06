package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        //System.out.println(decode(null, -3));  //Hello Amigo #@)₴?$0

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter writer = new StringWriter();
            if (reader==null){
                writer.write(" ");
                return writer.toString();
            }
        while (reader.ready()){
           int test = reader.read();
           if(test==-1){
               break;
           }
           writer.write(test+key);

       }
        return writer.toString();
    }
}
