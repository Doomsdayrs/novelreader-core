package org.doomsdayrs.api.novelreaderCore.main;

import okhttp3.ResponseBody;

import java.util.ArrayList;

/**
 * org.doomsdayrs.api.novelreaderCore.main
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


    /**
     * If there is a latest page, use this to return a certain page. Starts at 1 onwards
     * @param page page number
     * @return string URL of the next latest page
     */
    String getLatestURL(int page);

    /**
     *
     * @param responseBody LatestPage to be parsed for novels
     * @return Arraylist of novels listed
     */
    ArrayList<Novel> parseLatest(ResponseBody responseBody);
}
