package ak.po.queues;

import ak.po.exceptions.EmptyQueueException;
import ak.po.exceptions.FullQueueException;
import ak.po.interfeces.IteratorInterface;
import ak.po.interfeces.Queue;
import ak.po.iterators.ArrayFifoIterator;

public class ArrayFifo implements Queue
{
    public Object array[];
    private int currentSize;
    private int first;
    private int last;

    public ArrayFifo(int size)
    {
        array = new Object[size];
        clear();
    }

    public void enqueue(Object value) throws FullQueueException
    {
        if (!isFull()) {
            last = (last+1) % array.length;
            array[last] = value;
            currentSize++;
            /**
             * Uzupełnić brakujący kod
             */
        } else {
            throw new FullQueueException("Kolejka jest pełna");
        }
    }

    public Object dequeue() throws EmptyQueueException
    {
        if (isEmpty()) {
            throw new EmptyQueueException("Kolejka jest pusta");
        }
        Object tmp = array[first];
        array[first] = null;
        first = (first+1) % array.length;
        currentSize--;

        if(currentSize == 0) {
            first = 0;
            last = -1;
        }
        /**
         * Uzupełnić brakujący kod
         */
        return tmp;
    }

    public void clear()
    {
        for (int i=0; i<array.length; i++) {
            array[i] = null;
        }
        currentSize = 0;
        first = 0;
        last = -1;
    }

    public int size()
    {
        return array.length;
    }

    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    public boolean isFull() {
        return  currentSize == array.length;
    }

    public String toString()
    {
        /*String tmp = "Amount: " + amount + "\n";
        tmp += "First: " + first + "\n";*/
        String tmp = currentSize + ": ";
        //for (int i=first; i<(first+amount); i++) {
        //  tmp += array[i%array.length] + ", ";
        // }

        IteratorInterface it = new ArrayFifoIterator(this);
        for (it.first(); !it.isDone(); it.next()) {
            tmp += it.current() + ", ";
        }

        return tmp;
    }

    public Object getItem(int i)
    {
        if (i<0 || i>size()) {
            throw new IndexOutOfBoundsException("Nieprawidłowy indeks");
        }
        Object tmp = null;
        tmp = array[i];

        /**
         * Uzupełnić brakujący kod
         */
        return tmp;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }
}
