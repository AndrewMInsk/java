package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapa = new ObjectMapper();
        File file = new File(fileName);

        T temp = mapa.readValue(file,clazz);
        return temp;
    }

    public static void main(String[] args) {

    }
}
