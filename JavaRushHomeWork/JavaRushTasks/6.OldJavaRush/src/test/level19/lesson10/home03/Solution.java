package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            while (fileReader.ready()) {
                String[] str = null;
                str = fileReader.readLine().split(" ");

                String name = str[0];
                for (int i = 1; i < str.length - 3; i++)
                {
                    name = name + " " + str[i];
                }
                //PEOPLE.add(new Person(name, new SimpleDateFormat("dd mm yyyy").parse(str[str.length-3] + " " + str[str.length-2] + " " + str[str.length-1])));
                PEOPLE.add(new Person(name, new GregorianCalendar(Integer.parseInt(str[str.length-1]), Integer.parseInt(str[str.length-2])-1, Integer.parseInt(str[str.length-3])).getTime()));
            }
//            for (Person p: PEOPLE){
//                System.out.println(p.getName() + " " + p.getBirthday());
//            }
//            System.out.println(PEOPLE.size());
            fileReader.close();
        }catch (FileNotFoundException ex1){
        }catch (NullPointerException ex3){
        }catch (IOException ex4){
        }
    }

}

/*try {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

            String name1 = "";
            String dateStr1 = "";
            while (fileReader.ready()){
                String str = fileReader.readLine();

                String name = str.replaceAll("\\d", "");
                String dateStr = str.replaceAll("\\p{L}", "");

                Pattern patternName = Pattern.compile("\\p{L}+");
                Matcher matcherName = patternName.matcher(name);
                while (matcherName.find()){
                    name1 = name1 + name.substring(matcherName.start(), matcherName.end()) + " ";
                }

                Pattern patternDate = Pattern.compile("\\d+");
                Matcher matcherDate = patternDate.matcher(dateStr);
                while (matcherDate.find()){
                    dateStr1 = dateStr1 + dateStr.substring(matcherDate.start(), matcherDate.end()) + " ";
                }
                Date date = new SimpleDateFormat("dd mm yyyy").parse(dateStr1);
                PEOPLE.add(new Person(name1, date));
//                System.out.println(name1);
//                System.out.println(date);
            }
            fileReader.close();
            for (Person p: PEOPLE){
                System.out.println(p.getName() + p.getBirthday());
            }
            System.out.println(PEOPLE.size());
        }catch (FileNotFoundException ex1){
        }catch (ParseException ex2){
        }catch (IOException ex3){
        }*/



//try
//        {
//        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
//        while (fileReader.ready())
//        {
//        String str = fileReader.readLine();
//        String name = str.replaceAll("\\p{Digit}", "");
//        String name1 = str.replaceAll("\\p{L}", "");
////            Pattern pattern = Pattern.compile("\\b(\\p{InCyrillic})+\\b");
////            Matcher matcher = pattern.matcher(str);
////            while (matcher.find())
////            {
////                name = name + str.substring(matcher.start(), matcher.end()) + " ";
////            }
////            Pattern pattern1 = Pattern.compile("\\b\\W\\d*\\S\\b");
////            Matcher matcher1 = pattern1.matcher(str);
////            while (matcher1.find())
////            {
////                name1 = name1 + str.substring(matcher1.start() + 1, matcher1.end()) + " ";
////            }
//        Date date = new SimpleDateFormat("d m yyyy").parse(name1);
//        PEOPLE.add(new Person(name, date));
//        for (Person p: PEOPLE){
//        System.out.println(p.getBirthday()+ " " + p.getName());
//        }
////            System.out.print(person.getName());
////            System.out.println(person.getBirthday());
////            SimpleDateFormat dateFormat = new SimpleDateFormat("d m yyyy");
////            System.out.println(dateFormat.format(person.getBirthday()));
//        }
//        fileReader.close();
//        } catch (FileNotFoundException e1){
//        } catch (ParseException e2){
//        } catch (NumberFormatException e4){
//        } catch (IOException e3){
//        }