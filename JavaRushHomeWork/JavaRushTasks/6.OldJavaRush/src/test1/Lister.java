package test;

/**
 * Created by iliashebanov on 28.01.17.
 * Класс выводит отсортированный список содержимого пути,
 * переданного ему в качестве аргумента. Если аргумента нет, выводится сождержимое текущей директории.
 */
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class Lister {

    private File path;
    private File[] files;

    public Lister(String pathname) throws IOException {
        path = new File(pathname);
        if (!path.exists()) {
            throw new IOException("Cannot access " + pathname + ": No such file or directory");
        }
        if (path.isFile()) {
            files = new File[]{path};
        } else {
            files = path.listFiles();
            Arrays.sort(files, new FilesComparator());
        }
    }

    public void print() {
        for (File f: files) {
            System.out.println(
                    f.getName()
                            + ((f.isDirectory()) ? File.separator : "")
            );
        }
    }

    public static void main(String[] args) {
        //String path = (args.length == 0) ? "." : args[0];
        String path = "/Users/iliashebanov/Dropbox/JAVA/JavaRushHomeWork/JavaRushHomeWork/src/test/folder";
        try {
            new Lister(path).print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class FilesComparator implements Comparator<File> {
        public int compare(File f1, File f2) {
            if (f1.isDirectory() && f2.isFile()) {
                return -1;
            }
            if (f1.isFile() && f2.isDirectory()) {
                return 1;
            }
            return f1.compareTo(f2);
        }
    }
}