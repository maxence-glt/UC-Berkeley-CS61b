package Projects.proj2a.src.main;

import Projects.proj2a.src.browser.NgordnetServer;
import Projects.proj2a.src.ngrams.NGramMap;

public class Main {
    public static void main(String[] args) {
        NgordnetServer hns = new NgordnetServer();

        /* The following code might be useful to you.

        String wordFile = "./data/ngrams/top_14377_words.csv";
        String countFile = "./data/ngrams/total_counts.csv";
        NGramMap ngm = new NGramMap(wordFile, countFile);

        */
        NGramMap wordMap = new NGramMap("data/ngrams/top_14377_words.csv","data/ngrams/total_counts.csv");
        hns.startUp();
        hns.register("history", new HistoryHandler(wordMap));
        hns.register("historytext", new HistoryTextHandler(wordMap));

        System.out.println("Finished server startup! Visit http://localhost:4567/ngordnet_2a.html");
    }
}