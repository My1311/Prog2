package Ubung8.A4;
public interface Folge<T> extends Puffer<T> {
    T get(int pos) throws IndexOutOfBoundsException;
    T set(int pos, T e) throws IndexOutOfBoundsException;
    void remove(int pos) throws IndexOutOfBoundsException;
    void insert(int pos, T e) throws IndexOutOfBoundsException;
}
