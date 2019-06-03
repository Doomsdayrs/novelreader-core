package com.github.Doomsdayrs.api.novelreader_core.main;

import com.github.Doomsdayrs.api.novelreader_core.extensions.lang.en.novel_full.NovelFull;
import com.github.Doomsdayrs.api.novelreader_core.services.core.dep.Formatter;
import com.github.Doomsdayrs.api.novelreader_core.services.core.objects.Novel;
import com.github.Doomsdayrs.api.novelreader_core.services.core.objects.NovelPage;

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
public enum DefaultScrapers implements Formatter {
    NOVELFULL(new NovelFull(1));

    public static ArrayList<Formatter> formatters = new ArrayList<>();
    static {
        formatters.add(NOVELFULL);
    }
    private final Formatter formatter;

    DefaultScrapers(Formatter formatter){
        this.formatter = formatter;
    }

    @Override
    public String getName() {
        return formatter.getName();
    }

    @Override
    public String getImageURL() {
        return formatter.getImageURL();
    }

    @Override
    public int getID() {
        return formatter.getID();
    }

    public boolean isIncrementingChapterList() {
        return formatter.isIncrementingChapterList();
    }

    public String getNovelPassage(String URL) throws IOException {
        return formatter.getNovelPassage(URL);
    }

    public NovelPage parseNovel(String URL) throws IOException {
        return formatter.parseNovel(URL);
    }

    public NovelPage parseNovel(String URL, int increment) throws IOException {
        return formatter.parseNovel(URL,increment);
    }

    public String getLatestURL(int page) {
        return formatter.getLatestURL(page);
    }

    public List<Novel> parseLatest(String URL) throws IOException {
        return formatter.parseLatest(URL);
    }

    @Override
    public List<Novel> search(String query) throws IOException {
        return formatter.search(query);
    }
}
