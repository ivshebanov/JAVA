package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    public int score; //текущий счет
    public int maxTile; //макс вес плитки

    public Model() {
        resetGameTiles();
        this.score = 0;
        this.maxTile = 2;
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
        addTile();
        addTile();
        addTile();
        addTile();
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

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        LinkedList<Tile> temporaryList = new LinkedList<>();
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].getValue() != 0)
                temporaryList.addLast(tiles[i]);
        }
        if (temporaryList.size() != 0) {
            while (temporaryList.size() != tiles.length) {
                temporaryList.add(new Tile());
            }

            List<Tile> checkChangesList = Arrays.asList(tiles);
            if (!temporaryList.equals(checkChangesList)) {
                isChanged = true;
            }

            for (int i = 0; i < tiles.length; i++) {
                tiles[i] = temporaryList.removeFirst();
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length-1; i++) {
            if (tiles[i].getValue() == tiles[i + 1].getValue()) {
                tiles[i].setValue(tiles[i].value * 2);
                tiles[i + 1].setValue(0);
                compressTiles(tiles);
                if (tiles[i].getValue() > maxTile) {
                    maxTile = tiles[i].getValue();
                }
                score += tiles[i].getValue();
                isChanged = true;
            }
        }
        return isChanged;
    }

    public void left() {
        boolean isChanged = false;
        for (int i = 0; i < gameTiles.length; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }

//        if (isChanged) {
//            addTile();
//        }

        System.out.println();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                System.out.print(gameTiles[i][j].getValue());
            }
            System.out.println();
        }
    }
}
