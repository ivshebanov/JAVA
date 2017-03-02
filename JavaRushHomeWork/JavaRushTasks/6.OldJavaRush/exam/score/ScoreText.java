package exam.score;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by iliashebanov on 04.01.17.
 * Count the words in the file
 */
public class ScoreText {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader("/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/exam/score/file"));
        String str = fileReader.readLine();
        while (fileReader.ready()){
            str = str + " " + fileReader.readLine();
        }
        str = str.toLowerCase();
        String str2 = "";
        Pattern pattern = Pattern.compile("\\b\\w+\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            str2 = str2 + str.substring(matcher.start(), matcher.end()) + " ";

        }
        String[] strArr = str2.split(" ");

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for (String r: strArr){
            if (map.containsKey(r)) {
                int val = map.get(r)+1;
                map.put(r, val);
            }else {
                map.put(r, 1);
            }
        }

        FileWriter fileWriter = new FileWriter(new File("/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/exam/score/file1.txt"));
        fileWriter.write("Всего слов в тексте: " + strArr.length + "\n");
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            fileWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
        }
        fileReader.close();
        fileWriter.close();
    }
}
