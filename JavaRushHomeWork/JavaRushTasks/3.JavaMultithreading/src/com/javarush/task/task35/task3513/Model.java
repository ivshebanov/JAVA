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
                if (gameTiles[i][j].getValue() == 0) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        LinkedList<Tile> temporaryList = new LinkedList<>();
        for (Tile tile : tiles) {
            if (tile.getValue() != 0) {
                temporaryList.addLast(tile);
            }
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
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].getValue() == tiles[i + 1].getValue() & tiles[i].getValue() != 0) {
                tiles[i].setValue(tiles[i].getValue() * 2);
                tiles[i + 1].setValue(0);
                compressTiles(tiles);
                if (tiles[i].getValue() > maxTile) {
                    this.maxTile = tiles[i].getValue();
                }
                this.score += tiles[i].getValue();
                isChanged = true;
            }
        }
        return isChanged;
    }

    public void left() {
        boolean isChanged = false;
        for (Tile[] gameTile : gameTiles) {
            if (compressTiles(gameTile) | mergeTiles(gameTile)) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }
    }

    public void up() {
        rotateGameTiles90();
        rotateGameTiles90();
        rotateGameTiles90();
        left();
        rotateGameTiles90();
    }

    public void right() {
        rotateGameTiles90();
        rotateGameTiles90();
        left();
        rotateGameTiles90();
        rotateGameTiles90();
    }

    public void down() {
        rotateGameTiles90();
        left();
        rotateGameTiles90();
        rotateGameTiles90();
        rotateGameTiles90();
    }

    private void rotateGameTiles90() {
        Tile[][] newTiles = new Tile[gameTiles[0].length][gameTiles.length];
        int retArrI = 0;
        int retArrJ = gameTiles.length - 1;
        for (Tile[] srI : gameTiles) {
            for (Tile srJ : srI) {
                newTiles[retArrI++][retArrJ] = srJ;
            }
            retArrI = 0;
            retArrJ--;
        }
        System.arraycopy(newTiles, 0, gameTiles, 0, newTiles.length);
    }
}
