package com.javarush.task.task37.task3714;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void romanToInteger_1() {
        int number1 = Solution.romanToInteger("MDCLXVI");
        Assert.assertEquals(number1, 1666);
    }

    @Test
    public void romanToInteger_2() {
        int number1 = Solution.romanToInteger("MCDXLIV");
        Assert.assertEquals(number1, 1444);
    }

    @Test
    public void romanToInteger_3() {
        int number1 = Solution.romanToInteger("MCCDXXLIIV");
        Assert.assertEquals(number1, 1333);
    }

    @Test
    public void romanToInteger_4() {
        int number1 = Solution.romanToInteger("CCMLXXVII");
        Assert.assertEquals(number1, 877);
    }

    @Test
    public void romanToInteger_5() {
        int number1 = Solution.romanToInteger("MDCCCXXLVIII");
        Assert.assertEquals(number1, 1838);
    }
}