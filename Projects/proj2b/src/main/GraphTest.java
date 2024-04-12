package Projects.proj2b.src.main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

public class GraphTest {
    @Test
    public void testHyponymsSimple(){
        WordNet wn=new WordNet("./data/wordnet/synsets11.txt","./data/wordnet/hyponyms11.txt");
//        assertThat(wn.getGraph().getIntToWord(2)).isEqualTo(new ArrayList<>(Arrays.asList("change", "alteration", "modification")));
//        assertThat(wn.getGraph().getWordToInt("change")).isEqualTo(new ArrayList<>(Arrays.asList(2, 8)));
//        System.out.println(wn.hyponyms("event"));
        assertThat(wn.hyponyms("sdsd")).isEqualTo(Set.of("antihistamine","actifed"));
    }

}
