package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution
{
//    public static void main(String[] args) throws IOException
//    {
//        Scanner scanner = new Scanner(new File("/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level19/lesson03/task04/file"));
//        PersonScanner personScanner = new PersonScannerAdapter(scanner);
//        System.out.println(personScanner.read());
//        System.out.println(personScanner.read());
//        personScanner.close();
//    }

    public static class PersonScannerAdapter implements PersonScanner
    {

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String str = scanner.nextLine();
            String[] masPar = str.split(" ");

//            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//            Date birthDate = null;
//            try
//            {
//                birthDate = format.parse(masPar[3] + "." + masPar[4] + "." + masPar[5]);
//
//            }
//            catch (ParseException ex)
//            {
//                System.out.println("Это не должно произойти");
//            }

            Calendar calendar = new GregorianCalendar(Integer.parseInt(masPar[5]), Integer.parseInt(masPar[4]) - 1, Integer.parseInt(masPar[3]));
            Date birthDate = calendar.getTime();

            return new Person(masPar[1], masPar[2], masPar[0], birthDate);
        }


        @Override
        public void close() throws IOException
        {
            this.scanner.close();
        }
    }
}
