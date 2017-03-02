package exam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by iliashebanov on 15.08.16.
 * 6/6.2
 * как определить самое короткое слово в строке
 */
public class Project3 {
    public static void main(String[] args) {
        BufferedReader reader;
        System.out.println("Введите строку");
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();

            ArrayList<String> list = new ArrayList<String>();
            StringTokenizer st = new StringTokenizer(s, " ");
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            ArrayList<Integer> list2 = new ArrayList<Integer>();
            for (String c: list){
                char[] chars = c.toCharArray();
                int ch = (char) chars.length;
                list2.add(ch);
            }

            Collections.sort(list2, new Comparator<Integer>(){
                public int compare(Integer o1, Integer o2){
                    return o1.compareTo(o2);
                }
            });


            for (String er: list){
                if (er.length()==list2.get(0))
                    System.out.println(er);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}