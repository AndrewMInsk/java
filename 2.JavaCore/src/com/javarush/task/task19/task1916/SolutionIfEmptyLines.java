package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class SolutionIfEmptyLines {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<Integer> idToSwap= new ArrayList<Integer>();
    public static void swap(int a, int b){ //0,1
        LineItem temp = lines.get(a);
        lines.set(a,lines.get(b));
        lines.set(b,temp);
    }
    public static void swapper(List<LineItem> lines){

        if(lines.get(0).type.equals(Type.SAME)
                &&(lines.get(1).type.equals(Type.ADDED)
                ||lines.get(1).type.equals(Type.REMOVED))){
            swap(0,1);
        }
        for(int i=0;i<lines.size()-1;i++){
            //System.out.println(lines.get(i).type+" "+lines.get(i+1).type);

            if(lines.get(i).type.equals(Type.ADDED)||lines.get(i).type.equals(Type.REMOVED)){
                if(lines.get(i+1).type.equals(Type.ADDED)||lines.get(i+1).type.equals(Type.REMOVED)){
                    idToSwap.add(i+1);
                    //System.out.println("В свап "+(i+1));
                }
            }
            if(lines.get(i).type.equals(Type.SAME)){
                if(lines.get(i+1).type.equals(Type.SAME)&&idToSwap.size()!=0){
                    swap(i+1,idToSwap.get(0));
                    idToSwap.remove(0);
                }
            }
        }
        if(!idToSwap.isEmpty()) {
            swapper(lines);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//D:\1.txt
        String filename1="";
        String filename2="";

        try {
            filename1 = reader.readLine();
            filename2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        filename1 = "D:\\1.txt";
        filename2 = "D:\\2.txt";
        FileReader filer1 = new FileReader(filename1);
        FileReader filer2 = new FileReader(filename2);
        BufferedReader fileReader = new BufferedReader(filer1);
        BufferedReader fileReader2 = new BufferedReader(filer2);
        String line="";
        String line2="";

        while ((line=fileReader.readLine())!=null|(line2=fileReader2.readLine())!=null){
            //System.out.println(line+" "+line2);
            if(line2!=null&&line!=null&&line.equals(line2)&&!line.isEmpty()){
                lines.add(new LineItem(Type.SAME,line));
                continue;
            }
            if(line2!=null&&line!=null&&line.isEmpty()&&!line2.isEmpty()){
                lines.add(new LineItem(Type.ADDED,line2));
                continue;
            }
            if(line2!=null&&line!=null&&!line.isEmpty()&&line2.isEmpty()){
                lines.add(new LineItem(Type.REMOVED,line));
                continue;
            }
            if(line==null){
                lines.add(new LineItem(Type.ADDED,line2));
                continue;
            }
            if(line2==null){
                lines.add(new LineItem(Type.REMOVED,line));
            }
            //System.out.println(lines);
        }
        System.out.println(lines);

        //swapper(lines);

        //System.out.println(lines);





        reader.close();
        filer1.close();
        filer2.close();
        fileReader.close();
        fileReader2.close();

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

        @Override
        public String toString() {
            return "\n"+this.line+" "+ this.type;
        }
    }
}
