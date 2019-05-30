package main;

import okhttp3.ResponseBody;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * main
 * 29 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public class NovelUpdates implements ScrapeFormat {
    private String baseURL = "https://www.novelupdates.com";


    public String getNovelTitle(ResponseBody responseBody) {
        return null;
    }

    public String getNovelPassage(ResponseBody responseBody) {
        return null;
    }

    public String getLatestURL(int page) {
        if (page>1)
        return baseURL+"/?pg="+page;
        else return baseURL;
    }

    public ArrayList<Novel> parseLatest(ResponseBody responseBody) {
        Document document = Jsoup.parse(responseBody.toString());
        Elements elements = document.select("table");

        return null;
    }
}
