package patterns.singleton;

/**
 * Created by iliashebanov on 27.09.16.
 * Ленивая инициализация
 */
public class SingletonThree {
    private static SingletonThree singletonThree = null;
    private SingletonThree(){}

    public static SingletonThree GetInstanceThree(){
        if (singletonThree == null) singletonThree = new SingletonThree();
        return singletonThree;
    }
}
