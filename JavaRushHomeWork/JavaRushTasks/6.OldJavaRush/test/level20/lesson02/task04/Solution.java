package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            //File your_file_name = File.createTempFile("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson02\\task04\\file" , null);
            String stro = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level20/lesson02/task04/file";
            //String stro = "D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson02\\task04\\file";
            OutputStream outputStream = new FileOutputStream(stro);
            InputStream inputStream = new FileInputStream(stro);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            //loadedObject.save(outputStream);
            //outputStream.flush();

            loadedObject.load(inputStream);

            System.out.println(loadedObject.i);
            System.out.println(loadedObject.j);
            System.out.println(loadedObject.staticString);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

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

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            String isStaticString = staticString != null ? "yes" : "no";
            if (isStaticString.equals("yes")){
                printWriter.println(isStaticString);
                printWriter.println(staticString);
            }else {
                printWriter.println("no");
            }
            printWriter.println(i);
            printWriter.println(this.j);
            printWriter.println("End");
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while (!(str =reader.readLine()).equals("End")) {
                if (str.equals("yes")) {
                    staticString = reader.readLine();
                }
                str = reader.readLine();
                this.i = Integer.parseInt(str);
                str = reader.readLine();
                this.j = Integer.parseInt(str);
            }
        }
    }
}
