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


interface DogU {
    public void eat();
    public void sleap();
    public String color = "Черный";
    public int size = 35;
}

class SpanielU implements DogU {

    

    @Override
    public void eat() {
        System.out.println("собака есть");
    }

    @Override
    public void sleap() {
        System.out.println("собака спид");
    }
}

public class Lesson5Interfeice {

    public static void main(String[] args) {
        SpanielU spanielU = new SpanielU();
        spanielU.eat();
        spanielU.sleap();
    }

}
