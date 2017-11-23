package com.javarush.task.task35.task3513;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Tile[][] tile = model.getGameTiles();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(tile[i][j].getValue() + "\t");
            }
            System.out.println();
        }

        Tile[] tiles = {new Tile(2), new Tile(2), new Tile(2), new Tile(2)};
        model.left();



        System.out.println();
        Tile[][] til1e = model.getGameTiles();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(til1e[i][j].getValue() + "\t");
            }
            System.out.println();
        }
    }
}
