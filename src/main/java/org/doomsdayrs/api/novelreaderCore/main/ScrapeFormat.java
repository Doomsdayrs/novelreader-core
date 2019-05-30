package org.doomsdayrs.api.novelreaderCore.main;

import okhttp3.ResponseBody;
import org.doomsdayrs.api.novelreaderCore.other.Novel;
import org.doomsdayrs.api.novelreaderCore.other.NovelChapter;
import org.doomsdayrs.api.novelreaderCore.other.NovelPage;

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
public interface ScrapeFormat {

    /**
     * Parse the novel Chapter
     * @param responseBody Incoming Novel chapter to parse
     * @return The Passage of the novel
     */
    String getNovelPassage(ResponseBody responseBody) throws IOException;

    /**
     * Parse the novelPage
     * @param responseBody Incoming Novel page to parse
     * @return NovelPage object with as many parameters filled as possible;
     */
    NovelPage parseNovel(ResponseBody responseBody) throws IOException;

    /**
     * If there is a latest page, use this to return a certain page. Starts at 1 onwards
     * @param page page number
     * @return string URL of the next latest page
     */
    String getLatestURL(int page);

    /**
     *
     * @param responseBody LatestPage to be parsed for novels
     * @return List of novels listed
     */
    List<Novel> parseLatest(ResponseBody responseBody) throws IOException;
}
