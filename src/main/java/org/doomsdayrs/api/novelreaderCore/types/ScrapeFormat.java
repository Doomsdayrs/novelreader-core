package org.doomsdayrs.api.novelreaderCore.types;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.doomsdayrs.api.novelreaderCore.types.Novel;
import org.doomsdayrs.api.novelreaderCore.types.NovelPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
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
public abstract class ScrapeFormat implements Formatter {

    Request.Builder builder;
    OkHttpClient client;

    public ScrapeFormat() {
        this.builder = new Request.Builder();
        this.client = new OkHttpClient();
    }

    public ScrapeFormat(Request.Builder builder) {
        this.builder = builder;
        this.client = new OkHttpClient();
    }

    public ScrapeFormat(OkHttpClient client) {
        this.builder = new Request.Builder();
        this.client = client;
    }

    public ScrapeFormat(Request.Builder builder, OkHttpClient client) {
        this.builder = builder;
        this.client = client;
    }


    protected ResponseBody request(String url) throws IOException {
        System.out.println(url);
        URL u = new URL(url);
        Request request = builder.url(u).build();
        return client.newCall(request).execute().body();
    }

    protected Document docFromURL(String URL) throws IOException {
        return Jsoup.parse(request(URL).string());
    }

    /**
     * Returns true if the chapter list on the page requires another reload
     *
     * @return true if the above matches
     */
    public abstract boolean isIncrementingChapterList();

    /**
     * Parse the novel Chapter
     *
     * @param URL Incoming Novel chapter URL to parse
     * @return The Passage of the novel
     */
    public abstract String getNovelPassage(String URL) throws IOException;

    /**
     * Parse the novelPage
     *
     * @param URL Incoming Novel page URL to parse
     * @return NovelPage object with as many parameters filled as possible;
     */
    public abstract NovelPage parseNovel(String URL) throws IOException;

    /**
     * the above, except if isIncrementingChapterList() returns true this will be used in its stead
     *
     * @param URL       Incoming Novel page URL to parse
     * @param increment What increment to use
     * @return
     * @throws IOException
     */
    public abstract NovelPage parseNovel(String URL, int increment) throws IOException;

    /**
     * If there is a latest page, use this to return a certain page. Starts at 1 onwards
     *
     * @param page page number
     * @return string URL of the next latest page
     */
    public abstract String getLatestURL(int page);

    /**
     * @param URL LatestPage URL to be parsed for novels
     * @return List of novels listed
     */
    public abstract List<Novel> parseLatest(String URL) throws IOException;
}
