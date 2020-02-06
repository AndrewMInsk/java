package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'},
                {'f', 'e', 'e', 'e', 'l', 'e'},
                {'u', 's', 'n', 'n', 'n', 'o'},
                {'l', 'e', 'n', 'o', 'n', 'e'},
                {'m', 'm', 'n', 'n', 'n', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'e'}
        };
        System.out.println(detectAllWords(crossword, "home", "same", "emas", "ll", "l", "rr", "sf",  "one", "nn"));
        //System.out.println(detectAllWords(crossword, "fu").size());
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }


        public static List<Word> detectAllWords(int[][] crossword, String... words) {
            List<Word> wordsArray = new ArrayList<Word>();
            Word prop;
            for (String item : words) {
                int dlina = item.length();
                int dlinaNajd = 0;
                        for (int j = 0; j < crossword.length; j++) {
                                for (int k = 0; k < crossword[j].length; k++) {
//    J - строка  К - столбец
                                    if(item.charAt(0)==(char)crossword[j][k]) {
                                        int startX=k;
                                        int startY=j;
                                       // System.out.println("!");
                                        if (dlina==1){
                                            prop = new Word(item);
                                            prop.setStartPoint(startX,startY);
                                            prop.setEndPoint(startX,startY);
                                            wordsArray.add(prop);
                                            continue;
                                        }


                                        //направо
                                        int test = 0;
                                        dlinaNajd=0;
                                        while (k < crossword[j].length) {
                                            //System.out.println("!? "+j+" "+k +" "+ test);
                                            if ((k+test < crossword[j].length)&&item.charAt(test) == (char) crossword[j][k + test]) {
                                                if(k < crossword[j].length) {
                                                    //System.out.println((char)crossword[j][k+test]);
                                                    dlinaNajd++;
                                                    if(dlinaNajd==dlina){
                                                        int endX=k+test;
                                                        int endY=j;
                                                        System.out.println("Найден ответ: направо "+startX+", "+startY+"|"+endX+", "+endY);
                                                        prop = new Word(item);
                                                        prop.setStartPoint(startX,startY);
                                                        prop.setEndPoint(endX,endY);
                                                        wordsArray.add(prop);

                                                        break;
                                                    }

                                                    test++;
                                                }
                                            }
                                            else break;
                                        }

                                        //налево
                                        test = 0;
                                        dlinaNajd=0;
                                        //System.out.println(j+" "+k);
                                        while (k < crossword[j].length) {
                                            //System.out.println("!? "+j+" "+k +" "+ test);
                                            if ((k-test < crossword[j].length&&k-test>=0)&&item.charAt(test) == (char) crossword[j][k - test]) {
                                                if(k < crossword[j].length) {
                                                    //System.out.println((char)crossword[j][k-test]);
                                                    dlinaNajd++;
                                                    if(dlinaNajd==dlina){
                                                        int endX=k-test;
                                                        int endY=j;
                                                        System.out.println("Найден ответ: налево "+startX+", "+startY+"|"+endX+", "+endY+" Длина "+dlinaNajd);
                                                        prop = new Word(item);
                                                        prop.setStartPoint(startX,startY);
                                                        prop.setEndPoint(endX,endY);
                                                        wordsArray.add(prop);
                                                        break;
                                                    }

                                                    test++;
                                                }
                                            }
                                            else break;
                                        }

                                        //вниз
                                        test = 0;
                                        dlinaNajd=0;
                                        //
                                        // System.out.println(j+" "+k);
                                        //System.out.println(j+" "+test);
                                        while (true) {
                                            //System.out.println("!? "+j+" "+k +" "+ test);
                                            //System.out.println((char) crossword[j + test][k]);

                                            if ((j+test < crossword.length)&&item.charAt(test) == (char) crossword[j + test][k]) {

                                                    //System.out.println((char)crossword[j+test][k]);
                                                    dlinaNajd++;
                                                    if(dlinaNajd==dlina){
                                                        int endX=k;
                                                        int endY=j+test;
                                                        System.out.println("Найден ответ: вниз "+startX+", "+startY+"|"+endX+", "+endY+" Длина "+dlinaNajd);
                                                        prop = new Word(item);
                                                        prop.setStartPoint(startX,startY);
                                                        prop.setEndPoint(endX,endY);
                                                        wordsArray.add(prop);
                                                        break;
                                                    }

                                                    test++;

                                            }
                                            else break;
                                        }

                                        //вверх
                                        test = 0;
                                        dlinaNajd=0;
                                        //
                                        // System.out.println(j+" "+k);
                                        //System.out.println(j+" "+test);
                                        while (true) {
                                            //System.out.println("!? "+j+" "+k +" "+ test);
                                            //System.out.println((char) crossword[j + test][k]);

                                            if ((j-test < crossword.length&&j-test>=0)&&item.charAt(test) == (char) crossword[j - test][k]) {

                                                //System.out.println((char)crossword[j+test][k]);
                                                dlinaNajd++;
                                                if(dlinaNajd==dlina){
                                                    int endX=k;
                                                    int endY=j-test;
                                                    System.out.println("Найден ответ: вверх "+startX+", "+startY+"|"+endX+", "+endY+" Длина "+dlinaNajd);
                                                    prop = new Word(item);
                                                    prop.setStartPoint(startX,startY);
                                                    prop.setEndPoint(endX,endY);
                                                    wordsArray.add(prop);
                                                    break;
                                                }
                                                test++;
                                            }
                                            else break;
                                        }

                                        //вверх влево
                                        test = 0;
                                        dlinaNajd=0;
                                        //
                                        // System.out.println(j+" "+k);
                                        //System.out.println(j+" "+test);
                                        while (true) {
                                            //System.out.println("!? "+j+" "+k +" "+ test);
                                            //System.out.println((char) crossword[j + test][k]);

                                            if ((j-test < crossword.length&&j-test>=0&&k-test>=0)&&item.charAt(test) == (char) crossword[j - test][k-test]) {

                                                //System.out.println((char)crossword[j+test][k]);
                                                dlinaNajd++;
                                                if(dlinaNajd==dlina){
                                                    int endX=k-test;
                                                    int endY=j-test;
                                                    System.out.println("Найден ответ: вверх-влево "+startX+", "+startY+"|"+endX+", "+endY+" Длина "+dlinaNajd);
                                                    prop = new Word(item);
                                                    prop.setStartPoint(startX,startY);
                                                    prop.setEndPoint(endX,endY);
                                                    wordsArray.add(prop);
                                                    break;
                                                }

                                                test++;

                                            }
                                            else break;
                                        }

                                        //вверх вправо
                                        test = 0;
                                        dlinaNajd=0;
                                        //
                                        // System.out.println(j+" "+k);
                                        //System.out.println(j+" "+test);
                                        while (true) {
                                            //System.out.println("!? "+j+" "+k +" "+ test);
                                            //System.out.println((char) crossword[j + test][k]);

                                            if ((k+test < crossword[j].length&&j-test>=0&&k+test>=0)&&item.charAt(test) == (char) crossword[j - test][k+test]) {

                                                //System.out.println((char)crossword[j+test][k]);
                                                dlinaNajd++;
                                                if(dlinaNajd==dlina){
                                                    int endX=k+test;
                                                    int endY=j-test;
                                                    System.out.println("Найден ответ: вверх-вправо "+startX+", "+startY+"|"+endX+", "+endY+" Длина "+dlinaNajd);
                                                    prop = new Word(item);
                                                    prop.setStartPoint(startX,startY);
                                                    prop.setEndPoint(endX,endY);
                                                    wordsArray.add(prop);
                                                    break;
                                                }

                                                test++;

                                            }
                                            else break;
                                        }

                                        //вниз вправо
                                        test = 0;
                                        dlinaNajd=0;
                                        //
                                        // System.out.println(j+" "+k);
                                        //System.out.println(j+" "+test);
                                        while (true) {
                                            ///System.out.println("!? "+j+" "+k +" "+ test);
                                           // System.out.println("!!!"+(char) crossword[j + test][k+test]);

                                            if ((j+test < crossword.length&&k+test < crossword[j].length&&j+test>=0&&k+test>=0)&&item.charAt(test) == (char) crossword[j + test][k+test]) {

                                                //System.out.println((char)crossword[j+test][k+test]);
                                                dlinaNajd++;
                                                if(dlinaNajd==dlina){
                                                    int endX=k+test;
                                                    int endY=j+test;
                                                    System.out.println("Найден ответ: вниз-вправо "+startX+", "+startY+"|"+endX+", "+endY+" Длина "+dlinaNajd);
                                                    prop = new Word(item);
                                                    prop.setStartPoint(startX,startY);
                                                    prop.setEndPoint(endX,endY);
                                                    wordsArray.add(prop);
                                                    break;
                                                }

                                                test++;

                                            }
                                            else break;
                                        }

                                        //вниз влево
                                        test = 0;
                                        dlinaNajd=0;
                                        //
                                        // System.out.println(j+" "+k);
                                        //System.out.println(j+" "+test);
                                        while (true) {
                                            ///System.out.println("!? "+j+" "+k +" "+ test);
                                            // System.out.println("!!!"+(char) crossword[j + test][k+test]);

                                            if ((j+test < crossword.length&&k-test <= crossword[j].length&&j+test>=0&&k-test>=0)&&item.charAt(test) == (char) crossword[j + test][k-test]) {

                                                //System.out.println((char)crossword[j+test][k+test]);
                                                dlinaNajd++;
                                                if(dlinaNajd==dlina){
                                                    int endX=k-test;
                                                    int endY=j+test;
                                                    System.out.println("Найден ответ: вниз-влево "+startX+", "+startY+"|"+endX+", "+endY+" Длина "+dlinaNajd);
                                                    prop = new Word(item);
                                                    prop.setStartPoint(startX,startY);
                                                    prop.setEndPoint(endX,endY);
                                                    wordsArray.add(prop);
                                                    break;
                                                }

                                                test++;
                                            }
                                            else break;

                                        }


                                    }

                                }

                            }

                }



            return wordsArray;
        }
    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
