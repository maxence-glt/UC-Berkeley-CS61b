package Projects.proj2a.src.main;

import Projects.proj2a.src.browser.NgordnetQuery;
import Projects.proj2a.src.browser.NgordnetQueryHandler;
import Projects.proj2a.src.ngrams.NGramMap;
import Projects.proj2a.src.ngrams.TimeSeries;
import Projects.proj2a.src.plotting.Plotter;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class HistoryHandler extends NgordnetQueryHandler {
    NGramMap map;
    public HistoryHandler(NGramMap map) {
        this.map = map;
    }

    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();

        ArrayList<TimeSeries> lts = new ArrayList<>();
        for (String word : words) {
            lts.add(map.weightHistory(word, startYear, endYear));
        }

        XYChart chart = Plotter.generateTimeSeriesChart(words, lts);
        return Plotter.encodeChartAsString(chart);
    }
}
