package patterns.singleton;

/**
 * Created by iliashebanov on 27.09.16.
 * Иницализация в статическом методе
 */
public class SingletonTwo {
    private static SingletonTwo singletonTwo;
    private SingletonTwo(){}
    static {
        try {
            singletonTwo = new SingletonTwo();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    public static SingletonTwo GetInstanceTwo(){
        return singletonTwo;
    }
}
