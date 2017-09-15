package com.javarush.task.task23.task2312;

public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    public static Room game;

    /**
     * Конструктор класса Room.
     */
    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    /**
     * Процесс игры.
     */
    public void run() {

    }

    /**
     * Отрисовка на экране.
     */
    public void print() {

    }

    /**
     * Метод создает мышь в случайном месте комнаты.
     */
    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        this.mouse = new Mouse(x, y);
    }

    /**
     * На случай, если мышь все-таки кто то съест.
     */
    public void eatMouse() {
        createMouse();
    }

    public static void main(String[] args) {
        Snake snake = new Snake(1, 1);
        game = new Room(10, 10, snake);
        snake.setDirection(SnakeDirection.DOWN);
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

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
