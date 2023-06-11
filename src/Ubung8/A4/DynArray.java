package Ubung8.A4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynArray<T> implements Iterable<T>{
    private int size = 0;
    private int capacity = 1;
    private T[] data;

    public DynArray() {
        this.data = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public T get(int pos) {
        if ((pos >= size) || (pos < 0)) {
            throw new IndexOutOfBoundsException();
        }
        return data[pos];
    }

    public T set(int pos, T e) {
        if ((pos >= size) || (pos < 0)) {
            throw new IndexOutOfBoundsException();
        }
        T ret = data[pos];
        data[pos] = e;
        return ret;
    }

    public void addFirst(T e) {
        if (size == capacity) {
            increase();
        }
        size++;
        for (int i = 0; i < size; i++) {
            data[i + 1] = data[i];
        }
        data[0] = e;
    }

    public void addLast(T e) {
        if (size == capacity) {
            increase();
        }
        data[size++] = e;
    }

    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T ret = data[0];
        for (int i = 0; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (4 * size <= capacity) {
            decrease();
        }
        return ret;
    }

    public T removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T ret = data[size-1];
        size--;
        if (4 * size <= capacity) {
            decrease();
        }
        return ret;

    }

        private void increase() {
            capacity *= 2;     // verdopple die Kapazität
            T[] newData = (T[]) new Object[capacity];
            int index = 0;
            for (T e : data) {
                newData[index++] = e; // kopiere Elemente
            }
            data = newData;
        }
        private void decrease() {
            // kopiere Elemente
            T[] newData = (T[]) new Object[capacity/2];
            // Wir kopieren das Rest von data zu neuen Data Array.
            // Beachtung: Die Lange von newData ist nur halbiert( hier 4)
            for (int i=0;  i < newData.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
            capacity /= 2; // halbiert die Kapazität

        }

    public void remove(int pos) throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (4 * size <= capacity) {
            decrease();
        }
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
        if (size == capacity) {
            increase();
        }
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
    private class DynArrayIterator implements Iterator<T> {
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i < data.length ;
        }

        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[i++];
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new DynArrayIterator();
    }
}