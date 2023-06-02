package Ubung3.A2;

import Ubung2.A2.Schlange;
import Ubung3.A1.EVL;

import java.util.NoSuchElementException;

public class SchlangeMitEVL<T> implements Schlange<T> {
    private int size = 0;
    private EVL<T> liste;
    @SuppressWarnings("unchecked")
    public SchlangeMitEVL() {

        this.liste = new EVL();

    }

    @Override
    public boolean isEmpty() {
        return liste.size() == 0;
    }

    @Override
    public int size() {
        return liste.size();
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void insert(T elm) throws IllegalStateException {
        if(size() == capacity()) {
            throw new IllegalStateException("Der Speicher ist voll, das Element kann nicht hinzugefuert werden.");
        }
        liste.addLast(elm);
    }

    @Override
    public T remove() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("Der Speicher ist leer, das Element kann nicht entfernt werden.");
        }
        T tmp = liste.getFirst();
        liste.removeFirst();
        return tmp;
    }

    @Override
    public T front() {
        if (isEmpty()){
            return null;
        }
        return liste.getFirst();
    }
}
