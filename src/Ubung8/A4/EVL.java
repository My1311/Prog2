package Ubung8.A4;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class EVL<T> implements Iterable<T>{
    Listenelement first = null; // Zeiger auf das erste Element
    int size = 0;       // Anzahl der Listenelemente

    class Listenelement {
        T data;
        Listenelement next = null;

        Listenelement(T o) {
            this.data = o;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new EVLIterator();
    }
    private class EVLIterator implements Iterator <T>{
        private Listenelement i = first; // i ist Index
        // wir konnen hier auch Konstruktor public EVLIterator hier machen , aber das ist nicht nötigt
        @Override
        public boolean hasNext() {
            return i != null; // solang das nächste Element von i nicht Null ist
        } // 1 2 3 4

        @Override
        public T next() {
            if(! hasNext()){
                throw new NoSuchElementException();
            }
            T ret = i.data; // speicher der Data
            i = i.next; // zu nächsten Element gehen
            return  ret;
        }
    }

    public static void main(String[] args) {
        EVL<Integer> evl = new EVL<>();
        evl.addLast(1);
        evl.addLast(2);
        evl.addLast(3);
        for(Integer i : evl){
            System.out.println(i);
        }
    }
    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }
    public T getLast() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Listenelement le = first;
        while (le.next != null) {
            le = le.next;
        }
        return le.data;
    }

    public void addFirst(T o) {
        Listenelement e = new Listenelement(o);
        if (null == first)
            first = e;
        else {
            e.next = first;
            first = e;
        }
        size++;
    }
    public void addLast(T e) {
        Listenelement neu = new Listenelement(e);
        if (size == 0) {
            first = neu;
        } else {
            Listenelement tmp = first;
            // Die Liste durchlaufen bis Ende Liste (tmp.next == Null)
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            // Wir setzen das letzte Element (nämlich tmp.next) zu neu (T e)
            tmp.next = neu; // letztes element aus der Liste
        }
        size++;
    }
    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T ret = first.data;
        // First ListElement(data, next) wird von first.next ListElement überschrieben.
        first = first.next;
        size--;
        return ret;
    }
    public T removeLast() {
        // Wenn size = 0, dann first = null, Execption wird geworfen
        if (size == 0) {
            throw new NoSuchElementException();
        }
        // Wenn size = 1, dann first hat 1 Data und zeigt zu keinem.
        // Wenn man letzten Element loschen mochte, dann mach first ist gleich null
        T ret = first.data;
        if (size == 1) {
            first = null;
        } else {
            Listenelement last = first;
            // Man sucht das letztee Element mit diesem Algorithem,
            // Weil man weiss, das next Element von last Element muss gleich null sein
            while (last.next.next != null) {
                last = last.next;
            }
            // Gibt das letzte Element von Liste zurück
            ret = last.next.data;
            // löschen das letzte Element
            last.next = null;
        }
        size--;
        return ret;
    }

    //pruft, ob die Liste den ubergebenen Referenzwert beinhaltet.
    public boolean contains(T e) {
        Listenelement le = first;
        while (le != null) {
            if (le.data.equals(e))
                return true;
            else {
                le = le.next;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
    @Override
    public String toString() {
        return toString(this.first, "");
    }

    private String toString(Listenelement elm, String s) {
        if (elm.next == null) {
            return s + elm.data;
        }
        s += elm.data + "-";
        return toString(elm.next, s);
    }

    public void add(int pos, T elm) {
        if(pos >= size() || pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0){
            addFirst(elm);
        } else {
            Listenelement tmp = first;
            for (int i = 0; i < pos - 1; i++) {
                tmp = tmp.next; // tmp wird auf das nächste Element gesetzt. tmp wird die gewuschten Position erreichen (bei pos)
            }
            // Wir mochten nicht das nächste Element von hinzugefügten Position überschreiben,
            // Sondern wollen wir das Element in tmp2 speichern, sodass wir es nicht verlieren.
            Listenelement tmp2 = tmp.next;
            // das nächste Element von tmp ist das neue Element (elm )
            tmp.next = new Listenelement(elm);
            // das nächste Element von this neu hinzugefügten Element ist tmp2
            tmp.next.next = tmp2;
            size++;
        }
    }

}
