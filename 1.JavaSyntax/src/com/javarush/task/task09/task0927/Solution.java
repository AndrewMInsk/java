package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> list = new HashMap<String, Cat>();

        Cat cat1 = new Cat("Питрович");
        Cat cat2 = new Cat("Патрович");
        Cat cat3 = new Cat("Путрович");
        Cat cat4 = new Cat("Петрович");
        Cat cat5 = new Cat("Пётрович");
        Cat cat6 = new Cat("Пятрович");
        Cat cat7 = new Cat("Пытрович");
        Cat cat8 = new Cat("Пютрович");
        Cat cat9 = new Cat("Пиитрович");
        Cat cat10 = new Cat("Пиетрович");

        list.put(cat1.name, cat1);
        list.put(cat2.name, cat2);
        list.put(cat3.name, cat3);
        list.put(cat4.name, cat4);
        list.put(cat5.name, cat5);
        list.put(cat6.name, cat6);
        list.put(cat7.name, cat7);
        list.put(cat8.name, cat8);
        list.put(cat9.name, cat9);
        list.put(cat10.name, cat10);

        return list;

    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> targetSet = new HashSet<Cat>(map.values());

        return targetSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
