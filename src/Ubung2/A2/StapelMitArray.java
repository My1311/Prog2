package Ubung2.A2;

import Ubung2.A2.Stapel;

import java.util.NoSuchElementException;

public class StapelMitArray<T> implements Stapel<T> {

    // private int maxGroesse;// capacity // braucht man nicht als Variable von Konstruktor deklart werden
    private int size = 0;
    private T[] array;
    @SuppressWarnings("unchecked")

    public StapelMitArray(int maxGroesse){
       // this.maxGroesse = maxGroesse;
        this.array = (T[]) new Object[maxGroesse];
    }
    @Override
    public boolean isEmpty() {
        return size == 0; // ob size gleich null ist?
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public int capacity() {
        return array.length;
    }
    public boolean isFull() {
        return size == array.length;
    }
    @Override
    public void insert(T elm) {
        if(isFull()) {
          throw new IllegalStateException("Der Speicher ist voll, das Element kann nicht hinzugefuert werden.");
        }
        array[size++] = elm; // array[0] = elm, und spater size = 1; passt gut
    }
    @Override
    public T remove() {
       if(this.isEmpty()) {
           throw new NoSuchElementException("Der Speicher ist leer, das Element kann nicht entfernt werden.");
       }
       return array[--size];
    }

    @Override
    public T top() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("Der Speicher ist leer, das Element kann nicht zurückgegeben werden.");
        }
        return array[size-1];
    }

}
