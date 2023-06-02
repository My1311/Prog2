package Ubung5.A3;

import Ubung4.A3.Ringpuffer;
import Ubung5.A3.Folge;

import java.util.NoSuchElementException;

public class FolgeMitRing <T> implements Folge<T> {
    private Ringpuffer<T> ringpuffer;

    public FolgeMitRing(int capacity){
        this.ringpuffer = new Ringpuffer<>(capacity);
    }
    @Override
    public boolean isEmpty() {
        return ringpuffer.size() == 0;
    }

    @Override
    public int size() {
        return ringpuffer.size();
    }

    @Override
    public int capacity() {
        return this.capacity();
    }

    @Override
    public void insert(T elm) throws IllegalStateException {
        ringpuffer.addLast(elm);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return ringpuffer.removeFirst();
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        return ringpuffer.get(pos);
    }

    @Override
    public T set(int pos, T e) throws IndexOutOfBoundsException {
        return ringpuffer.set(pos,e);
    }

    @Override
    public void remove(int pos) throws IndexOutOfBoundsException {
        ringpuffer.remove(pos);
    }

    @Override
    public void insert(int pos, T e) throws IndexOutOfBoundsException {
        ringpuffer.insert(pos, e);
    }

}
