package Ubung8.A4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FolgeMitDynArray<T> implements Folge<T> {
    private DynArray<T> dynArray;
    public FolgeMitDynArray() {
        this.dynArray = new DynArray<>();
    }
    @Override
    public boolean isEmpty() {
        return dynArray.size() == 0;
    }
    @Override
    public int size() {
        return dynArray.size();
    }
    @Override
    public int capacity() {
        return dynArray.capacity();
    }
    @Override
    public void insert(T elm) throws IllegalStateException {
        dynArray.addLast(elm);
    }
    @Override
    public T remove() throws NoSuchElementException {
        return dynArray.removeFirst();
    }
    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        return dynArray.get(pos);
    }
    @Override
    public T set(int pos, T e) throws IndexOutOfBoundsException {
        return dynArray.set(pos, e);
    }
    @Override
    public void remove(int pos) throws IndexOutOfBoundsException {
        dynArray.remove(pos);
    }
    @Override
    public void insert(int pos, T e) throws IndexOutOfBoundsException {
        dynArray.insert(pos, e);
    }
    @Override
    public Iterator<T> iterator() {
        return dynArray.iterator();
    }
}
