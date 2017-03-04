package courses;

/**
 * Created by iliashebanov on 04.03.17.
 */
public class Lesson3 {
    public static void main(String[] args) {
        class OuterClass {

            int a;
            int b;

            void summa(int a, int b) {
                this.a = a;
                this.b = b;
                InnerClass innerClass = new InnerClass();
                innerClass.display();
                innerClass.difference();
            }

            class InnerClass {
                void display() {
                    System.out.println("Сумма = " + (a + b));
                }
                void difference() {
                    System.out.println("Разность = " + (a - b));
                }
            }
        }
        OuterClass outerClass = new OuterClass();
        outerClass.summa(5,10);

    }
}
