package com.javarush.task.task17.task1710;

import com.sun.javafx.binding.StringFormatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));
        //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));
        //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //List<String> listData = new ArrayList<String>();
        //System.out.println(args);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String input = reader.readLine();
//        String command = input.substring(0, 2); //обрезка, возвращает очищенную
//        //System.out.println(command);
//        String data = input.substring(2).trim();
        //System.out.println(data);

       // String command = args[0];


//        for (String item : data.split(" ")) {
//            listData.add(item);
//        }

        switch (args[0]){
            case "-c":{
                Date date1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                        .parse(args[3]);
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], date1));
                } else
                    allPeople.add(Person.createFemale(args[1], date1));
                System.out.println(allPeople.size()-1);
                break;
            }
            case "-u":{
                Date date1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                        .parse(args[4]);
                Person people = allPeople.get(Integer.parseInt(args[1]));
                people.setBirthDate(date1);
                people.setName(args[2]);
                if (args[3].equals("м")) {
                    people.setSex(Sex.MALE);
                } else {
                    people.setSex(Sex.FEMALE);
                }
                break;
            }
            case "-d":{
                Person people = allPeople.get(Integer.parseInt(args[1]));
                // System.out.println(people);
                people.setSex(null);
                people.setName(null);
                people.setBirthDate(null);
                //allPeople.set(Integer.parseInt(args[1]),null);
                break;
            }
            case "-i":{
                Person people = allPeople.get(Integer.parseInt(args[1]));
                // System.out.println(people);
                String pattern = "dd-MMM-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
                String date1 = simpleDateFormat.format(people.getBirthDate());

                String sexer = "";
                if (people.getSex().equals(Sex.MALE)) {
                    sexer = "м";
                }
                else sexer = "ж";

                System.out.println(String.format("%s %s %s",people.getName(),sexer,date1));
                break;
            }
        }

        //System.out.println(allPeople);

    }

}
