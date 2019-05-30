package org.doomsdayrs.api.novelreaderCore.extensions;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.doomsdayrs.api.novelreaderCore.types.ScrapeFormat;
import org.doomsdayrs.api.novelreaderCore.types.Novel;
import org.doomsdayrs.api.novelreaderCore.types.NovelChapter;
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
 * 30 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public class NovelFull extends ScrapeFormat {
    private final String baseURL = "http://novelfull.com";

    public NovelFull() {
    }

    public NovelFull(Request.Builder builder) {
        super(builder);
    }

    public NovelFull(OkHttpClient client) {
        super(client);
    }

    public NovelFull(Request.Builder builder, OkHttpClient client) {
        super(builder, client);
    }

    public boolean isIncrementingChapterList() {
        return true;
    }

    public String getNovelPassage(String URL) throws IOException {
        Document document = docFromURL(URL);
        Elements paragraphs = document.select("div.chapter-c").select("p");
        StringBuilder stringBuilder = new StringBuilder();
        for(Element element:paragraphs)
            stringBuilder.append(element.text()).append("\n");

        return stringBuilder.toString();
    }

    public NovelPage parseNovel(String URL) throws IOException {
        return this.parseNovel(URL, 1);
    }

    public NovelPage parseNovel(String URL, int increment) throws IOException {
        Document document = docFromURL(URL);
        NovelPage novelPage = new NovelPage();

        //Sets description
        {
            Element titleDescription = document.selectFirst("div.col-xs-12.col-sm-8.col-md-8.desc");
            novelPage.title = titleDescription.selectFirst("h3").text();

            Element description = titleDescription.selectFirst("div.desc-text");
            Elements text = description.select("p");
            StringBuilder stringBuilder = new StringBuilder();
            for (Element paragraph : text) {
                stringBuilder.append(paragraph.text()).append("\n");
            }
            novelPage.description = stringBuilder.toString();
        }

        //Formats the chapters
        {
            List<NovelChapter> novelChapters = new ArrayList<NovelChapter>();
            Elements lists = document.select("ul.list-chapter");
            for (Element list:lists){
                Elements chapters = list.select("li");
                for (Element chapter:chapters){
                    NovelChapter novelChapter = new NovelChapter();
                    Element chapterData = chapter.selectFirst("a");
                    String link = chapterData.attr("href");
                    if (link!=null)
                        novelChapter.link = baseURL+link;
                    String unformattedNum = chapterData.attr("title");
                    unformattedNum = unformattedNum.replace("Chapter ","");
                    if (unformattedNum.contains(":")){
                        unformattedNum = unformattedNum.substring(0,unformattedNum.indexOf(":"));
                    }
                    novelChapter.chapterNum = Integer.parseInt(unformattedNum);

                    if (novelChapter.chapterNum != -99 && !novelChapter.link.contains("null")){
                        novelChapters.add(novelChapter);
                    }
                }

            }
            novelPage.novelChapters = novelChapters;
        }


        return novelPage;
    }

    public String getLatestURL(int page) {
        return baseURL + "/latest-release-novel?page=" + page;
    }

    public List<Novel> parseLatest(String URL) throws IOException {
        List<Novel> novels = new ArrayList<Novel>();
        Document document = docFromURL(URL);
        Elements divMAIN = document.select("div.container");
        for (Element element : divMAIN) {
            if (element.id().equals("list-page")) {
                Element list = element.selectFirst("div");
                Elements releases = list.select("div.row");
                //For each novel
                for (int x = 0; x < releases.size(); x++) {
                    Novel novel = new Novel();
                    Elements data = releases.get(x).select("div");
                    //For each coloum
                    for (int y = 0; y < data.size(); y++) {
                        Element coloum = data.get(y);
                        switch (y) {
                            case 0: {
                                Element image = coloum.selectFirst("img");
                                if (image != null)
                                    novel.imageURL = baseURL + image.attr("src");
                            }
                            case 1: {
                                Element header = coloum.selectFirst("h3");
                                if (header != null) {
                                    Element titleLink = header.selectFirst("a");
                                    novel.title = titleLink.attr("title");
                                    novel.link = baseURL + titleLink.attr("href");
                                }
                            }
                            default:
                                break;
                        }
                    }
                    if (novel.link != null && novel.title != null)
                        novels.add(novel);
                }
            }
        }
        return novels;
    }
}
