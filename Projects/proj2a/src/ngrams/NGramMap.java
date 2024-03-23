package Projects.proj2a.src.ngrams;

import edu.princeton.cs.algs4.In;
import org.antlr.v4.runtime.tree.Tree;

import java.util.*;

import static Projects.proj2a.src.ngrams.TimeSeries.MAX_YEAR;
import static Projects.proj2a.src.ngrams.TimeSeries.MIN_YEAR;

/**
 * An object that provides utility methods for making queries on the
 * Google NGrams dataset (or a subset thereof).
 *
 * An NGramMap stores pertinent data from a "words file" and a "counts
 * file". It is not a map in the strict sense, but it does provide additional
 * functionality.
 *
 * @author Josh Hug
 */
public class NGramMap {

    HashMap<Integer, Long> countYears = new HashMap<>();
    HashMap<String, HashMap<Integer, Long>> countWords = new HashMap<>();

    /**
     * Constructs an NGramMap from WORDSFILENAME and COUNTSFILENAME.
     */
    public NGramMap(String wordsFilename, String countsFilename) {
        In wordsIn = new In(wordsFilename);
        In countIn = new In(countsFilename);

        while (countIn.hasNextLine()) {
            String[] splitLine = countIn.readLine().split(",");
            countYears.put(Integer.parseInt(splitLine[0]), Long.parseLong(splitLine[1]));
        }

        while (wordsIn.hasNextLine()) {
            String[] splitLine = wordsIn.readLine().split("\t");

            if (countWords.containsKey(splitLine[0]))
                countWords.get(splitLine[0]).put(Integer.parseInt(splitLine[1]), Long.parseLong(splitLine[2]));

            else {
                countWords.put(splitLine[0], new HashMap<>());
                countWords.get(splitLine[0]).put(Integer.parseInt(splitLine[1]), Long.parseLong(splitLine[2]));
            }
        }

    }

    public static void main(String[] args) {
        NGramMap ngm = new NGramMap("./data/ngrams/top_14377_words.csv",
                "./data/ngrams/total_counts.csv");
        System.out.println("DONE");
        TimeSeries test1 = ngm.countHistory("request", 2005, 2008);
        TimeSeries test2 = ngm.countHistory("request");
        TimeSeries test3 = ngm.totalCountHistory();
        TimeSeries test4 = ngm.weightHistory("request");
        List<String> fishAndDog = new ArrayList<>();
        fishAndDog.add("fish");
        fishAndDog.add("dog");

        TimeSeries test5 = ngm.summedWeightHistory(fishAndDog, 2005, 2008);
        System.out.println(test2.toString());
    }

    /**
     * Provides the history of WORD between STARTYEAR and ENDYEAR, inclusive of both ends. The
     * returned TimeSeries should be a copy, not a link to this NGramMap's TimeSeries. In other
     * words, changes made to the object returned by this function should not also affect the
     * NGramMap. This is also known as a "defensive copy". If the word is not in the data files,
     * returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word, int startYear, int endYear) {
        TimeSeries outTimeSeries = new TimeSeries();
        HashMap<Integer, Long> wordPos = countWords.get(word);

        if (!countWords.containsKey(word))
            return outTimeSeries;

        while (startYear <= endYear) {
            if (!wordPos.containsKey(startYear)) {
                startYear++;
                continue;
            }

            outTimeSeries.put(startYear, (double)wordPos.get(startYear));

            startYear++;
        }

        return outTimeSeries;
    }

    /**
     * Provides the history of WORD. The returned TimeSeries should be a copy, not a link to this
     * NGramMap's TimeSeries. In other words, changes made to the object returned by this function
     * should not also affect the NGramMap. This is also known as a "defensive copy". If the word
     * is not in the data files, returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word) {
        return countHistory(word, MIN_YEAR, MAX_YEAR);
    }

    /**
     * Returns a defensive copy of the total number of words recorded per year in all volumes.
     */
    public TimeSeries totalCountHistory() {
        TimeSeries outTimeSeries = new TimeSeries();
        for (Integer key : countYears.keySet())
            outTimeSeries.put(key, (double)countYears.get(key));

        return outTimeSeries;
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD between STARTYEAR
     * and ENDYEAR, inclusive of both ends. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        return countHistory(word, startYear, endYear).dividedBy(totalCountHistory());
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD compared to all
     * words recorded in that year. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word) {
        return weightHistory(word, MIN_YEAR, MAX_YEAR);
    }

    /**
     * Provides the summed relative frequency per year of all words in WORDS between STARTYEAR and
     * ENDYEAR, inclusive of both ends. If a word does not exist in this time frame, ignore it
     * rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words,
                                          int startYear, int endYear) {
        TimeSeries outTimeSeries = new TimeSeries();
        for (String item : words) {
            outTimeSeries = outTimeSeries.plus(weightHistory(item, startYear, endYear));
        }

        return outTimeSeries;
    }

    /**
     * Returns the summed relative frequency per year of all words in WORDS. If a word does not
     * exist in this time frame, ignore it rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words) {
        return summedWeightHistory(words, MIN_YEAR, MAX_YEAR);
    }
}
