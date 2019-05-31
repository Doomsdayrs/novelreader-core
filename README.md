# novelreader-core
Core API for novel reader

//Working on this
## How to use
- Step 1: Add to project through [jitpack](https://jitpack.io/#Doomsdayrs/novelreader-core) with your preferred method
- Step 2: Using one of the predefined types in this [enum](https://github.com/Doomsdayrs/novelreader-core/blob/master/src/main/java/com/github/Doomsdayrs/api/novelreaderCore/main/DefaultScrapers.java)
- Step 3: Follow directions below / Get an idea

```java
class Example{
    public static void main(String[] args){
        // Choose the scrapper
        Formatter scrapeFormat = DefaultScrapers.NOVELFULL;
        
        // Get the latest, first page :D
        String url = scrapeFormat.getLatestURL(1);
        
        // Parses the latest page to get the novels
        List<Novel> novels = scrapeFormat.parseLatest(url);
        
        // Gets the novel page for the novel
        NovelPage novelPage = scrapeFormat.parseNovel(novels.get(0).link);
        
        // Selects the first chapters link, the formats the passage from it
        String passage = scrapeFormat.getNovelPassage(novelPage.novelChapters.get(0).link);
        
        // Outputs the first chapter :D
        System.out.println(passage);
    }
}
```

## To contribute
### Note, i will be moving extensions to their own seperate repo soon, adding it to this via a submodule. So you will have to move your code a bit.
- Step 1: Fork the extension repo
- Step 2: Create a folder in an appropriate language for the novel scrapper (en, ch, fr, ru). Then, create an scrapedformat class and start working
- Step 3: Once the formatting works (test via Core class here), send a merge request, ill test. Then i will combine it.

## In Development
- [X] Search functionality
- [ ] More sites(Aim is 10 popular ones)
