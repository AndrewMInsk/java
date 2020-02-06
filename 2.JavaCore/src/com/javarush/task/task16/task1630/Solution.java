package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static volatile BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();

        f.join();

        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String line="";
        @Override
        public void run() {
            try{
                FileInputStream fileReader = new FileInputStream(firstFileName); // поток, который подключается к текстовому файлу
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader)); // соединяем FileReader с BufferedReader

                synchronized (bufferedReader){

                while (bufferedReader.ready()){
                    this.line +=bufferedReader.readLine()+" ";
                }
                bufferedReader.close();
                }
            }
            catch (Exception e ){
                System.out.println("!");
                e.getStackTrace();
            }

        }

        @Override
        public void setFileName(String fullFileName) {
            Solution.firstFileName = fullFileName;
        }

        @Override
        public String getFileContent()  {

            return this.line;

        }



    }

    //add your code here - добавьте код тут
}
