package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader=null;
        try{
            while(true) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                String answer = reader.readLine();
                if(answer.toLowerCase().equals("exit")){break;}

                double toDouble=0;
                try {
                    toDouble = Double.parseDouble(answer);
                }
                catch (NumberFormatException e){
                    print(answer);
                    continue;
                }

                if(answer.contains(".")){
                    print(toDouble);
                    continue;
                }

                int toInt = Integer.parseInt(answer);
                 if(toInt>0&&toInt<128){
                    print((short) toInt);
                     continue;
                  }
                if(toInt<=0||toInt>=128){
                    print(toInt);
                    continue;
                }
                print(answer);

            }
        }
        catch (Exception e){
            //System.out.println(e);
        }
        finally {
            reader.close();
        }


    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
