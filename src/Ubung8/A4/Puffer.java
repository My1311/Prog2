package Ubung8.A4;

public interface Puffer<T> extends Iterable<T> {

    boolean isEmpty() ;
     int size();
     int capacity();
     void insert(T elm) throws IllegalStateException;
    T remove() throws java.util.NoSuchElementException;
}
