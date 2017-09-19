package com.javarush.task.task24.task2413;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }

    /**
     * Метод ставит точку в координатах x, y цветом с.
     *
     * @param x Координата X
     * @param y Координата Y
     * @param c Цвет закрашивания
     */
    public void setPoint(double x, double y, char c) {
        int xI = (int) Math.round(x);
        int yI = (int) Math.round(y);
        if (!(xI < 0 || yI < 0 || xI > matrix.length || yI > matrix.length)) {
            matrix[yI][xI] = c;
        }
    }

    /**
     * Копирует переданную ему картинку (матрицу) в матрицу Canvas,
     * начиная с координат x, y.
     *
     * @param x      Координата X
     * @param y      Координата Y
     * @param matrix полученная картинка для копирования
     * @param c      Цвет закрашивания
     */
    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        int leng = matrix.length;
        for (int i = 0; i < leng; i++) {
            for (int j = 0; j < leng; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    /**
     * Метод очищает матрицу matrix, чтобы на ней снова можно было рисовать.
     */
    public void clear() {
        this.matrix = new char[height + 2][width + 2];
    }

    /**
     * Метод рисует матрицу на экран.
     */
    public void print() {
//        int matrixWidth = this.matrix.length;
//        int matrixHeight = this.matrix[0].length;
//        for (int y = 0; y < matrixWidth; y++) {
//            StringBuilder sb = new StringBuilder();
//            for (int x = 0; x < matrixHeight; x++) {
//                sb.append(this.matrix[y][x]).append("\t");
//            }
//            System.out.println(sb.toString());
//        }

        for (char[] y : matrix) {
            for (char x : y) {
                System.out.print(x);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
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

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
