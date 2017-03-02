package test;

import java.io.*;
import java.nio.file.*;

/**
 * Created by iliashebanov on 28.01.17.
 * Можете ему предложить 3-е задание на решение дома (1-2 дня) в "расширенной" формулировке?
 * <p>
 * --------
 * <p>
 * 3. Необходимо отсортировать csv-файл по первому полю (считать , что оно целочисленное).
 * Пример файла:
 * FID;SERIAL_NUM;MEMBER_CODE;ACCT_TYPE;OPENED_DT;ACCT_RTE_CDE;REPORTING_DT;CREDIT_LIMIT
 * 2000;2202099;4B01GG000001;9;04.06.2014;0;14.10.2014;100000
 * 1200;1200;9999SM333333;9;24.08.2006;13;10.03.2007;265485
 * 1600;1400;9999SM333333;10;01.01.1999;0;04.04.2007;70000
 * 1601;1401;9999SM333333;10;01.01.1999;0;04.04.2007;70000
 * 1602;1402;9999SM333333;10;01.01.1999;0;04.04.2007;70000
 * 1603;1403;9999SM333333;10;01.01.1999;0;04.04.2007;70000
 * 1800;1600;9999SM333333;10;01.01.1999;0;04.04.2007;7000
 * …
 * 1800000;1600;9999SM333333;10;01.01.1999;0;04.04.2007;70000
 * …
 * <p>
 * При условии что:
 * - размер файла F (несколько гигабайт)
 * - размер памяти для сортировки ограничен M и M << F (М - несколько десятков мегабайт)
 * - размер диска D и D >> F ( D – несколько терабайт )
 * Для решения использовать только JDK 1.7 или 1.8 (без сторонних библиотек, за исключением JUnit 4.*)
 */

public class Solution
{
    public static void main(String[] args)
    {
        String fileName = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/test/file.csv";
        sortFile(fileName);
    }

    public static void sortFile(String fileName)
    {
        BufferedReader fileReader = null;
        BufferedWriter fileWriter = null;
        try
        {
            fileReader = new BufferedReader(new FileReader(fileName));
            String folderName = fileName.substring(0, fileName.lastIndexOf("/") + 1) + "folder";
            File newDir = new File(folderName);
            newDir.mkdirs();
            while (fileReader.ready())
            {
                String d = fileReader.readLine();
                fileWriter = new BufferedWriter(new FileWriter(new File(newDir, d.substring(1, d.indexOf(";")))));
                fileWriter.write(d);
                fileWriter.close();
            }
            fileReader.close();


            fileWriter = new BufferedWriter(new FileWriter(new File(fileName.substring(0, fileName.lastIndexOf("/") + 1) + "sortFile.csv")));
            /*
            * Разложил вначале каждую строку в сфой файл в отдельной папке, название файла первое поле.
            * Получилось что в папке они осортировались правильно(по возрастанию 1800 2000 1800000),
            * а когда мы запрашиваем очередной файл из этой папки, то уже получаем их не по порядку, 1800 1800000 2000.
            * Наверно надо реальзовать сортировку "слиянием" для этих файлов, но это уже неуспеваю сделать. Высылаю обратно работу.
            */
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderName));
            for (Path file : stream)
            {
                //В этом цикле строки сортируются не попорядку.
                if (!file.toFile().isDirectory())
                {
                    fileReader = new BufferedReader(new FileReader(folderName + "/" + file.getFileName().toString()));
                    fileWriter.write(fileReader.readLine() + "\n");
                    fileReader.close();
                    System.out.println(file.getFileName());
                }
            }
            fileWriter.close();
            stream.close();
            //deleteDirectory(newDir);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteDirectory(File dir)
    {
        if (dir.isDirectory())
        {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++)
            {
                File f = new File(dir, children[i]);
                deleteDirectory(f);
            }
            dir.delete();
        } else dir.delete();
    }

}
