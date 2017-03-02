package exam;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by iliashebanov on 15.08.16.
 * 14/14.1
 */
public class Project1 {
    public static void main(String[] args) {
        cht(); //ввести числа и записать их в файл
        cht1();

    }

    public static void cht(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter out = null;
        try {
            out = new FileWriter("/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/file1");

            ArrayList<String> list = new ArrayList<String>();
            while (true){
                String num = reader.readLine();
                if (num.equals("")) break;
                list.add(num);
            }
            for(String r: list) {
                String s=r.toString();
                out.write(s+"\r\n");
            }
            out.close();
            reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void cht1(){//читает числа из файла, выводит, считает сумму
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner;
        try {
            scanner = new Scanner(new File("/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/file1"));
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            while (scanner.hasNext()){
                list1.add(new Integer(scanner.next()));
            }
            for(Integer s: list1){
                System.out.println(s);
            }
            int sum = 0;
            for (Integer in: list1){

                sum = sum + in;
            }
            System.out.println("сумма " + sum);
            scanner.close();
            reader.close();
        }catch (IOException e){
            System.out.println("Такого файла нет.");
        }
    }
}
