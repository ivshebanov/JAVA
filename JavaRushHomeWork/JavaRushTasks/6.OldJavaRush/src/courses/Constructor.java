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
public class Constructor {
    public static void main(String[] args) {
        class DogR {
            int size;
            int weight;

            public DogR(int size, int weight) {
                this.size = size;
                this.weight = weight;
            }
        }

        class SpanielR extends DogR {

            public SpanielR(int size, int weight) {
                super(size, weight);
            }
        }
        DogR dogR = new DogR(50, 22);
        System.out.println(dogR.size + " " + dogR.weight);

        SpanielR spanielR = new SpanielR(50, 23);
        System.out.println(spanielR.size + " " + spanielR.weight);
    }
}
