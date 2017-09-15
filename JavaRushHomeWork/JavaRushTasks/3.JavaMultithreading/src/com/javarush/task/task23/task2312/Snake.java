package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private boolean isAlive;
    private SnakeDirection direction;
    private List<SnakeSection> sections;

    /**
     * Конструктор класса Snake.
     */
    public Snake(int x, int y) {
        this.sections = new ArrayList<>();
        this.sections.add(new SnakeSection(x, y));
        this.isAlive = true;
    }

    public int getX() {
        return this.sections.get(0).getX();
    }

    public int getY() {
        return this.sections.get(0).getY();
    }

    public void move() {

    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
}
