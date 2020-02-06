package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        int[] list1 = new int[5];
        for (int i =0; i<list1.length;i++) {
            list1[i] = (int) (Math.random()*5);
        }
        int[] list2 = new int[2];
        for (int i =0; i<list2.length;i++) {
            list2[i] = (int) (Math.random()*5);
        }
        int[] list3 = new int[4];
        for (int i =0; i<list3.length;i++) {
            list3[i] = (int) (Math.random()*5);
        }
        int[] list4 = new int[7];
        for (int i =0; i<list4.length;i++) {
            list4[i] = (int) (Math.random()*5);
        }
        int[] list5 = new int[0];
        for (int i =0; i<list5.length;i++) {
            list5[i] = (int) (Math.random()*5);
        }

        ArrayList<int[]> final1 = new ArrayList<int[]>();
        final1.add(list1);
        final1.add(list2);
        final1.add(list3);
        final1.add(list4);
        final1.add(list5);

        return final1;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
