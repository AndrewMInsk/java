package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String sDate1=reader.readLine();
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(sDate1);
            String pattern = "MMM dd, yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
            String date2 = simpleDateFormat.format(date1);
            date2 = date2.toUpperCase();
            System.out.println(date2);


        }
        catch (ParseException e ){
            System.out.println(e);
            System.out.println("Вы ввели ерунду");
        }


    }
}
