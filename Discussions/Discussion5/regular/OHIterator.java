package Discussions.Discussion5.regular;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OHIterator implements Iterator<OHRequest> {
    private OHRequest curr;

    public OHIterator (OHRequest request) {
        curr = request;
    }

    public static boolean isGood(String description) {
        return description.length() >= 5;
    }

    @Override
    public boolean hasNext() {
        while (curr.next != null && !isGood(curr.description)) {
            curr = curr.next;
        }
        return curr != null;
    }

    @Override
    public OHRequest next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        OHRequest temp = curr;
        curr = curr.next;
        return temp;
    }
}
