package com.javarush.task.task25.task2503;

import java.util.*;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */

    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        Column[] array = Column.values();
        int[] realOrderArr = new int[realOrder.length];
        System.arraycopy (realOrder, 0, realOrderArr, 0, realOrder.length);
        Map<Integer, Integer> mapSort= new HashMap<Integer, Integer>();
        for (int i = 0; i < realOrderArr.length; i++){
            mapSort.put(i, realOrderArr[i]);
        }
        Arrays.sort(realOrderArr);
        for (int re: realOrderArr){
            if (re != -1){
                for (Map.Entry<Integer,Integer> pair : mapSort.entrySet()) {
                    if (re == pair.getValue()) {
                        result.add(array[pair.getKey()]);
                    }
                }
            }
        }
        return result;
    }


    /**
     * @return полное имя колонки
     */
    @Override
    public String getColumnName() {
        return this.columnName;
    }

    /**
     * Возвращает true, если колонка видимая, иначе false
     */
    @Override
    public boolean isShown() {
        boolean check = true;
        if (realOrder[this.ordinal()] == -1) {
            check = false;
        }
        return check;
    }

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Сдвигает индексы отображаемых колонок, которые идут после скрытой
     */
    @Override
    public void hide() {
        realOrder[this.ordinal()] = -1;
//        int yuOrder = 0;
//        for (int i = realOrder.length - 1; i >= 0; i--) {
//            if (yuOrder == realOrder[i]) {
//                yuOrder++;
//            }
//            if (realOrder[i] != -1 && realOrder[i] != yuOrder - 1) {
//                realOrder[i] = yuOrder;
//                yuOrder++;
//            }
//        }
    }
}
