package courses;

/**
 * Created by iliashebanov on 04.03.17.
 */
public class Наследование {

    public static void main(String[] args) {

        class DogG {
            private String color;
            public int size;
            protected int weight;

            void Gav() {
                System.out.println("Гав-гав-гав");
            }

        }

        class Spaniel extends DogG {
            boolean privivka;
        }

        Spaniel spaniel = new Spaniel();
//        spaniel.Gav();
//        spaniel.color = "черный";
        spaniel.privivka = true;

        System.out.println(spaniel.privivka);
        DogG dog = new DogG();
    }
}
