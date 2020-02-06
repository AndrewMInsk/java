package com.javarush.task.task20.task2025;


import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long summer(long number){
        long sum=0;
        int step = getCountNumber(number);
        for (Long item : getPrimitiveNumber(number)) {
            sum += Math.pow(item, step);
        }
        return sum;
    }

    public static List<Integer> generate(long number){
            //120
        List<Integer> list = new ArrayList<Integer>();
        int dlina = (number+"").length();
        long fNumber=0;
        while(number>fNumber)
        {

            StringBuilder strBuffer = new StringBuilder("");
            while (strBuffer.length()<dlina) {
                for (int i = 0; i < 10; i++) {
                    strBuffer.append(i);
                }
            }


            fNumber= Integer.parseInt(strBuffer.toString());
            System.out.println(fNumber);
        }




        return list;
    }

    public static long[] getNumbers(long N) {
        getCountNumber(N);
        //long[] multiArray = new long[N];


        TreeMap<Long,Long> finish = new TreeMap<Long, Long>();
//        for(long i=0;i<N;i++){
//
//            if(getUnique(i)) {
//                long sum = summer(i);
//                if (sum == i) {
//                    finish.put(i, sum);
//                }
//
//                else
//                    if(summer(summer(i))==summer(i)){
//                        //System.out.println(summer(i)+" ! "+i+" "+summer(summer(i)));
//                        finish.put(summer(i), summer(i));
//                        //System.out.println(summer(i));
//                    }
//            }
//
//        }

        Object[] result1 = finish.keySet().toArray();
        long[] result= new long[result1.length];
        for(int i=0;i<result1.length; i++){
            result[i]=Long.parseLong(result1[i].toString());
        }
        if (result != null) {
        return result;
        }
        else return null;

    }

    public static int getCountNumber(long number){
        int counter;
        counter = number==0? 1 : 0;
        while (number!=0){
            number/=10;
            counter++;
        }
        return counter;
    }
    public static ArrayList<Long> getPrimitiveNumber(long number){
        ArrayList<Long> temp = new ArrayList<Long>();
        long numberBack = number;
        int j = (int) Math.pow(10, getCountNumber(numberBack)-1);

        for(int i=1;i<getCountNumber(numberBack)+1;i++){ long test = number/j;
           temp.add(test);
           number%=j;
           j/=10;
       }

        return temp;
    }

    public static boolean getUnique(long number){
        int kolvo = (number+"").length();
        int currentNumber = 0;
        for(int i=0;i<kolvo;i++){
            if(number%10<currentNumber) return false;
            currentNumber= (int) (number%10);
            number/=10;
        }
        return true;
    }

    public static void main(String[] args) {
        long freeMemory = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        long[] result1 = getNumbers(0);
        for(int i=0;i<result1.length; i++){
            System.out.println(result1[i]);
        }
       // System.out.println(summer(summer(11)));
       // System.out.println(summer(11));
        System.out.println("!"+generate(1200));
       //System.out.println(getUnique(865421110));

        long finishTime = System.currentTimeMillis();
        long freeMemory2 = Runtime.getRuntime().freeMemory();
        System.out.println("Время:" + (finishTime-startTime));
        System.out.println("Память:" + (freeMemory-freeMemory2));
    }
}
