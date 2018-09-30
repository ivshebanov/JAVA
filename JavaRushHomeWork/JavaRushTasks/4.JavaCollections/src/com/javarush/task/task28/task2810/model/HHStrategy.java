package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> resultList = new ArrayList<>();
        int pageNumber = 0;
        try {
            Document doc = getDocument(searchString, pageNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    protected Document getDocument(String searchString, int pageNumber) throws IOException {
        String url = String.format(URL_FORMAT, searchString, pageNumber);
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .referrer("https://hh.ru/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D")
                .timeout(5000)
                .get();

    }
}
