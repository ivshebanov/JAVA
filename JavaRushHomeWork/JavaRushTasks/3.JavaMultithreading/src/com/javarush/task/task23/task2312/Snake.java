package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private boolean isAlive;
    private SnakeDirection direction;
    private List<SnakeSection> sections = new ArrayList<SnakeSection>();

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
