package org.doomsdayrs.api.novelreaderCore.main;

import okhttp3.ResponseBody;

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
    ArrayList<Novel> parseLatest(ResponseBody responseBody) throws IOException;
}
