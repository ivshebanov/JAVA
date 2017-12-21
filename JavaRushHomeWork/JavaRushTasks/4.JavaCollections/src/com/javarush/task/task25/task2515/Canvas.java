package com.javarush.task.task25.task2515;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }

    public void setPoint(double x, double y, char c) {
        int xRound = (int) Math.round(x);
        int yRound = (int) Math.round(y);
        if (xRound >= 0 && yRound >= 0 && yRound < matrix.length && xRound < matrix[0].length) {
            this.matrix[yRound][xRound] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    public void clear(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                setPoint(i, j, ' ');
            }
        }
    }

    public void print(){
        for (char[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(aMatrix[j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}
