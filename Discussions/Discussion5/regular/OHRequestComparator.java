package Discussions.Discussion5.regular;

import java.util.Comparator;

public class OHRequestComparator implements Comparator<OHRequest> {
    @Override
    public int compare(OHRequest o1, OHRequest o2) {
        if (o1.isSetup && !o2.isSetup)
            return 1;
        if (!o1.isSetup && o2.isSetup)
            return -1;
        if (o1.description.equals("setup") && !o2.description.equals("setup"))
            return 1;
        if (!o1.description.equals("setup") && o2.description.equals("setup"))
            return -1;
        return 0;
    }
}
