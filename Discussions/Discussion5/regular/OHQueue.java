package Discussions.Discussion5.regular;

import java.util.Iterator;

public class OHQueue implements Iterable<OHRequest> {
    private final OHRequest request;

    public OHQueue(OHRequest request) {
        this.request = request;
    }

    @Override
    public Iterator<OHRequest> iterator() {
        return new TYIterator(request);
    }

    public static void main(String[] args) {
        OHRequest s5 = new OHRequest("I deleted all of my files, thank u", "Elena", true, null);
        OHRequest s4 = new OHRequest("conceptual: what is Java", "Stella", false, s5);
        OHRequest s3 = new OHRequest("got: I never did lab 1", "Omar", true, s4);
        OHRequest s2 = new OHRequest("help", "Angel", false, s3);
        OHRequest s1 = new OHRequest("no I haven't tried stepping through", "Ashley", false, s2);

        OHQueue q = new OHQueue(s1);
        for (OHRequest ticket : q)
            System.out.println(ticket.name);
    }
}
