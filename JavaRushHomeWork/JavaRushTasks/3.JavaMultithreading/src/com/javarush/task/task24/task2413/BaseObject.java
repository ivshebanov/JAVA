package com.javarush.task.task24.task2413;

public abstract class BaseObject {

    abstract void draw(Canvas canvas);

    abstract void move();

    private double x;
    private double y;
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /**
     * Метод определяет «пересеклись» объекты или нет. Если пересеклись — возвращать true,
     * если нет — false.
     *
     * @param o объект с которым проверяем пересечение текущего объекта.
     */
    public boolean isIntersec(BaseObject o) {
        //дистанция_между_объектами <= max (радиус_первого_объекта, радиус_второго_объекта)
        return Math.sqrt((this.x - o.getX()) * (this.x - o.getX())
                + (this.y - o.getY()) * (this.y - o.getY()))
                <= Double.max(this.radius, o.getRadius());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
