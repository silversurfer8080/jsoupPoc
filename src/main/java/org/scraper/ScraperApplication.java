package org.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.logging.Logger;

public class ScraperApplication {
    static Logger logger = Logger.getLogger(ScraperApplication.class.getName());
    private static final String baseUri = "https://br.financas.yahoo.com";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36";

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup
                .connect(baseUri.concat("/quote/BTC-USD?p=BTC-USD"))
                .userAgent(userAgent)
                .get();

        logger.info(doc.title());

        Element coinElement = doc.getElementsByTag("h1").first();
        String coinName = coinElement.text();
        logger.info(coinName);

        Elements coinPrice = doc.getElementsByAttributeValue("data-test", "qsp-price");
        logger.info(coinPrice.text());


    }

}