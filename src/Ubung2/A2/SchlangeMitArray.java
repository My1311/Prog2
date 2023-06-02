package Ubung2.A2;


import java.util.NoSuchElementException;

public class SchlangeMitArray<T> implements Schlange<T> {
    private int size = 0;
    private T[] array;
    @SuppressWarnings("unchecked")
    public SchlangeMitArray(int maxGroesse){
        this.array = (T[]) new Object[maxGroesse];
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
        return array.length;
    }
    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public void insert(T elm) {
        if(isFull()) {
            throw new IllegalStateException("Der Speicher ist voll, das Element kann nicht hinzugefuert werden.");
        }
        array[size++] = elm;
    }

    @Override
    public T remove() {
        if(isEmpty()){
            throw new NoSuchElementException("Der Speicher ist leer, das Element kann nicht entfernt werden.");
        }
        T tmp = array[0];
        // Wir lassen den letzen Wert stehen, da er beim naeschten Einfuegen ueberschrieben wird
        // zb: ein Array von {3,4,6,8} wird nach dem Schleife {4,6,8,8}. 8 am Ende wird verschwunden nach dem wir: size--;
        for (int i = 0; i <size-1 ; i++) {
            array[i] = array[i+1];
        }
        size--;
        return tmp;
    }

    @Override
    public T front() {
        return array[0];
    }
    public String toString() {
        String s = "[";
        for (int i = 0; i < size() ; i++) {
            if(i>0)
                s += ",";
                s += array[i] ;
        }
        s +="]";
        return s;
    }
}
