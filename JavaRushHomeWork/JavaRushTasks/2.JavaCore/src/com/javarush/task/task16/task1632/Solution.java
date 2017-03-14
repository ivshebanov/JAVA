package com.javarush.task.task16.task1632;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Threa1());
        threads.add(new Threa2());
        threads.add(new Threa3());
        threads.add(new Threa4());
        threads.add(new Threa5());
    }

    public static void main(String[] args) {

    }

    public static class Threa1 extends Thread {
        @Override
        public void run() {
            while (true) ;
        }
    }

    public static class Threa2 extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                }
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Threa3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Threa4 extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            } catch (InterruptedException e) {
            }
        }

        /**
         * If this thread was constructed using a separate
         * <code>Runnable</code> run object, then that
         * <code>Runnable</code> object's <code>run</code> method is called;
         * otherwise, this method does nothing and returns.
         * <p>
         * Subclasses of <code>Thread</code> should override this method.
         *
         * @see #start()
         * @see #stop()
         * @see #Thread(ThreadGroup, Runnable, String)
         */
        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }
    }

    public static class Threa5 extends Thread {
        @Override
        public void run() {
            int count = 0;
            String check;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (!(check = reader.readLine()).equals("N")) {
                    count = count + Integer.parseInt(check);
                }
                reader.close();
            } catch (IOException e) {
            }
            System.out.println(count);
        }
    }
}