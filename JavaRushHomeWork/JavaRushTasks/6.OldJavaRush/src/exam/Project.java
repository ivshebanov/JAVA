package exam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by iliashebanov on 15.08.16.
 * #11.11
 * Последовательно выводить слова длинна которых больше заданного числа.
 */
public class Project {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите число");
            int num = Integer.parseInt(reader.readLine());
            ArrayList<String> list = new ArrayList<String>();
            System.out.println("Введите слова");
            while (true){
                String s = reader.readLine();
                if (s.equals("")) break;
                list.add(s);
            }
            chis(list, num);
        }catch (IOException e){
            System.out.println("ошибка");
        }

    }

    public static void chis(ArrayList<String> list, int num) {
        try {
            for (String s: list){
                char[] chars = s.toCharArray();
                char ch = (char) chars.length;
                if (ch == num) System.out.println(s);
            }
        }catch (Exception e){
            System.out.println("ошибка");
        }
    }

}
