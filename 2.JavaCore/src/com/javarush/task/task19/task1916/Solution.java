package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            //FileReader reader1 = new FileReader("D:\\Project\\JavaRush\\1.txt");
            //FileReader reader2 = new FileReader("D:\\Project\\JavaRush\\2.txt");
            FileReader reader1 = new FileReader(file1);
            FileReader reader2 = new FileReader(file2);
            BufferedReader fileReader1 = new BufferedReader(reader1);
            BufferedReader fileReader2 = new BufferedReader(reader2);

            String line1;
            String line2;
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            while ((line1 = fileReader1.readLine()) != null) {
                list1.add(line1);
            }
            while ((line2 = fileReader2.readLine()) != null) {
                list2.add(line2);
            }

            while(list1.size() != 0 && list2.size() != 0){
                if(list1.get(0).equals(list2.get(0))){
                    lines.add(new LineItem(Type.SAME, list1.remove(0)));
                    list2.remove(0);
                } else if(list1.size() != 1 && list1.get(1).equals(list2.get(0))){
                    lines.add(new LineItem(Type.REMOVED, list1.remove(0)));
                } else if(list2.size() != 1 && list1.get(0).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.ADDED, list2.remove(0)));
                }
            }

            if(list1.size() != 0) {
                lines.add(new LineItem(Type.REMOVED, list1.remove(0)));
            } else if(list2.size() != 0) {
                lines.add(new LineItem(Type.ADDED, list2.remove(0)));
            }

            for (LineItem item: lines) {
                System.out.println(item.type + " " + item.line);
            }

            reader1.close();
            reader2.close();
            fileReader1.close();
            fileReader2.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

    }
}
