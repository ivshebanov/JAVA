package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <T, E extends Convertable> Map<T, E> convert(List<? extends Convertable> list) {
        Map<T, E> result = new HashMap<>();
        for (Convertable el : list) {
            result.put((T)el.getKey(), (E)el);
        }
        return result;
    }
}
