package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

public class Solution {
    public void sayHi(String...names) {

        for (String name: names) {
            System.out.println("Добрый вечер, " + name + ", как ваши дела?");
        }
    }

    public static void main(String[] args) {
        Solution jarvis = new Solution();
        jarvis.sayHi("Тони Старк");
        System.out.println();
        jarvis.sayHi("Тони Старк", "Капитан Америка");
    }
}

