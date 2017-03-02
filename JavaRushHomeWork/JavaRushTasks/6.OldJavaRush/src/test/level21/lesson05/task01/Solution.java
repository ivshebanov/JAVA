package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе index.html исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
//    public boolean equals(Object n) {
//
//        if (n == null) return false;
//        if (n.getClass() != this.getClass()) return false;
//
//        index.html sol = (index.html) n;
//
//        return this.first.equals(sol.first) && sol.last.equals(this.last) && sol.first.equals(this.first) && this.last.equals(sol.last);
//    }
//
//    public int hashCode() {
//        return 31 * ((first==null?0:first.hashCode()) + ((last==null?0:last.hashCode())));
//    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;

        return last != null ? last.equals(solution.last) : solution.last == null;

    }

    @Override
    public int hashCode()
    {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(null, "1"));
        Solution d = new Solution(null, "12");
        System.out.println(d.hashCode());
        System.out.println(s.contains(d));
        System.out.println(s.hashCode());
    }


}
