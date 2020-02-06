package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));

    }

    public static String factorial(int n) {
        //add your code here
        BigInteger fact = BigInteger.valueOf(1);
        if(n<0){
            return String.valueOf(0);
        }
        if(n==0){
            return String.valueOf(1);
        }
        for(BigInteger i = BigInteger.valueOf(n); i.compareTo(BigInteger.valueOf(1))!=-1;
            i=i.subtract(BigInteger.valueOf(1))){
            fact = fact.multiply(i);
        }
        return String.valueOf(fact);
//            if(n!=1){
//                return factorial(n-1)*n;
//            }
//            else return 1;
    }
}
