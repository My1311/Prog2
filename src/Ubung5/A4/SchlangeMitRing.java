package Ubung5.A4;

import Ubung2.A2.Schlange;
import Ubung4.A3.Ringpuffer;

import java.util.NoSuchElementException;

public class SchlangeMitRing <T> implements Schlange<T> {
    private Ringpuffer<T> speicher;
    public SchlangeMitRing(int capacity) {
        this.speicher = new Ringpuffer<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return speicher.size() == 0;
    }

    @Override
    public int size() {
        return speicher.size();
    }

    @Override
    public int capacity() {
        return speicher.capacity();
    }

    @Override
    public void insert(T elm) throws IllegalStateException {
        speicher.addLast(elm);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return speicher.removeFirst();
    }

    @Override
    public T front() {
        return speicher.get(0);
    }
}
