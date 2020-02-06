package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int random = 65 + (int)(Math.random()*26);
        baos.write(random);
        //System.out.println(random);
        int random2 = 97 + (int)(Math.random()*26);
        baos.write(random2);

        int random3 = 48 + (int)(Math.random()*10);
        baos.write(random3);
        for(int i=0;i<5;i++){
            int randomizer = (int)(Math.random()*3);
            switch (randomizer) {
                case (0):
                    int random4 = 65 + (int)(Math.random()*26);
                    baos.write(random4);
                    break;
                case (1):
                    int random5 = 97 + (int)(Math.random()*26);
                    baos.write(random5);
                    break;
                case (2):
                    int random6 = 48 + (int)(Math.random()*10);
                    baos.write(random6);
                    break;
            }

        }


        return baos;
    }
}