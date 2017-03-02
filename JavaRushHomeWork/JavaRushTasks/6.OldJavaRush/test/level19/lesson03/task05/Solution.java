package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {

    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

//    public static void main(String[] args)
//    {
//        Customer customer = new Customer()
//        {
//            @Override
//            public String getCompanyName()
//            {
//                return "JavaRush Ltd.";
//            }
//
//            @Override
//            public String getCountryName()
//            {
//                return "Ukraine";
//            }
//        };
//        Contact contact = new Contact()
//        {
//            @Override
//            public String getName()
//            {
//                return "Ivanov, Ivan";
//            }
//
//            @Override
//            public String getPhoneNumber()
//            {
//                return "+38(050)123-45-67";
//            }
//        };
//
//        RowItem rowItem = new DataAdapter(customer, contact);
//        System.out.println(rowItem.getCountryCode());
//        System.out.println(rowItem.getCompany());
//        System.out.println(rowItem.getContactFirstName());
//        System.out.println(rowItem.getContactLastName());
//        System.out.println(rowItem.getDialString());
//    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode()
        {
            String str = "";
            for (Map.Entry<String,String>  part: countries.entrySet()){
                if (part.getValue().equals(customer.getCountryName())){
                    str = part.getKey();
                }
            }
            return str;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            return contact.getName().split(", ")[1];
//            Pattern pattern = Pattern.compile("\\,\\s\\w*");
//            Matcher matcher = pattern.matcher(contact.getName());
//            while (matcher.find()){
//                return contact.getName().substring(matcher.start()+2, matcher.end());
//            }
//            return null;
        }

        @Override
        public String getContactLastName()
        {
            return contact.getName().split(", ")[0];
//            Pattern pattern = Pattern.compile("\\w*\\,\\s");
//            Matcher matcher = pattern.matcher(contact.getName());
//            while (matcher.find()){
//                return contact.getName().substring(matcher.start(), matcher.end()-2);
//            }
//            return null;
        }

        @Override
        public String getDialString()
        {
//            return contact.getPhoneNumber().replaceAll("[()-]", "");
            String str = "callto://+";
            Pattern pattern = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(contact.getPhoneNumber());
            while (matcher.find()){
                 str = str + contact.getPhoneNumber().substring(matcher.start(), matcher.end());
            }
            return str;
        }

    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}