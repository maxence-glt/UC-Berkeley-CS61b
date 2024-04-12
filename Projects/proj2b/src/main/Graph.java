package Projects.proj2b.src.main;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private HashMap<Integer, ArrayList<Integer>> graph; // hyponyms connection

    // takes in a word and outputs all numbers associated with word in graph
    private HashMap<String, ArrayList<Integer>> wordToInt;

    // takes in an int from the graph and returns all strings associated with it
    private HashMap<Integer, ArrayList<String>> intToWord;

    public Graph() {
        this.graph = new HashMap<>();
        this.wordToInt = new HashMap<>();
        this.intToWord = new HashMap<>();
    }

    public void addEdge(Integer v1, Integer v2) {
        if (!graph.containsKey(v1))
            graph.put(v1, new ArrayList<>());
        else
            graph.get(v1).add(v2);
    }

    public void addWordToInt(String v1, Integer v2) {
        if (!wordToInt.containsKey(v1))
            wordToInt.put(v1, new ArrayList<>(List.of(v2)));
        else
            wordToInt.get(v1).add(v2);
    }

    public ArrayList<Integer> getWordToInt(String v1) {
        return wordToInt.get(v1);
    }

    public void addIntToWord(Integer v1, String v2) {
        if (!intToWord.containsKey(v1))
            intToWord.put(v1, new ArrayList<String>(List.of(v2)));
        else
            intToWord.get(v1).add(v2);
    }

    public ArrayList<String> getIntToWord(Integer v1) {
        return intToWord.get(v1);
    }

    Iterable<Integer> adj(Integer v) {
        return graph.get(v);
    }
}
