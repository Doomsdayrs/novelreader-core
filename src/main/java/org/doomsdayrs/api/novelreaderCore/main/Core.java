package org.doomsdayrs.api.novelreaderCore.main;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * org.doomsdayrs.api.novelreaderCore.main
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
        ResponseBody responseBody = client.newCall(request).execute().body();
        return responseBody;
    }

    public static void main(String[] args) throws IOException {
        NovelUpdates novelUpdates = new NovelUpdates();
        String url = novelUpdates.getLatestURL(1);
        ResponseBody responseBody = request(url);
        ArrayList<Novel> novels = novelUpdates.parseLatest(responseBody);
    }
}
