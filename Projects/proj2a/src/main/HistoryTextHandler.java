package Projects.proj2a.src.main;

import Projects.proj2a.src.browser.NgordnetQuery;
import Projects.proj2a.src.browser.NgordnetQueryHandler;
import Projects.proj2a.src.ngrams.NGramMap;

import java.util.List;

public class HistoryTextHandler extends NgordnetQueryHandler {
    NGramMap map;
    public HistoryTextHandler(NGramMap map) {
        this.map = map;
    }


    @Override
    public String handle(NgordnetQuery q) {
        StringBuilder response = new StringBuilder();

        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();

        for (String word : words) {
            response.append(word);
            response.append(": ");
            response.append(map.weightHistory(word, startYear, endYear));
            response.append('\n');
        }

        return response.toString();
    }
}
