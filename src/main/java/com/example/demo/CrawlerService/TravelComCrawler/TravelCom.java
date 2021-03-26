package com.example.demo.CrawlerService.TravelComCrawler;

import com.example.demo.Entity.Tour;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class TravelCom {
    public String url = "https://travel.com.vn/tim-tour/ch%C6%B0%C6%A1ng%20tr%C3%ACnh%20m%E1%BB%9Bi/ket-qua-tim-kiem-p1.aspx?tourtypeID=0";
    public TravelCom() {

    }

    public Tour getDesTour(Element el) {
        String tourName = el.select(".tour-name h3").first().text();
        String link = "https://travel.com.vn" + el.select(".tour-name a").first().attr("href");
        System.out.println(link);
        String img = el.select("img").attr("src");
        Long price = Long.parseLong(el.select(".price").text().replaceAll("[^0-9]",""));
        String timeFrom = el.select(".frame-info > .row > div").get(3).select(".font500").text();
        String timeCount = el.select(".frame-info > .row > div").get(6).select(".font500").text();
        System.out.println(timeCount);
        return new Tour(null,tourName," ", price,new Date(),"Travel.com.vn",timeCount,false, false,new HashSet<String>(Arrays.asList(img))," ",link);
    }

    public List<Tour> getTour(Long tourLength) {
        List<Tour> tourList = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements elms = document.select(".item.mg-bot30");
            for(int i = 0 ; i < elms.size() && i < tourLength; i ++) {
                tourList.add(this.getDesTour(elms.get(i)));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return tourList;
    }
}
