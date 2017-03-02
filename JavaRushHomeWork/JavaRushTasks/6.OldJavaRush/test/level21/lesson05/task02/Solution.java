package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов index.html не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

//    public boolean equals(Object o) {
//        if (!(o instanceof index.html))
//            return false;
//        index.html n = (index.html) o;
//        return n.first.equals(first) && n.last.equals(last);
//    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return (last != null ? last.equals(solution.last) : solution.last == null);
    }

    @Override
    public int hashCode() {
        int result = this.first != null ? this.first.hashCode() : 0;
        return 31 * result * (this.last != null ? this.last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", null));
        System.out.println(s.contains(new Solution("Mickey", null)));
    }
}
