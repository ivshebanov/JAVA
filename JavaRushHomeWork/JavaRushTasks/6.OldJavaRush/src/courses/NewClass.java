package courses;

/**
 * Created by iliashebanov on 04.03.17.
 */
public class NewClass {
    public static void main(String[] args) {
        class DogE{
            private int size;
            private int weight;

            public int getWeight() {
                return weight;
            }
            public void setWeight(int weight) {
                this.weight = weight;
            }

            public int getSize() {
                return size;
            }
            public void setSize(int size) {
                this.size = size;
            }
        }
        class Spaniel2 extends DogE{

        }

        class Labrador extends DogE{

        }

        DogE dogE = new DogE();

//        dogE.size = 50;
//        dogE.setSize(50);
//        System.out.println(dogE.size);
//        System.out.println(dogE.getSize());

        Spaniel2 spaniel2 = new Spaniel2();
        spaniel2.setSize(50);
        System.out.println(spaniel2.getSize());

        Labrador labrador = new Labrador();


    }
}
