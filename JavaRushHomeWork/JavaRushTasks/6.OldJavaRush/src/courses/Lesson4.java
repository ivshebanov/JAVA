package courses;

/**
 * Created by iliashebanov on 04.03.17.
 */
public class Lesson4 {
    public static void main(String[] args) {
        class Dog {
            String color = "Белая";

            void necotorMetod(String color) {
                this.color = color;
            }
        }
        Dog dog = new Dog();
        dog.necotorMetod("белая");
        System.out.println("Моя собака " + dog.color);
    }
}
