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
 * 4/4.1
 *
 */
public class Project4 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите посл чис");
        String s = reader.readLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(s, " ");
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (Integer i: list){
            list1.add(i);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o1.compareTo(o2);
            }
        });
        if (list.equals(list1)) System.out.println("последовательность возрастающая");
        else System.out.println("посл убыв");
    }
}