package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

//    public static void main(String[] args)
//    {
//        IncomeData incomeData = new IncomeData(){
//
//            @Override
//            public String getCountryCode()
//            {
//                return "UA";
//            }
//
//            @Override
//            public String getCompany()
//            {
//                return "JavaRush Ltd.";
//            }
//
//            @Override
//            public String getContactFirstName()
//            {
//                return "Ivan";
//            }
//
//            @Override
//            public String getContactLastName()
//            {
//                return "Ivanov";
//            }
//
//            @Override
//            public int getCountryPhoneCode()
//            {
//                return 38;
//            }
//
//            @Override
//            public int getPhoneNumber()
//            {
//                return 501234567;
//            }
//        };
//        Customer customer = new IncomeDataAdapter(incomeData);
//        System.out.println(customer.getCompanyName());
//        System.out.println(customer.getCountryName());
//        Contact contact = new IncomeDataAdapter(incomeData);
//        System.out.println(contact.getName());
//        System.out.println(contact.getPhoneNumber());
//    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData incomeData;
        public IncomeDataAdapter(IncomeData incomeData){
            this.incomeData = incomeData;
        }
        @Override
        public String getCompanyName()
        {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
            String country = null;
            for (Map.Entry entry: countries.entrySet()){
                if (incomeData.getCountryCode().equals(entry.getKey())){
                    country = (String) entry.getValue();
                }
            }
            return country;
        }

        @Override
        public String getName()
        {
            return incomeData.getContactLastName()+ ", " + incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            //example +38(050)123-45-67
            String phoneNumber = Integer.toString(incomeData.getPhoneNumber());
            if (phoneNumber.length()<10){
                while (phoneNumber.length()!=10){
                    phoneNumber = "0" + phoneNumber;
                }
            }
            char[] phoneMas = phoneNumber.toCharArray();
            return "+" + incomeData.getCountryPhoneCode() + "(" + phoneMas[0] + phoneMas[1] + phoneMas[2] + ")" + phoneMas[3] + phoneMas[4] + phoneMas[5] + "-" + phoneMas[6] + phoneMas[7] + "-" + phoneMas[8]+ phoneMas[9];
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
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