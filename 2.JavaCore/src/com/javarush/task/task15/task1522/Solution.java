package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;
    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //add static block here - добавьте статический блок тут


     static void readKeyFromConsoleAndInitPlanet() throws IOException {
         BufferedReader reader = null;
         try{
         reader = new BufferedReader(new InputStreamReader(System.in));
         String line1 = reader.readLine();
             if(line1.equals(Planet.SUN)){
                 thePlanet = Sun.getInstance();
             }
             else if(line1.equals(Planet.MOON)){
                 thePlanet = Moon.getInstance();
             }
             else if(line1.equals(Planet.EARTH)){
                 thePlanet = Earth.getInstance();
             }
             else
                 thePlanet = null;
         }
         catch (Exception e){
             System.out.println(e);
         }
         finally {
             reader.close();
         }
     }

}
