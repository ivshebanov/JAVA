package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            String your_file_name = "D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson02\\task02\\file";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Ilya");
            user.setLastName("Shebanov");
            user.setBirthDate(dateFormat.parse("21.01.2000"));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);



            User user1 = new User();
            user1.setFirstName("Nastya");
            user1.setLastName("Martynova");
            user1.setBirthDate(dateFormat.parse("21.01.2000"));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);





            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (User u: javaRush.users){
                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.isMale());
                System.out.println(u.getCountry());
            }
            System.out.println();
            for (User u: loadedObject.users){
                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.isMale());
                System.out.println(u.getCountry());
            }
            System.out.println();
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            if (users.size() > 0){
                printWriter.println("yes");
                printWriter.println(users.size());
                for (User u: users){
                    String firstName = u.getFirstName() != null ? u.getFirstName() : "noName";
                    printWriter.println(firstName);

                    String lastName = u.getLastName() != null ? u.getLastName() : "noLastName";
                    printWriter.println(lastName);

                    printWriter.println(dateFormat.format(u.getBirthDate()));

                    printWriter.println(u.isMale());

                    printWriter.println(u.getCountry());

                    printWriter.println("end");
                }
            }else {
                printWriter.println("no");
                printWriter.println("end");
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String checkUsers = reader.readLine();
            if (checkUsers.equals("yes")){
                int checkUser = Integer.parseInt(reader.readLine());
                for (int i = 0; i < checkUser; i++){
                    User user = new User();
                    String checkEnd = reader.readLine();
                    while (!checkEnd.equals("end")){
                        user.setFirstName(checkEnd);

                        checkEnd = reader.readLine();
                        user.setLastName(checkEnd);

                        checkEnd = reader.readLine();
                        user.setBirthDate(dateFormat.parse(checkEnd));

                        checkEnd = reader.readLine();
                        user.setMale(Boolean.parseBoolean(checkEnd));

                        checkEnd = reader.readLine();
                        switch (checkEnd) {
                            case "UKRAINE":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case "RUSSIA":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            default :
                                user.setCountry(User.Country.OTHER);
                                break;
                        }
                        checkEnd = reader.readLine();
                    }
                    this.users.add(user);
                }
            }
            reader.close();
        }
    }
}
