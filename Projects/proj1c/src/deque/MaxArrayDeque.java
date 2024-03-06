package Projects.proj1c.src.deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    Comparator<T> defaultComparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        defaultComparator = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }
        T maxItem = this.get(0);
        for (T i : this) {
            if (defaultComparator.compare(i, maxItem) > 0) {
                maxItem = i;
            }
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxItem = this.get(0);
        for (T i : this) {
            if (c.compare(i, maxItem) > 0) {
                maxItem = i;
            }
        }
        return maxItem;
    }
}
