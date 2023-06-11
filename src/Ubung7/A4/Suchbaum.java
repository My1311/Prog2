package Ubung7.A4;

import Ubung6.A1.IntSuchbaum;

import java.util.Comparator;

public class Suchbaum<T>{
    private BaumEl wurzel;
    private class BaumEl {
        T data;
        BaumEl links; // Weil Baum ist kein initialisierter Typ, musssen wir immer links oder rechts initialisiert werden.
        BaumEl rechts;

        BaumEl(T content) {
            data = content;
            links = null;
            rechts = null;
        }

    }
    private Comparator<T> comp;

    public Suchbaum() {
        wurzel = null;
    }
    public Suchbaum(Comparator<T> comp){
        this.comp = comp;
    }

  // in insert Method  if(i<knoten.data) -> if(compare(i,knoten.data) <0)
    // knoten.links = insert(knoten.links, i)
    private int compare(T o1, T o2){
        if(this.comp != null) {
            this.comp.compare(o1,o2);
        }
        else{
            Comparable<T> o11 = (Comparable<T>)  o1;
            return  o11.compareTo(o2);
        }
        return 0;
    }
    // In contains , return compare(wert, knoten.data)
}
