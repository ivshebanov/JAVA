package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {

    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;


    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void run(){

    }

    public void move(){

    }

    public static Arkanoid game;

    public static void main(String[] args) {
        Canvas canvas = new Canvas(10, 10);
        int[][] matrix = new int[12][12];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 1;
            }
        }
        canvas.drawMatrix(0, 0, matrix, 'c');
        canvas.print();
        canvas.clear();
        canvas.drawMatrix(0, 0, matrix, 'x');
        canvas.print();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}
