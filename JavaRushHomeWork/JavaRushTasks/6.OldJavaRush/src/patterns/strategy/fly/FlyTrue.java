package patterns.strategy.fly;

/**
 * Created by iliashebanov on 25.09.16.
 */
public class FlyTrue implements Fly {
    @Override
    public void Fly() {
        System.out.println("Я умею летать");
    }
}
