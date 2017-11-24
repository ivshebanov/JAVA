package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score; //текущий счет
    int maxTile; //макс вес плитки
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
        this.score = 0;
        this.maxTile = 2;
    }

    private void saveState(Tile[][] tiles) {
        int scoreSave = score;
        this.previousScores.push(scoreSave);
        Tile[][] gameTilesSave = new Tile[gameTiles[0].length][gameTiles.length];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTilesSave[i][j] = new Tile(gameTiles[i][j].getValue());
            }
        }
        this.previousStates.push(gameTilesSave);
        this.isSaveNeeded = false;
    }

    void rollback() {
        if (!previousStates.empty()) {
            this.gameTiles = previousStates.pop();
        }
        if (!previousScores.empty()) {
            this.score = previousScores.pop();
        }
    }

    void resetGameTiles() {
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

    void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (Tile[] gameTile : gameTiles) {
            if (compressTiles(gameTile) | mergeTiles(gameTile)) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }
        this.isSaveNeeded = true;
    }

    public void up() {
        saveState(gameTiles);
        rotateGameTiles90();
        rotateGameTiles90();
        rotateGameTiles90();
        left();
        rotateGameTiles90();
    }

    void right() {
        saveState(gameTiles);
        rotateGameTiles90();
        rotateGameTiles90();
        left();
        rotateGameTiles90();
        rotateGameTiles90();
    }

    void down() {
        saveState(gameTiles);
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

    public boolean canMove() {

        if (!getEmptyTiles().isEmpty()) {
            return true;
        }

        for (int i = 0; i < gameTiles[0].length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].getValue() == gameTiles[i][j - 1].getValue()) {
                    return true;
                }
            }
        }

        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles[0].length; i++) {
                if (gameTiles[i][j].getValue() == gameTiles[i - 1][j].getValue()) {
                    return true;
                }
            }
        }

        return false;
    }

    void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    boolean hasBoardChanged() {
        int weightGameTiles = 0;
        int weightPreviousStates = 0;

        Tile[][] tmp = previousStates.peek();
        for (int i = 0; i < gameTiles[0].length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                weightGameTiles += gameTiles[i][j].getValue();
                weightPreviousStates += tmp[i][j].getValue();
            }
        }

        return weightGameTiles != weightPreviousStates;
    }

    MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();
        return moveEfficiency;
    }
}