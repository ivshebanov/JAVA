package com.javarush.test.level22.lesson09.task02;


import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        System.out.println(getCondition(params).toString());
    }

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder stringBuilder = new StringBuilder();
        String text = "%s = '%s'";
        for (Map.Entry<String, String> pair : params.entrySet())
        {
            if (pair.getValue() != null)
            {
                if (!stringBuilder.toString().equals(""))
                {
                    stringBuilder.append(" and ");
                    stringBuilder.append(String.format(text, pair.getKey(), pair.getValue()));
                } else
                {
                    stringBuilder.append(String.format(text, pair.getKey(), pair.getValue()));
                }
            }
        }
        return stringBuilder;
    }
}
