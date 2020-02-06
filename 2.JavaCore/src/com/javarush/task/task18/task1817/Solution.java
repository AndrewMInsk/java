package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.out.println(args[0]);

        FileInputStream inputStream1 = new FileInputStream(args[0]);
        int counter=0;
        int counter2=0;
        while(inputStream1.available()>0) {
            int test = inputStream1.read();
            //System.out.println(test);

            if(32==test) {
                counter++;
            }
              counter2++;
        }
        double res = counter*1.0/counter2*100.0;
        //System.out.println(res);
        double bd = Math.round(res*100)/100.00;

        inputStream1.close();
        System.out.println(bd);

    }
}
