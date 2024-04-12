package Projects.proj2b.src.main;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class WordNet {
    private Graph graph;
    private String synsets;
    private String hyponyms;

    public WordNet(String synsets, String hyponyms) {
        this.graph = new Graph();
        this.synsets = synsets;
        this.hyponyms = hyponyms;
        populateGraph();
    }

    void populateGraph() {
        In synsetsIn = new In(synsets);
        In hyponymsIn = new In(hyponyms);

        while (synsetsIn.hasNextLine()) {
            String[] splitLine = synsetsIn.readLine().split(",");
            Integer pos = Integer.parseInt(splitLine[0]);
            String[] words = splitLine[1].trim().split("\\s+");

            graph.addEdge(Integer.parseInt(splitLine[0]), null);

            for (String w : words) {
                graph.addWordToInt(w, pos);
                graph.addIntToWord(pos, w);
            }
        }

        while (hyponymsIn.hasNextLine()) {
            String[] splitLine = hyponymsIn.readLine().split(",");

            for (int i = 1; i < splitLine.length; i++) {
                graph.addEdge(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[i]));
            }
        }
    }

    public TreeSet<String> hyponyms(String s) {
        TreeSet<String> out = new TreeSet<>();
        Queue<Integer> fringe = new LinkedList<>();

        if (graph.getWordToInt(s) == null)
            return out;

        for (Integer wordIndex : graph.getWordToInt(s)) {
            fringe.add(wordIndex);

            while (!fringe.isEmpty()) {
                Integer curr = fringe.remove();
                out.addAll(graph.getIntToWord(curr));

                for (Integer i : graph.adj(curr))
                    fringe.add(i);

            }
        }

        return out;
    }

    public Graph getGraph() {return graph;}
}