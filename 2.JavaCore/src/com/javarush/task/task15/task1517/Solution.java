package com.javarush.task.task15.task1517;


/*
Статики и исключения
*/
class NewException extends Exception {
            NewException(){
                //System.out.println(this);
            }
        }
public class Solution {
    public static int A = 0;

    static {
        int test = 0/0;
    }




    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);

    }
}
