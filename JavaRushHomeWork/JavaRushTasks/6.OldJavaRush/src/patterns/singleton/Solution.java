package patterns.singleton;


import static patterns.singleton.SingletonOne.GetInstanceOne;
import static patterns.singleton.SingletonThree.GetInstanceThree;
import static patterns.singleton.SingletonTwo.GetInstanceTwo;

/**
 * Created by iliashebanov on 27.09.16.
 */
public class Solution{
    public static void main(String[] args){
        SingletonOne singletonOne = GetInstanceOne();
        SingletonTwo singletonTwo = GetInstanceTwo();
        SingletonThree singletonThree = GetInstanceThree();
    }
}
