package com.github.Doomsdayrs.api.novelreaderCore.types;

import java.util.Arrays;
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
public class NovelPage {
    public String title;
    public String imageURL;
    public String description;
    public String[] genres;
    public String[] authors;
    public Stati status;


    public String[] tags;
    public String[] artists;
    public String language;


    public List<NovelChapter> novelChapters;


    @Override
    public String toString() {
        return "NovelPage{" +
                "title='" + title + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", authors=" + Arrays.toString(authors) +
                ", status=" + status +
                ", tags=" + Arrays.toString(tags) +
                ", artists=" + Arrays.toString(artists) +
                ", language='" + language + '\'' +
                ", novelChapters=" + novelChapters +
                '}';
    }
}
