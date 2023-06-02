package Ubung0.A2;

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
    public boolean isFull() {
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
       return array[--size];
    }

    @Override
    public int top() {
        return array[size-1];
    }

    public void applyToAll(Funktion f){
        for (int i = 0; i < array.length; i++) {
            array[i] = f.auswerten(array[i]);
        }


    }

    /*public static void main(String[] args) {
        StapelMitArray s = new StapelMitArray(10);
        for (int i = 0; i < 10; i++) {
            s.insert(i);
        }
        System.out.println(Arrays.toString(s.array));
        s.applyToAll((i) -> {
            return i*5;
        });
        System.out.println(Arrays.toString(s.array));

    }*/
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
        StapelMitArray b = new StapelMitArray(4);
        System.out.println(b.isEmpty());
        System.out.println(b.isFull());
        for (int i: ints) {
            b.insert(i);
        }
        System.out.println(b.isEmpty());
        System.out.println(b.isFull());
        System.out.println(b.size);
        System.out.println(b.capacity());
        System.out.println(b);
        System.out.println(b.remove());
        System.out.println(b);

    }
}
