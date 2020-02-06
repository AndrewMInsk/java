package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t2.start();
                //add your code here - добавьте код тут
        t1.join();
        t2.join();
        t1.printResult();
        t2.printResult();

    }

    public static class Read3Strings extends Thread{
        public String line1 = "";
        public String line2 = "";
        public String line3 = "";

        public void run(){
            synchronized (reader) {
                try {
                    line1 = reader.readLine();
                    line2 = reader.readLine();
                    line3 = reader.readLine();
                } catch (IOException e) {
                    System.out.println("Не читается");
                }
            }
        }

        public void printResult() {
            String finalLine = line1 + " " + line2 + " " + line3;
            System.out.println(finalLine);
        }
    }
    //add your code here - добавьте код тут
}
