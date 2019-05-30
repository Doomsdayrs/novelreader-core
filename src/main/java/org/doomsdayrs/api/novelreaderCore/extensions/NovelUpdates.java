package org.doomsdayrs.api.novelreaderCore.extensions;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.doomsdayrs.api.novelreaderCore.types.ScrapeFormat;
import org.doomsdayrs.api.novelreaderCore.types.Novel;
import org.doomsdayrs.api.novelreaderCore.types.NovelPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
@Deprecated
//TODO Create very complicated and advanced dynamic resource selector
public class NovelUpdates extends ScrapeFormat {
    private final String baseURL = "https://www.novelupdates.com";

    public NovelUpdates() {
    }

    public NovelUpdates(Request.Builder builder) {
        super(builder);
    }

    public NovelUpdates(OkHttpClient client) {
        super(client);
    }

    public NovelUpdates(Request.Builder builder, OkHttpClient client) {
        super(builder, client);
    }

    public boolean isIncrementingChapterList() {
        return false;
    }

    public String getNovelPassage(String responseBody) throws IOException {
        Document document = docFromURL(responseBody);
        return null;
    }

    public NovelPage parseNovel(String URL) throws IOException {
        Document document = docFromURL(URL);
        Elements chapters = document.select("table").get(1).select("tr");
        for (Element element : chapters) {
            Elements elements = element.select("td");
        }
        return null;
    }

    public NovelPage parseNovel(String responseBody, int increment) throws IOException {
        return null;
    }

    public String getLatestURL(int page) {
        if (page > 1)
            return baseURL + "/?pg=" + page;
        else return baseURL;
    }

    public List<Novel> parseLatest(String URL) throws IOException {
        List<Novel> novels = new ArrayList<Novel>();
        Document document = docFromURL(URL);
        Elements elements = document.select("table");
        for (int y = 0; y < elements.size(); y++) {
            if (y != 0) {
                Element element = elements.get(y);
                for (Element element1 : element.select("tr")) {
                    Elements elements1 = element1.select("a");
                    String title = null;
                    String link = null;
                    for (int x = 0; x < elements1.size(); x++) {
                        Element element2 = elements1.get(x);

                        if (x == 0) {
                            title = element2.attr("title");
                            link = element2.attr("href");
                        }

                    }

                    if (title != null && link != null) {
                        Novel novel = new Novel();
                        novel.link = link;
                        novel.title = title;
                        novels.add(novel);

                    }
                }
            }
        }
        return novels;
    }
}
