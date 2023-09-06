package ak.po.interfeces;

import ak.po.exceptions.EmptyQueueException;

public interface Queue
{
    public void enqueue(Object value); //wstaw do kolejki
    public Object dequeue() throws EmptyQueueException; //pobierz z kolejki
    public void clear(); //usuń wszystkie elementy
    public int size(); //podaj rozmiar kolejki
    public boolean isEmpty(); //sprawdz czy jest pusta
}
