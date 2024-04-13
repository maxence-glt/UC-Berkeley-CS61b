package Projects.proj2b.src.main;

import Projects.proj2b.src.ngrams.NGramMap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

public class GraphTest {
    @Test
    public void testHyponymsSimple(){
        String wordFile = "./data/ngrams/top_14377_words.csv";
        String countFile = "./data/ngrams/total_counts.csv";

        String testHyponymFile = "./data/wordnet/hyponyms.txt";
        String testSynsetsFile = "./data/wordnet/synsets.txt";

        NGramMap ngm = new NGramMap(wordFile, countFile);
        WordNet wn = new WordNet(testSynsetsFile, testHyponymFile);
        HyponymsHandler hh = new HyponymsHandler(wn, ngm);
//        assertThat(wn.getGraph().getIntToWord(2)).isEqualTo(new ArrayList<>(Arrays.asList("change", "alteration", "modification")));
//        assertThat(wn.getGraph().getWordToInt("change")).isEqualTo(new ArrayList<>(Arrays.asList(2, 8)));

//        assertThat(wn.hyponyms("antihistamine")).isEqualTo(Set.of("antihistamine","actifed"));
    }

}
