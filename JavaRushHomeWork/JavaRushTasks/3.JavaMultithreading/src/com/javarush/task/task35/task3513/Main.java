package com.javarush.task.task35.task3513;

public class Main {
    public static void main(String[] args) {
        Tile[][] tile = new Model().getGameTiles();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(tile[i][j].value);
            }
            System.out.println();
        }
    }
}
