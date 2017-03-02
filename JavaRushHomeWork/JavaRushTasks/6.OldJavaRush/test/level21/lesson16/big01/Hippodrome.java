package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Администратор on 16.01.2017.
 */
public class Hippodrome {
    public static Hippodrome game;
    private static ArrayList<Horse> horses = new ArrayList<Horse>();

    public static void main(String[] args) {
        game= new Hippodrome();

        Horse horse1 = new Horse("Скорость", 3, 0);
        Horse horse2 = new Horse("Ветер", 3, 0);
        Horse horse3 = new Horse("Свет", 3, 0);

        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game.run();
        game.printWinner();

    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++){
            move();
            print();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(){
        for (Horse h: horses){
            h.move();
        }
    }

    public void print(){
        for (Horse h: getHorses()){
            h.print();
        }
        System.out.println();
    }

    public Horse getWinner() {
        Horse hor = null;
        Double dist = 0.;
        for (Horse h: getHorses()){
            if (dist < h.getDistance()){
                hor = h;
                dist = h.getDistance();
            }
        }
        return hor;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
