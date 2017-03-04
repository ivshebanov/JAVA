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
public class RabConstr {
    public static void main(String[] args) {
        class DogL {
            int size;
            int weight;
            String color;

            public DogL() {
                System.out.println("сработал дог");
            }

            public DogL(int size) {
                System.out.println("переменная Ы");
            }

            public DogL(int size, int weight, String color) {
                this.size = size;
                this.weight = weight;
                this.color = color;
                System.out.println("сработал конструктор с 3 параметрами ДОГ");
            }

            public DogL(int size, int weight) {
                this.size = size;
                this.weight = weight;
                System.out.println("сработал конструктор дог с двумя параметрами");

            }
        }
        class Spaniel extends DogL {
            public Spaniel(int size, int weight, String color) {
                super(size, weight, color);
                System.out.println("Спаниел с тремя параметрами");
            }

            public Spaniel(int size, int weight) {
                super(size, weight);
                System.out.println("сработал конструктор спаниел с двумя параметрами");
            }

            public Spaniel() {
                System.out.println("сработал коструктор спаниел");
            }
        }
        //DogL dogL = new DogL();
        Spaniel spaniel = new Spaniel(12, 5, " ");
    }
}
