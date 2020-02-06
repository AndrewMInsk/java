package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        //PersonScannerAdapter testik = new PersonScannerAdapter(new Scanner("sdf"));
       // System.out.println(testik.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner a){
            this.fileScanner = a;
        }
        @Override
        public Person read() throws IOException, ParseException {
            Person person;
           String line = fileScanner.nextLine();
            //String line = "Петров Петр Петрович 31 12 1957";
            Pattern pattern = Pattern.compile("\\s{1}");
            String[] list = pattern.split(line); //в массив

            Date date1=new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH)
                    .parse(list[3]+" "+list[4]+" "+list[5]);

            person = new Person( list[1], list[2], list[0],date1);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
