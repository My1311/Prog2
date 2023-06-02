package Ubung2.A1;

public class Annotationen<T> {
    T[] feld;
    @SuppressWarnings("unchecked")
    public Annotationen(int capacity){
        feld = (T[]) new Object[capacity];
    }

    public void insert(int pos, T e){
        if(pos<0||pos>=feld.length) throw new UnsupportedOperationException();
        feld[pos] =e;
    }

    public T remove(int pos){
        if(pos<0||pos>=feld.length) throw new UnsupportedOperationException();
        if(feld[pos]==null) throw new NullPointerException();
        return feld[pos];
    }
}

class Main {
    public static void main(String[] args) {
        // <T> kann String, Double, Integer ( alle Klassen von Objekt erben, jede Komplex Typen), nicht int, double , ..( primitiven Typen)
        // sonst mussen wir Wrapper Klasse benutzen, wenn wir int benutzen mochten
        Annotationen<String> a = new Annotationen<>(10);
        a.insert(0,"hallo");

        int a3 = 3;
        Integer b = a3;
        b = 4;
    }
}
