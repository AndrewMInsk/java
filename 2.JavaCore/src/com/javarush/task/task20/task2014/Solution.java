package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        FileInputStream file1 = null;
        try {
            file1 = new FileInputStream("D:\\3.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream iStream = null;
        try {
            iStream = new ObjectInputStream(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream file2 = null;
        try {
            file2 = new FileOutputStream("D:\\3.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oStream = null;
        try {
            oStream = new ObjectOutputStream(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Solution savedObject = new Solution(55);
        System.out.println(savedObject);
        try {
            oStream.writeObject(savedObject);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Solution loadedObject = new Solution(22);
        loadedObject = (Solution)iStream.readObject();
        System.out.println(loadedObject);

        System.out.println(savedObject.string.equals(loadedObject.string));
        iStream.close();
        oStream.close();
        file1.close();
        file2.close();
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
     String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
