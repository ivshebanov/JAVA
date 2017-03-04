/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package courses;

/**
 * Created by iliashebanov on 04.03.17.
 */
public class IspSuper {
    public static void main(String[] args) {
        class DogH {
            final static String color = "rad";

            private int size;
            private int weight;

            public void gav() {
                System.out.println("Гав-гав-гав size " + size + " weight " + weight);
            }

        }
        class Spaniel extends DogH {
            boolean privivka;

            Spaniel(int sizeSpaniel, int weightSpaniel) {
                super.size = sizeSpaniel;
                super.weight = weightSpaniel;
            }
        }


        Spaniel spaniel = new Spaniel(45, 12);
        spaniel.gav();

    }
}
