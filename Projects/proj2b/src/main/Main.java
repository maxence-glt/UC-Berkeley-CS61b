package Projects.proj2b.src.main;

import Projects.proj2b.src.browser.NgordnetServer;
import Projects.proj2b.src.ngrams.NGramMap;

public class Main {
    public static void main(String[] args) {
        NgordnetServer hns = new NgordnetServer();

        String wordFile = "./data/ngrams/top_49887_words.csv";
        String countFile = "./data/ngrams/total_counts.csv";

        String testHyponymFile = "./data/wordnet/hyponyms.txt";
        String testSynsetsFile = "./data/wordnet/synsets.txt";

        NGramMap ngm = new NGramMap(wordFile, countFile);
        WordNet wn = new WordNet(testSynsetsFile, testHyponymFile);


        hns.startUp();
        hns.register("history", new DummyHistoryHandler());
        hns.register("historytext", new DummyHistoryTextHandler());
        hns.register("hyponyms", new HyponymsHandler(wn, ngm));

        System.out.println("Finished server startup! Visit http://localhost:4567/ngordnet.html");
    }
}
