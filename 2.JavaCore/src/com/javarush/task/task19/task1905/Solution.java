package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {
        Contact cont = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        Customer cust = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };
        System.out.println(new DataAdapter(cust,cont).getCountryCode());
        System.out.println(new DataAdapter(cust,cont).getCompany());
        System.out.println(new DataAdapter(cust,cont).getContactFirstName());
        System.out.println(new DataAdapter(cust,cont).getContactLastName());
        System.out.println(new DataAdapter(cust,cont).getDialString());

    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer=customer;
            this.contact=contact;
        }

        @Override
        public String getCountryCode() {
                String res="";
                        for(Map.Entry<String,String> item: countries.entrySet()){
                            if(item.getValue().equals(this.customer.getCountryName())){
                                res = item.getKey();
                            }
                        }
            return res;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fio = this.contact.getName();
            String[] fioAr = fio.split(",");
            return fioAr[1].trim();
        }

        @Override
        public String getContactLastName() {


            String fio = this.contact.getName();
            String[] fioAr = fio.split(",");
            return fioAr[0];
        }

        @Override
        public String getDialString() {

            String tel = this.contact.getPhoneNumber();
            while (tel.contains("-")||tel.contains("(")||tel.contains(")")) {
                tel = tel.replace("-", "");
                tel = tel.replace("(", "");
                tel = tel.replace(")", "");
            }
            return "callto://"+tel;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}