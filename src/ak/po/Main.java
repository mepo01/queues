package ak.po;

import ak.po.iterators.ArrayFifoIterator;
import ak.po.iterators.ListFifoIterator;
import ak.po.queues.ArrayFifo;
import ak.po.queues.ListFifo;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        //Office office = new Office(5, 200);
        //office.run();
        ArrayFifoTest(16, 8);
        //ListFifoTest(16,8);
        //zadanie3cwiczenia(16,12);
    }
    public static void ArrayFifoTest(int TotalCapacity, int CapacityInUse) {
        if(TotalCapacity < CapacityInUse) {
            throw new IndexOutOfBoundsException("Podano za duży rozmiar");
        }
        ArrayFifo kolejka = new ArrayFifo(TotalCapacity);
        System.out.println("print pustej kolejki");
        System.out.println(kolejka.toString());
        System.out.print("test isEmpty: ");
        System.out.println(kolejka.isEmpty());
        System.out.print("test isFull: ");
        System.out.println(kolejka.isFull());
        System.out.println("dodawania do kolejki enqueue");

        for (int i = 0; i < CapacityInUse ; i++) {
            kolejka.enqueue(i);
        }
        System.out.println(kolejka.toString());

        System.out.println("test usuwania dequeue");
        kolejka.dequeue();
        System.out.println(kolejka.toString());
        kolejka.dequeue();
        System.out.println(kolejka.toString());
        kolejka.dequeue();
        System.out.println(kolejka.toString());
        System.out.println("dodano elementy 9 i 10");
        kolejka.enqueue(9);
        kolejka.enqueue(10);
        System.out.println(kolejka.toString());
        System.out.println("usunięto następny element z kolejki");
        kolejka.dequeue();
        System.out.println(kolejka.toString());
        System.out.println("dodano elementy 14/15");
        kolejka.enqueue(14); kolejka.enqueue(15);
        System.out.println(kolejka.toString());

        System.out.println("Próba opróżnienia kolejki");

        while (!kolejka.isEmpty()) {
            kolejka.dequeue();
        }
        System.out.println(kolejka.toString());

        System.out.println("dodanie elementów ponownie: ");
        for (int i = 0; i < CapacityInUse ; i++) {
            kolejka.enqueue(i);
        }
        System.out.println(kolejka.toString());
        //System.out.println("usunięto: " + kolejka.dequeue() + "\n" + kolejka.toString());
        System.out.println("test getItem: 0, 3, 15");
        //System.out.print(kolejka.getItem(-1) + " "); IndexOutOfBound
        System.out.print(kolejka.getItem(0) + " ");
        System.out.print(kolejka.getItem(3) + " ");
        System.out.println(kolejka.getItem(15) + " ");

        //System.out.print(kolejka.getItem(16) + " ");
        /*
        System.out.println("Próba przepełnienia kolejki");
        for (int i = 1; i <= TotalCapacity+1 ; i++) {
            kolejka.enqueue(i*10);
        }
        */
        System.out.println("uzupełnienie wolnych miejsc");
        kolejka.enqueue(8);kolejka.enqueue(9);kolejka.enqueue(10);
        kolejka.enqueue(11);kolejka.enqueue(12);kolejka.enqueue(13);
        kolejka.enqueue(14);kolejka.enqueue(15);
        System.out.println(kolejka.toString());
        System.out.println("czy zakręci (indeksy wyśrodkowane)");
        System.out.println(kolejka.toString());
        kolejka.dequeue();
        kolejka.dequeue();
        System.out.println(kolejka.toString());
        System.out.println("test getfirst/getlast");
        System.out.print(kolejka.getItem(kolejka.getFirst()) + "/");
        System.out.println(kolejka.getItem(kolejka.getLast()));
        System.out.println("pod indeksami: ");
        System.out.print(kolejka.getFirst() + "/");
        System.out.println(kolejka.getLast());
        System.out.println("środkując:");
        for (int i = 0; i < TotalCapacity; i++) {
            System.out.print(kolejka.array[i] + " ");
        }
    }

    public static void ListFifoTest(int TotalCapacity , int CapacityInUse) {
        ListFifo kolejka = new ListFifo(TotalCapacity);
        System.out.println("test dodawania do kolejki");
        for (int i = 0; i < CapacityInUse; i++) {
            kolejka.enqueue(i);
        }
        System.out.println(kolejka.toString());
        System.out.println("dodaję do kolejki 8/9/10");
        kolejka.enqueue(8);
        kolejka.enqueue(9);
        kolejka.enqueue(10);
        System.out.println(kolejka.toString());
        System.out.println("usuwam trzy elementy");
        kolejka.dequeue();
        kolejka.dequeue();
        kolejka.dequeue();
        System.out.println(kolejka.toString());
        /*while (!kolejka.isEmpty()) {
            kolejka.dequeue();
        }*/
        System.out.println("dodaję ponownie 0/1/2");
        kolejka.enqueue(0);
        kolejka.enqueue(1);
        kolejka.enqueue(2);
        System.out.println(kolejka.toString());
        System.out.println("test getitem: " + kolejka.getItem(2));
        System.out.println();
        System.out.println("Próba przepełnienia kolejki");
        while (!kolejka.isFull()) {
            kolejka.enqueue(30);
        }
        if (kolejka.isFull()) {
            System.out.println("zapełniono kolejke");
        }
        System.out.println(kolejka.toString());
        kolejka.dequeue(); kolejka.dequeue();
        System.out.println(kolejka.toString());
        System.out.print("get first: " + ((ListFifo.Node)kolejka.getFirst()).value + "/ ");
        System.out.println("get last: " + ((ListFifo.Node)kolejka.getLast()).value);
    }

    public static void zadanie3cwiczenia(int n, int m) {
        ArrayFifo a1 = new ArrayFifo(n);
        ArrayFifo a2 = new ArrayFifo(m);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            a1.enqueue(random.nextInt(31)+1);
        }
        for (int i = 0; i < m; i++) {
            a2.enqueue(random.nextInt(31)+1);
        }
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        int k = 0;
        int mniejsza = 0;
        if(n<m) {
            k = m - n;
            mniejsza = n;
        } else if (n>m) {
            k = n - m;
            mniejsza = m;
        }
        for (int i = 0; i < n; i++) {
            if((int)a1.getItem(i) % 2 == 0 && (int)a2.getItem(i) % 2 == 0) {
                System.out.println((int)a1.getItem(i) + (int)a2.getItem(i));
            }
            else if((int)a1.getItem(i) % 2 == 1 && (int)a2.getItem(i) % 2 == 1) {
                System.out.println((int)a1.getItem(i) * (int)a2.getItem(i));
            } else {
                if((int)a1.getItem(i) < (int)a2.getItem(i)) {
                    System.out.println((int)a1.getItem(i) * (int)a1.getItem(i));
                }
                else if((int)a1.getItem(i) > (int)a2.getItem(i)) {
                    System.out.println((int)a2.getItem(i) * (int)a2.getItem(i));
                } else {
                    System.out.println("elementy są równe");
                }
            }
        }
        for (int i = mniejsza; i < mniejsza+k; i++) {

        }
    }
}
