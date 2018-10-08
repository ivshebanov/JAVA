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

public class MoikrugStrategy implements Strategy {

//    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s&type=all";
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
//    private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";

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
            Elements elements = doc.getElementsByClass("job");
            if (elements == null || elements.isEmpty()) break;
            for (Element element : elements) {
                if (element == null) break;
                Element title = element.getElementsByClass("title").first();
                Element salary = element.getElementsByClass("count").first();
                Element city = element.getElementsByClass("location").first();
                Element companyName = element.getElementsByClass("company_name").first();

                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(title != null ? title.text() : "");
                vacancy.setSalary(salary != null ? salary.text() : "");
                vacancy.setCity(city != null ? city.text() : "");
                vacancy.setCompanyName(companyName != null ? companyName.text() : "");
                vacancy.setSiteName(URL_FORMAT);
                vacancy.setUrl("https://moikrug.ru" + element.select("a[class=job_icon]").attr("href"));
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
