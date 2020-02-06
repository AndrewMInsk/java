package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {
        IncomeData data = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };
        System.out.println(new IncomeDataAdapter(data).getCompanyName());
        System.out.println(new IncomeDataAdapter(data).getCountryName());
        System.out.println(new IncomeDataAdapter(data).getName());
        System.out.println(new IncomeDataAdapter(data).getPhoneNumber());

    }

    public static class IncomeDataAdapter implements Customer,Contact{
        private IncomeData data;
        public IncomeDataAdapter(IncomeData a){
            this.data=a;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }

        @Override
        public String getName() {
            return this.data.getContactLastName()+", "+this.data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {



            StringBuffer sb = new StringBuffer();
            String code = String.valueOf(this.data.getCountryPhoneCode());
            String code2 = String.valueOf(this.data.getPhoneNumber());

            while (code2.length()<10){
                code2 = "0" + code2;
            }
            sb.append("+").append(code).append(code2)
                    .insert(code.length()+1,"(")
                    .insert(code.length()+5,")")
                    .insert(code.length()+9,"-")
                    .insert(code.length()+12,"-");

            return sb.toString();
        }
    }


    public static interface IncomeData{
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}