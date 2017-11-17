package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    public int score; //текущий счет
    public int maxTile; //макс вес плитки

    public Model() {
        resetGameTiles();
    }

    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        int randomEmptyTile = (int) (Math.random() * emptyTiles.size());
        if (!emptyTiles.isEmpty()) {
            emptyTiles.get(randomEmptyTile).setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }

    public Tile[] compressTiles(Tile[] tiles) {
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].getValue() == 0) {
                for (int j = i; j < tiles.length - 1; j++) {
                    tiles[j].setValue(tiles[j + 1].value);
                }
                tiles[tiles.length - 1].setValue(0);
            }
        }
        return tiles;
    }

    public void mergeTiles(Tile[] tiles) {
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].getValue() == tiles[i + 1].getValue()) {
                tiles[i].setValue(tiles[i].value * 2);
                tiles[i + 1].setValue(0);
                compressTiles(tiles);
            }
        }
        System.out.println();
        for (int i = 0; i < tiles.length; i++) {
            System.out.print(tiles[i].getValue());
        }
    }


    public void mergeTiles() {

    }
}
