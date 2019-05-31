package com.github.Doomsdayrs.api.novelreader_core.main;

import com.github.Doomsdayrs.api.novelreader_core.services.Formatter;
import com.github.Doomsdayrs.api.novelreader_core.services.Novel;
import com.github.Doomsdayrs.api.novelreader_core.services.NovelPage;

import java.io.IOException;
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
class Core {


    public static void main(String[] args) throws IOException {
        Formatter scrapeFormat = DefaultScrapers.NOVELFULL;

        List<Novel> novels = scrapeFormat.search("level");
        NovelPage novelPage = scrapeFormat.parseNovel(novels.get(0).link);
        String passage = scrapeFormat.getNovelPassage(novelPage.novelChapters.get(0).link);

        System.out.println(passage);
    }
}
