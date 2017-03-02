package exam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by iliashebanov on 15.08.16.
 * 3.2
 */
public class Project5 {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("введите число");
        try {
            String s = reader.readLine();
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(1);
            list.add(2);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
