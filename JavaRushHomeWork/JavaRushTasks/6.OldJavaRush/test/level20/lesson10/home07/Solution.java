package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация index.html не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса index.html
2) записать в него данные  - writeObject
3) сериализовать класс index.html  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private String fileName;
    transient private FileOutputStream stream;

    public static void main(String[] args) {
        try {
            Solution solution = new Solution("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson10\\home07\\file");
            solution.writeObject("qwnewlqwendf");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson10\\home07\\file.tmp")));
            objectOutputStream.writeObject(solution);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\Hotj\\Dropbox\\JAVA\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level20\\lesson10\\home07\\file.tmp"));
            Solution so = (Solution) objectInputStream.readObject();
            so.writeObject("sqwqwe");
            objectInputStream.close();

        }catch (FileNotFoundException e){
            System.out.println("1");
        }catch (ClassNotFoundException e){
            System.out.println("2");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
