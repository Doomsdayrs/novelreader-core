package main;

import okhttp3.ResponseBody;

import java.util.ArrayList;

/**
 * main
 * 29 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public interface ScrapeFormat {

    /**
     *
     * @param responseBody Incoming Novel page to parse
     * @return The title of the novel
     */
    String getNovelTitle(ResponseBody responseBody);
    String getNovelPassage(ResponseBody responseBody);


    String getLatestURL(int page);

    /**
     *
     * @param responseBody LatestPage to be parsed for novels
     * @return Arraylist of novels listed
     */
    ArrayList<Novel> parseLatest(ResponseBody responseBody);
}
