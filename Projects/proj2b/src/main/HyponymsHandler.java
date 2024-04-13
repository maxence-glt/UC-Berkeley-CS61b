package Projects.proj2b.src.main;

import Projects.proj2b.src.browser.NgordnetQuery;
import Projects.proj2b.src.browser.NgordnetQueryHandler;
import Projects.proj2b.src.ngrams.NGramMap;
import Projects.proj2b.src.ngrams.TimeSeries;

import java.util.*;

public class HyponymsHandler extends NgordnetQueryHandler {
    private final WordNet wn;
    private final NGramMap ngm;

    public HyponymsHandler(WordNet wn) {
        this.wn = wn;
        this.ngm = null;
    }

    public HyponymsHandler(WordNet wn, NGramMap ngm) {
        this.wn = wn;
        this.ngm = ngm;
    }

    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        int k = q.k();

        Set<String> s1 = wn.hyponyms(words.get(0));

        for (int i = 1; i < words.size(); i++) {
            s1.retainAll(wn.hyponyms(words.get(i)));
        }

        if (k == 0)
            return s1.toString();
        else {
            assert ngm != null;
            TreeMap<Double, String> temp = new TreeMap<>(Collections.reverseOrder());
            Set<String> finalSet = new TreeSet<>();

            for (String s : s1) {
                Double out = 0.0;
                TimeSeries ch = ngm.countHistory(s, startYear, endYear);

                for (Integer i : ngm.countHistory(s, startYear, endYear).keySet())
                    out += ch.get(i);

                if (out != 0)
                    temp.put(out, s);
            }

            int index = 0;
            for (Double n : temp.keySet()) {
                if (index == k)
                    break;

                finalSet.add(temp.get(n));
                index++;
            }

            return finalSet.toString();
        }
    }
}
