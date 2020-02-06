package com.javarush.task.task16.task1632;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static{
        threads.add(new Thread1("Нить 1"));
        threads.add(new Thread2("Нить 2"));
        threads.add(new Thread3("Нить 3"));
        threads.add(new Thread4("Нить 4"));
        threads.add(new Thread5("Нить 5"));
    }


    public static void main(String[] args) throws InterruptedException {
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();

        //threads.get(1).interrupt();
        //Thread.sleep(3333L);
        //((Thread4)threads.get(3)).showWarning();


    }
    public static class Thread1 extends Thread{
        Thread1(String name){
            super(name);
        }
       public void run(){
           try {
               while (!isInterrupted()) {
                   sleep(5000);
               }

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
    }
    public static class Thread2 extends Thread{
        Thread2(String name){
            super(name);
        }
        public void run(){
            //System.out.println(currentThread().getName() + " старт");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 extends Thread{
        Thread3(String name){
            super(name);
        }
        public void run(){
            //System.out.println(currentThread().getName() + " старт");
            try {
                while (!isInterrupted()) {
                    System.out.println("Ура");
                    sleep(500);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class Thread4 extends Thread implements Message{
        Thread4(String name){
            super(name);
        }
        public void run(){
            //System.out.println(currentThread().getName() + " старт");
            try {
                while (!isInterrupted()) {
                    sleep(2000);
                   // System.out.println(currentThread().getName() + " работает");
                }
            } catch (InterruptedException e) {
               // System.out.println(currentThread().getName() + " стоп");
            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }
    public static class Thread5 extends Thread{
        Thread5(String name){
            super(name);
        }
        public void run(){
            //System.out.println(currentThread().getName() + " старт");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum=0;

            while (true){
                try {
                    String line = reader.readLine();
                    if(line.equals("N")){
                        System.out.println(sum);
                        break;
                    }
                    sum+=Integer.parseInt(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}