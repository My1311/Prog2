package Ubung8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray<T> implements Iterator<T> {
    private int pos, stop; // index(Referzenz) = 0
    private T[] a;
    public Iterator1DArray(T[] a){
        this.pos = 0;
        stop = -1; // nicht stoppen, ende = a.length;
        this.a = a;
        // this(a,start:0)
    }
    // Von Start bis Ende
    public Iterator1DArray(T[] a, int start) {
        this.pos = start;
        stop = -1;
        this.a = a;
    }
    // Von Start bis Ende (exklusiv)
    public Iterator1DArray(T[]a, int start, int ende) {
        this.pos = start;
       /*falls die übergebene Länge nicht inerhalb des
         Arrays liegt wird IllegalArgumentException geworfen.*/

        stop = ende;
        if(ende >a.length || ende < pos) {
            this.stop = a.length;
            // throw  new IllegalArgumentException("Ende liegt nicht innerhalb des Arrays!");
        }
        this.a = a;
    }
    @Override
    public boolean hasNext() {
        {/*Falls ein spezifisches ende nicht gewünscht ist wird
       die länge des Arrays benutzt sonnst die gewünschte länge*/
            return this.stop != -1 ? this.pos < this.stop : pos < a.length;
        }
    }
    @Override
    public T next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return a[pos++]; // First, a[pos] wird zuruckgegeben und dann a[pos+1]
        // wegen pos++: ergibt pos und erhöht pos um 1
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4};
        Iterator1DArray<Integer> speicher = new Iterator1DArray<>(a);
        //                                                       (new String [] {"Mandy","Andy","candy"})
        // for(int i : a) {System.out.println(i);}
        for(; speicher.hasNext(); System.out.println(speicher.next())); // 1,2,3,4
        /* while(speicher.hasNext()){
        System.out.println(speicher.next());
         */
        Iterator1DArray<Integer> speicher1 = new Iterator1DArray<>(a,1);
        for(; speicher1.hasNext(); System.out.println(speicher1.next())); // 2,3,4
        Iterator1DArray<Integer> speicher2 = new Iterator1DArray<>(a,1,3);//2,3
        for(; speicher2.hasNext(); System.out.println(speicher2.next()));

    }
}
