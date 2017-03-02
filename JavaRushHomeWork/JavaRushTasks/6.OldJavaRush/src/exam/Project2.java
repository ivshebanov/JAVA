package exam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by iliashebanov on 15.08.16.
 * 7/7.1
 */
public class Project2 {
    public static void main(String[] args) {
        BufferedReader reader;
        ArrayList<Integer> list = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            list = new ArrayList<Integer>();
            while (true){
                String s = reader.readLine();
                if (s.equals("")) break;
                list.add(Integer.parseInt(s));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        prov(list);
    }
    public static void prov(ArrayList<Integer> list){
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (Integer u: list){
            list1.add(u);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o1.compareTo(o2);
            }
        });
        //TODO:for (Integer i: list){System.out.println(i);}
        if (list.equals(list1)) System.out.println("элементы упорядочены по неубыванию");
        else System.out.println("Элементы упорядочены по убыванию");
    }
}