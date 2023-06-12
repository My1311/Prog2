package Ubung8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SnakeIterator2DArray<T> implements Iterator<T> {
    private int einsD, zweiD;
    private T[][] a; // matrix a
    public SnakeIterator2DArray(T[][] a){
        this.einsD = 0; // position in 1.Demension
        this.zweiD = 0;
        this.a = a;
    }
    /* Alle Elemente in 2D Array ausdrucken
    for(int i=0; i<a.length; i++) {
        for(int j=0; j<a[i].length; j++) {
            System.out.println("Values at arr["+i+"]["+j+"] is "+a[i][j]);
        }
    }*/
    @Override
    public boolean hasNext() {
        return (einsD < a.length && zweiD < a[einsD].length);
        // return (einsD < a.length && zweiD <= a[0].length);
        // In diesem Beispiel, a.length = 3, a[0].length = 4
        // Die Bedingung fur hasNext sollte nur einsD < a.length && zweiD < a[0].length,
        // aber wir brauchen zweiD = a[0].length fur die Bedingung fur next().
        // Wenn wir haben viele unterschielichen Array, dann soolte j < a[i].length
    }

    @Override
    /*
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if(zweiD == a[0].length ) {
            einsD++;
            zweiD = 0;
        }
        if (einsD % 2 == 0) {
            return a[einsD][zweiD++];
        } else {
            return a[einsD][ (a[einsD].length - (zweiD++) - 1)];
        }
    }*/
    public T next(){
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        T value = a[einsD][zweiD];
        // increment i j
        if(einsD % 2 == 0){ // gerade
            if(zweiD +1 < a[einsD].length){ // nicht am Ende
                zweiD++;
            }
            else { // am Ende
                zweiD = a[einsD].length - 1; // am Ende, hier j = 3
                einsD++;
            }
        }
        else {// ungerade
            if(zweiD > 0) { // nicht am Ende
                zweiD--;
            }
            else{
                einsD++; // am Ende
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Integer[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SnakeIterator2DArray speicher = new SnakeIterator2DArray<Integer>(a);
        for(; speicher.hasNext(); System.out.println(speicher.next()));

        SnakeIterator2DArray<Integer> sa = new SnakeIterator2DArray<>(new Integer[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        });
    }
}
