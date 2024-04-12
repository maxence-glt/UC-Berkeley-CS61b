package Projects.proj2b.src.main;

import Projects.proj2b.src.browser.NgordnetQuery;
import Projects.proj2b.src.browser.NgordnetQueryHandler;

import java.util.List;

public class HyponymsHandler extends NgordnetQueryHandler {
    private WordNet wn;

    public HyponymsHandler(WordNet wn) {
        this.wn = wn;
    }

    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();

        return wn.hyponyms(words.get(0)).toString();
    }
}
