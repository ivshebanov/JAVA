package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
//    private static final String URL_FORMAT = "https://javarush.ru/testdata/big28data.html";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> resultList = new LinkedList<>();
        int pageNumber = 0;
        Document doc = null;
        while (true) {
            try {
                doc = getDocument(searchString, pageNumber);
            } catch (HttpStatusException e) {
                return resultList;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (doc == null) return null;
            Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (elements == null || elements.isEmpty()) break;
            for (Element element : elements) {
                if (element == null) break;
                Element title = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").first();
                Element salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").first();
                Element city = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").first();
                Element companyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").first();

                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(title != null ? title.text() : "");
                vacancy.setSalary(salary != null ? salary.text() : "");
                vacancy.setCity(city != null ? city.text() : "");
                vacancy.setCompanyName(companyName != null ? companyName.text() : "");
                vacancy.setSiteName(URL_FORMAT);
                vacancy.setUrl(title != null ? title.attr("href") : "");
                resultList.add(vacancy);
            }
            pageNumber++;
            System.out.print(pageNumber + "\t");
        }
        return resultList;
    }

    protected Document getDocument(String searchString, int pageNumber) throws IOException {
        String url = String.format(URL_FORMAT, searchString, pageNumber);
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                .referrer("http://google.ru")
                .timeout(20000)
                .get();
    }
}
