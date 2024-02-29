package Scratchwork;

public class WordUtils {
    public static String longest(List61b<String> list) {
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1) {
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if (thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static void main(String[] args) {
        List61b<String> someList = new SLList<>();
        someList.addFirst("elk");
        someList.addFirst("elk");
        someList.addFirst("elk");
        someList.addFirst("elk");
        someList.print();
    }
}
