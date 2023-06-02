package Ubung3.A1;

import java.util.NoSuchElementException;

public class EVL<T> {

    Listenelement first = null; // Zeiger auf das erste Element
    int size = 0;       // Anzahl der Listenelemente

    class Listenelement {
        T data;
        Listenelement next = null;

        Listenelement(T o) {
            this.data = o;
        }
    }

    // Die Methoden geben das erste Element der Liste zuruck.
    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    // Die Methoden geben das letzte Element der Liste zuruck.
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

    // Die Methode nimmt eine Referenzvariable e an und fugt ein neues Item mit e als
    // Inhalt hinten an die einfach verkettete Liste an.
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

    /**
     * @return Gibt das erste Element von Liste zurück, was entfernt wird.
     */
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

    /**
     * Die Methode entfernt das letzte Listenelement und gibt dessen Inhalt zuruck
     *
     * @return Gibt das letzte Element von Liste zurück, was entfernt wird.
     */
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

    /*public String toString() {
        String s = "";
        Listenelement tmp = first;
        while (tmp != null) {
            if (tmp != first) {
                s = s + "-";
            }
            s = s + tmp.data;
            tmp = tmp.next;
        }
        return s;
    }*/

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

    public void zip(EVL<T> other) {
        // Sonderfall: aktuelleListe ist leer
        if (size == 0) {
           first = other.first;
           size = other.size;
        }
         // Sonderfall: übergebene Liste ist leer
        if(other.size == 0) {
            return;
        }
        // Normalfall
        // Wir gehen die Schleife durch beim Benutzen eine temporary Variable mit Anfangswert = first
        Listenelement index = first;
        // Bedingungen: Schleife durchlaufen lassen und aufhören
        while (!(other.size == 0)) {
            // Wir machen auch eine Schleife bei anderen Liste (other)
            Listenelement tmp = new Listenelement(other.removeFirst());
            // die Reihe ist so, nicht umgekehrt, sonst das Element index.next wird überschrieben
            tmp.next = index.next;
            index.next = tmp;
            // Wir sind fertig mit erster Zahl von otherList (1- 10 -2). Gehen wir zu nachste Zahl
            index = index.next;
            if(index.next !=null) {
                index = index.next;
            }

        }

    }
//    public void zip(EVL<T> other){
//        // Sonderfall: aktuelleListe ist leer
//        if(size == 0){
//            first = other.first;
//            size = other.size;
//            // other soll nacher leer sein
//            other.first = null;
//            other.size = 0;
//            return;
//        }
//        // Sonderfall :ubergebene Liste ist leer
//        if(other == null) {
//            return;
//        }
//        if(other.size == 0){
//            return;
//        }
//        // Normalfall
//        Listenelement thiscurrent = first;
//        Listenelement thiscurrennext = first.next;
//        Listenelement othercurrent =other.first;
//        Listenelement othercurrentnext =other.first.next;
//    while ((null !=thiscurrent) && (null != othercurrent ))
//     if(null != othercurrent) {
//         othercurrent.next = thiscurrentnext;
//    thiscurrent.netElement = othercurrent;
//    other.first = othercurrentnext;
    // aktuelle Zeigerelement weiterschieben
//    thiscurrent =thiscurrennext;
//    thiscurrennext =thiscurrennext.next;
//    othercurrent =othercurrentnext;
//    if(null != othercurrentnext) {
//    othercurrentnext =othercurrentnext.next;
//    size++;
//    other.size--;}
//}

//    }}

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

    public static void main(String[] args) {
//        EVL<String> liste = new EVL<>();
//        String[] cities= {"Aachen","Bonn","Chemintz", "Dortmund","Essen"};
//
//        for(String s:cities) {
//            liste.addLast(s);
//        }
//        System.out.println(liste.toString());

        EVL<Integer> liste1 = new EVL<>();
        EVL<Integer> liste2 = new EVL<>();
        int [] array1 = {4,1,7,9,0,2};
        int [] array2 = {3};
        for(int i:array1) {
            liste1.addLast(i);
        }

        for(int i:array2) {
            liste2.addLast(i);
        }
        liste1.zip(liste2);
        System.out.println(liste1);

    }
}
