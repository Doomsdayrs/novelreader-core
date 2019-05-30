package org.doomsdayrs.api.novelreaderCore.main;

import okhttp3.ResponseBody;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


/**
 * This file is part of novelreader-core.
 * novelreader-core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with novelreader-core.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * novelreader-core
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
        if (page > 1)
            return baseURL + "/?pg=" + page;
        else return baseURL;
    }

    public ArrayList<Novel> parseLatest(ResponseBody responseBody) throws IOException {
        Document document = Jsoup.parse(responseBody.string());
        Elements elements = document.select("table");
        for (int y = 0; y<elements.size();y++) {
            if (y!=0){
            Element element = elements.get(y);
            for (Element element1 : element.select("tr")) {
                Elements elements1 = element1.select("a");
                String title = null;
                String link = null;
                String group = null;
                for (int x = 0; x<elements1.size();x++) {
                    switch (x){
                        case 0:
                            title = elements1.get(x).attr("title");
                    }
                    System.out.println(title);
                }
            }}
        }
        return null;
    }
}
