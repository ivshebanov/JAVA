package patterns.singleton;

/**
 * Created by iliashebanov on 27.09.16.
 * Ранняя инициализация
 */
public class SingletonOne {
    private static final SingletonOne singletonOne = new SingletonOne();
    private SingletonOne(){};
    public static SingletonOne GetInstanceOne(){
        return singletonOne;
    }
}
