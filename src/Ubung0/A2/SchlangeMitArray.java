package Ubung0.A2;

import java.time.Instant;
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
    // for( ) {if() {s +=} } ist anders von for( ) {if() s += } ( ohne Klammer von if.
    // Weil mit Klammern werden nur Befehle s += unter Bedingungen von if gemacht werden.
    public String toString() {
        String s = "[";
        for (int i = 0; i < size() ; i++) {
            if(i>0)
                s +=  ",";
                s += array[i];

        }
        s +="]";
        return s;
    }

    public static void main(String[] args) {

        int[] ints = {2,4,6,8};
        SchlangeMitArray a = new SchlangeMitArray(4);
        System.out.println(a.isEmpty());
        System.out.println(a.isFull());
        for (int i: ints) {
            a.insert(i);
        }
        System.out.println(a.isEmpty());
        System.out.println(a.isFull());
        System.out.println(a.size);
        System.out.println(a.capacity());
        System.out.println(a);
        System.out.println(a.remove());
        System.out.println(a);
    }
}
