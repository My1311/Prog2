package Ubung0;

import java.util.NoSuchElementException;

public class StapelMitArray implements Stapel {
    private int maxGroesse;// capacity
    private int size = 0;
    private int[] array;
    public StapelMitArray(int maxGroesse){
        this.maxGroesse = maxGroesse;
        this.array = new int [maxGroesse];
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
        return maxGroesse;
    }
    private boolean isFull() {
        return size == maxGroesse;
    }
    @Override
    public void insert(int elm) {
        if(isFull()) {
          throw new IllegalStateException("Der Speicher ist voll, das Element kann nicht hinzugefuert werden.");
        }
        array[size++] = elm; // array[0] = elm, und spater size = 1; passt gut
    }
    @Override
    public int remove() {
       if(isEmpty()) {
           throw new NoSuchElementException("Der Speicher ist leer, das Element kann nicht entfernt werden.");
       }
       return array[size--];
    }

    @Override
    public int top() {
        return array[size];
    }
}
