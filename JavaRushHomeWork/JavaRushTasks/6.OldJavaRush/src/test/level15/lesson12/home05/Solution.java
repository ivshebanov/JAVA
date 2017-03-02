package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе index.html создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса index.html.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса index.html.
*/

public class Solution {
    public Solution(String a){}
    public Solution(int a){}
    public Solution(Double a){}

    Solution(Object a){}
    Solution(Exception a){}
    Solution(Short a){}

    protected Solution(Number a){}
    protected Solution(Boolean a){}
    protected Solution(Float a){}

    private Solution(Number a, int s){}
    private Solution(Boolean a, int s){}
    private Solution(Float a, int s){}

}

