package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {
//    public static void main(String[] args) {
//        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson10\\home05\\file.tmp")));
//            Person person = new Person("Ilya", "Shebanov", "Orel", Sex.FEMALE);
//
//            System.out.println(person.firstName);
//            System.out.println(person.lastName);
//            System.out.println(person.fullName);
//            System.out.println(person.greetingString);
//            System.out.println(person.country);
//            System.out.println(person.sex);
//            System.out.println(person.logger);
//
//            objectOutputStream.writeObject(person);
//            objectOutputStream.close();
//
//            System.out.println("");
//
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson10\\home05\\file.tmp"));
//            Person person1 = (Person) objectInputStream.readObject();
//            objectInputStream.close();
//
//            System.out.println(person1.firstName);
//            System.out.println(person1.lastName);
//            System.out.println(person1.fullName);
//            System.out.println(person1.greetingString);
//            System.out.println(person1.country);
//            System.out.println(person1.sex);
//            System.out.println(person1.logger);
//
//            System.out.println("");
//
//            System.out.println(person.equals(person1));
//
//        }catch (FileNotFoundException ex){
//            ex.printStackTrace();
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException ex){
//            ex.printStackTrace();
//        }
//
//    }

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void writeObject(ObjectOutputStream out) throws IOException{
            out.defaultWriteObject();
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            if (lastName != null && firstName != null) fullName = lastName + ", " + firstName;
            outputStream = System.out;
            logger = Logger.getLogger(String.valueOf(Person.class));
        }

    }

    enum Sex {
        MALE,
        FEMALE
    }
}
