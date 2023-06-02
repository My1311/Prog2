package Ubung4.A3;

import java.util.NoSuchElementException;

public class Ringpuffer<T> {
    private int size; // groesse
    private int entryPosition;
    private T[] data;

    public Ringpuffer(int capacity) {
        this.data = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return data.length;
    }

    // Gibt den Inhalt an pos zuruck. Beachten Sie dass Ihr Array nur ¨ capacity lang ist.
    public T get(int pos) {
        if ((pos > -1) && (pos < size())) {
            if (data[(pos + entryPosition) % capacity()] != null) {
                return data[(pos + entryPosition) % capacity()];
            }
        }
        throw new IndexOutOfBoundsException();
    }

    //Fugt das ¨ ubergebene Element an Position ¨ pos ein und gibt den alten Wert zuruck
    public T set(int pos, T e) {
        int aktuell = (pos + entryPosition) % capacity();
        if ((pos > -1) && (pos < size())) {
            if (data[aktuell] != null) {
                T ret = data[aktuell];
                data[aktuell] = e;
                return ret;
            }
        }
            throw new IndexOutOfBoundsException();
    }
    private int oft = 0;
    //Fugt das ¨ ubergebene Element vorne ein, gibt aber nichts zur ¨ uck. ¨
    public void addFirst(T e) {
        int aFPos;
        int pos = (capacity() - 1);
        //int oft = 0; // wie viel Male diese Methode wird angerufen.
        if (this.size < capacity()) {
            if (entryPosition == 0) {
                aFPos = capacity() - 1 - oft;
            } else {
                if((entryPosition - 1 - oft) >=0) {
                    aFPos = entryPosition - 1 - oft;
                }else {
                    aFPos = pos ;
                    pos--;
                }
            }
            oft++;
            data[aFPos] = e;
            size++;

        } else {
            throw new IllegalArgumentException();
        }
    }

    //Fugt das ¨ ubergebene Element hinten ein, gibt aber nichts zur ¨ uck.
    public void addLast(T e) {
        if (this.size <= capacity()) {
            data[(entryPosition + size) % capacity()] = e;
            size++;
        } else {
            throw new IllegalArgumentException();
        }

    }

    //Entfernt das erste Element und gibt den Inhalt zuruck. ¨
    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T ret = data[entryPosition];
        // Wir machen hier den Wert von ersten Element gleich null
        // und der Wert von entryPosition ist immer um 1 erhöht danach.
        // T ret = data[0], data[0] = null, entryP wird um 1 nach Anweisungen erhöht
        data[entryPosition++] = null;
        size--;
        return ret;
    }

//• removeLast():
    //Entfernt das letzte Element und gibt den Inhalt zuruck.
    public T removeLast(){
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T ret = data[entryPosition+size()-1];
        data[entryPosition+size()-1] = null;
        size--;
        return ret;
    }
    public void remove(int pos) throws IndexOutOfBoundsException {
        if ((pos > -1) && (pos < size())) {
            T tmp = data[pos];
            // ! Note: i muss < size() -1;
            for (int i = pos; i < size()-1 ; i++) {
                data[i] = data[i+1];
            }
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public void insert(int pos, T e) throws IndexOutOfBoundsException {
        if ((pos > -1) && (pos <= size()) && (size() < capacity())) {

               if(size == 0){
                   addLast(e);
               }else {

                   size++;
                   for (int i = size - 1; i >= pos; i--) {
                       data[i] = data[i - 1];
                   }
                   data[pos] = e;
               }


        } else {
            throw new IndexOutOfBoundsException();
        }
    }

}