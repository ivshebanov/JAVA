package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level20/lesson07/task03/file.tmp")));
            Person mother = new Person("Myrka", "Ivanovna", 55);
            Person father = new Person("Medv", "Ivanov", 58);
            List<Person> children = new ArrayList<Person>();
            children.add(new Person("Ilya", "Shebanov", 22));
            children.add(new Person("Ilya", "Shebanov", 21));

            Person person = new Person();
            person.setMother(mother);
            person.setFather(father);
            person.setChildren(children);

            objectOutputStream.writeObject(person);
            objectOutputStream.close();


            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level20/lesson07/task03/file.tmp"));
            Person famaly = (Person) objectInputStream.readObject();
            objectInputStream.close();

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){}

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject((mother != null) ? mother : null);
            out.writeObject((father != null) ? father : null);
            out.writeObject((children != null) ? children : null);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            Object ob;
            mother = ((ob = in.readObject()) != null) ? (Person) ob : null;
            father = ((ob = in.readObject()) != null) ? (Person) ob : null;
            children = ((ob = in.readObject()) != null) ? (List<Person>) ob : null;

        }
    }
}
