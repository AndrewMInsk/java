package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable{
    private transient Thread runner;
    private int speed;
    private String str =  "Да бля";

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    @Override
    public String toString() {
        return "Solution{" +
                "runner=" + runner +
                ", speed=" + speed +
                ", str='" + str + '\'' +
                '}';
    }

    public void run() {

        //System.out.println("!");
        try {
            while(!runner.isInterrupted()) {
                runner.sleep(speed);
                System.out.println("!");
            }
        } catch (InterruptedException e) {
            System.out.println("Прервали");
            e.printStackTrace();
        }
        // do something here, doesn't matter what
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread test2 =  new Thread(this);
        test2.start();
    }

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {

        String filename="D:\\2.txt";
        FileInputStream itest = new FileInputStream(filename);
        FileOutputStream otest = new FileOutputStream(filename);
        ObjectOutputStream oStream = new ObjectOutputStream(otest);
        ObjectInputStream iStream = new ObjectInputStream(itest);


        Solution test3 = new Solution(20);
        oStream.writeObject(test3);
        test3 = (Solution)iStream.readObject();

        Thread.sleep(2000);
        test3.runner.interrupt();
    }
//    private Object readResolve() {  // служит для вызова какого-то метода после чтения объекта (пример с синглтоном, сразу вызывается getInstance())
//        System.out.println("test");
//        return this;
//    }
}
