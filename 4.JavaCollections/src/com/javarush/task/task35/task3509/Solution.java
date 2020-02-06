package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> newArray = new ArrayList<>();
        for(Object item: elements){
            newArray.add((T) item);
        }
        return newArray;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> newSet = new HashSet<>();
        for(Object item: elements){
            newSet.add((T) item);
        }
        return newSet;
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {

        HashMap<K,V> newSet = new HashMap<>();

        if(values.size()==keys.size()){

            for(int i=0;i<values.size();i++){
                newSet.put((K)keys.get(i),(V)values.get(i));
            }

        }
        else{
            throw new IllegalArgumentException();
        }

        return newSet;

    }
}
