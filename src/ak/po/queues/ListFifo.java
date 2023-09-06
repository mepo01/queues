package ak.po.queues;

import ak.po.exceptions.EmptyQueueException;
import ak.po.exceptions.FullQueueException;
import ak.po.interfeces.IteratorInterface;
import ak.po.interfeces.Queue;
import ak.po.iterators.ArrayFifoIterator;
import ak.po.iterators.ListFifoIterator;

public class ListFifo implements Queue {
    public class Node {
        public Object value;
        public Node next;

        public Node(Object v) {
            value = v;
            next = null;
        }
    }

    private int size;
    private Node first;
    private Node last;
    private int x;

    public ListFifo(int TotalCapacity) {
        x = TotalCapacity;
        clear();
    }

    public void clear() {
        first = last = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return x == size;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void enqueue(Object value) throws FullQueueException {
        Node newNode = new Node(value);
        if (size >= x){
            throw new FullQueueException("Kolejka jest pełna");
        }
        if (isEmpty()) {
            first = newNode;
            last = first;
            size++;
        } else if (size > 0) {
            last.next = newNode;
            last = newNode;
            size++;
        }
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Kolejka jest pusta");
        }
        Object tmp = first.value;
        first = first.next;
        size--;
        if(isEmpty()) {
            clear();
        }
        return tmp;
    }

    public Object getItem(int n) {
        if (n<0 || n>size()) {
            throw new IndexOutOfBoundsException("Nieprawidłowy indeks");
        }
        Node node = first;
        for (int i = 0; i < n; i++ ) {
            node = node.next;
        }
        Object tmp = node.value;
        /**
         * Uzupełnić brakujący kod
         */
        return tmp;
    }

    public String toString() {
        /*String tmp = "Amount: " + amount + "\n";
        tmp += "First: " + first + "\n";*/
        String tmp = size + ": ";
        //for (int i=first; i<(first+amount); i++) {
        //  tmp += array[i%array.length] + ", ";
        // }

        IteratorInterface it = new ListFifoIterator(this);
        for (it.first(); !it.isDone(); it.next()) {
            tmp += it.current() + ", ";
        }
        return tmp;
    }
}