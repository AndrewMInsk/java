package com.javarush.task.task20.task2026;

import java.util.Arrays;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 5");
        //int count2 = getRectangleCount(a2);
        //System.out.println("count = " + count2 + ". Должно быть 4");


    }



    public static int getRectangleCount(byte[][] a) {

        byte[][] b= Arrays.copyOf(a,a.length);


        int dlina = b.length;
        int bot=0;
        int bot2=0;
        int counter=0;
        for(int i=0;i<dlina;i++){
//            byte[][] a1 = new byte[][]{
//            {1, 1, 0, 0, 0, 0},
//            {1, 1, 0, 1, 1, 0},
//            {1, 1, 0, 0, 0, 0},
//            {1, 1, 0, 1, 0, 0},
//            {0, 0, 0, 1, 0, 0},
//            {1, 1, 0, 1, 0, 1}
//            };
            // i строка
            for(int j=0;j<dlina;j++) {
                if(b[i][j]==1){


                    int tempi=i;
                    int tempj=j;
                    boolean pointer=false;
                    while (b[tempi][tempj]==1){
                       b[tempi][tempj]=0;
                        System.out.println("Делаем строку: "+tempi+" "+ tempj);
                        int temptemp = tempi;
                        if(tempi<dlina-1) {
                            tempi++;
                            pointer=false;
                        }
                        while (b[tempi][tempj]==1){
                            pointer=true;
                            System.out.println("Делаем столбец: "+ tempi +" "+tempj);
                            b[tempi][tempj]=0;
                            if(tempi<dlina-1) {
                                tempi++;
                            }
                        }


                        if(tempj<dlina-1) {
                            tempj++;
                        }
                            tempi = temptemp;

                    }


                    System.out.println("Поинтер: "+ tempi +" "+tempj+" "+pointer);
                    counter++;
                    System.out.println("Закончили +1 = " + counter);
                    pointer=false;

                }
            }
            System.out.println("Результат ----------------------");
            for(int is=0;is<dlina;is++){

                for(int js=0;js<dlina;js++) {
                    if(a[is][js]==1){
                        a[is][js]=1;
                    }
                    System.out.print(a[is][js]+" ");


                }
                System.out.println();
            }

            }


        return counter;
    }
}
