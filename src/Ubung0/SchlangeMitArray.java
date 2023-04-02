package Ubung0;

import java.util.NoSuchElementException;

public class SchlangeMitArray implements Schlange{
    private int maxGroesse;// capacity
    private int size = 0;
    private int[] array;
    public SchlangeMitArray(int maxGroesse){
        this.maxGroesse = maxGroesse;
        this.array = new int [maxGroesse];
    }

    @Override
    public boolean isEmpty() {
        return  size == 0;
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
        array[size++] = elm;
    }

    @Override
    public int remove() {
        if(isEmpty()){
            throw new NoSuchElementException("Der Speicher ist leer, das Element kann nicht entfernt werden.");
        }
        int tmp = array[0];
        // Wir lassen den letzen Wert stehen, da er beim naeschten Einfuegen ueberschrieben wird
        // zb: ein Array von {3,4,6,8} wird nach dem Schleife {4,6,8,8}. 8 am Ende wird verschwunden nach dem wir: size--;
        for (int i = 0; i <size-1 ; i++) {
            array[i] = array[i+1];
        }
        size--;
        return tmp;
    }

    @Override
    public int front() {
        return array[0];
    }
}
