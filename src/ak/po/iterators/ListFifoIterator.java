package ak.po.iterators;

import ak.po.interfeces.IteratorInterface;
import ak.po.queues.ListFifo;

import java.util.LinkedList;

public class ListFifoIterator implements IteratorInterface {
    private ListFifo list;
    private ListFifo.Node current;

    public ListFifoIterator(ListFifo l) {
        list = l;
        current = null;
    }

    public void previous() {
        int licznik = 0;
        while(isDone()) {
            next();
            licznik++;
        }
        first();
        for (int i = 0; i < list.size()-licznik-1; i++) {
            next();
        }
    }

    public void next() {
        current = current.next;
    }

    public void first() {
        current = list.getFirst();
    }

    public void last() {
        current = list.getLast();
    }

    public boolean isDone() {
        return current == null;
    }

    public Object current() {
        return current.value;
    }
}
