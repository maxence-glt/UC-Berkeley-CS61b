package Discussions.Discussion5.regular;

import java.util.NoSuchElementException;

public class TYIterator extends OHIterator{
    public TYIterator(OHRequest queue) {
        super(queue);
    }

    @Override
    public OHRequest next() {
        OHRequest result = super.next();
        if (result.description.contains("thank u")) {
            result = super.next();
        }
        return result;
    }
}
