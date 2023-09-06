package ak.po.iterators;

import ak.po.interfeces.IteratorInterface;
import ak.po.queues.ArrayFifo;

public class ArrayFifoIterator implements IteratorInterface
{
    ArrayFifo queue = null;
    int current;
    boolean czywszystko = false;
    public ArrayFifoIterator(ArrayFifo q)
    {
        queue = q;
        current = 0;
        czywszystko = false;
        first();
    }
    public void previous()
    {
        current--;
        /**
         * Uzupełnić brakujący kod
         */
    }
    public void next()
    {
        current++;
        current = current % queue.size();
        /**
         * Uzupełnić brakujący kod
         */
    }
    public void first()
    {
        current = queue.getFirst();
        /**
         * Uzupełnić brakujący kod
         */
    }
    public void last()
    {
        //ostatni w kolejce do usunięcia
        current = queue.getLast();
        /**
         * Uzupełnić brakujący kod
         */
    }
    public boolean isDone()
    {
        if(current == queue.getFirst() && czywszystko == true) {
            return true;
        } else {
            czywszystko = true;
        }

        return false;
        /**
         * Uzupełnić brakujący kod
         */
    }
    public Object current() throws IndexOutOfBoundsException
    {
        return queue.getItem(current);
    }
}