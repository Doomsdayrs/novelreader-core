package org.doomsdayrs.api.novelreaderCore.main;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.net.URL;
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
public class Core {
    static Request.Builder builder = new Request.Builder();
    static OkHttpClient client = new OkHttpClient();

    static ResponseBody request(String url) throws IOException {
        System.out.println(url);
        URL u = new URL(url);
        System.out.println(u.toString());
        Request request = builder.url(u).build();
        System.out.println(request.toString());
        return client.newCall(request).execute().body();
    }

    public static void main(String[] args) throws IOException {
        NovelUpdates novelUpdates = new NovelUpdates();
        String url = novelUpdates.getLatestURL(1);
        ResponseBody responseBody = request(url);
        ArrayList<Novel> novels = novelUpdates.parseLatest(responseBody);
    }
}
