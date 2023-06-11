package Ubung6.A1;

import Ubung3.A1.EVL;

public class IntSuchbaum {
    private BaumEl wurzel;

    class BaumEl {
        int data;
        BaumEl links; // Weil Baum ist kein initialisierter Typ, musssen wir immer links oder rechts initialisiert werden.
        BaumEl rechts;

        BaumEl(int content) {
            data = content;
            links = null;
            rechts = null;
        }
    }

    public IntSuchbaum() {
        wurzel = null;
    }

    public boolean isEmpty() {
        return this.wurzel == null;// Instanz Kontext, IntSuchbaum.wurzel geht nicht
    }

    /* fugt einen Wert in den Baum ein. Sollte das Element bereits im Baum enthalten sein
        wird der Wert nicht eingefugt. */
    public void insert(Integer i) {
        if (isEmpty()) {
            this.wurzel = new BaumEl(i); // hier muss neuer Baum initialisiert werden (this.wurzel.data = i)
        }
        if (contains(i)) {
            return;
        }
        insert(wurzel, i);
    }

    private void insert(BaumEl node, Integer i) {
        if (node.data < i) {
            if (node.rechts == null) {
                node.rechts = new BaumEl(i);
            } else {
                insert(node.rechts, i);
            }
        } else {
            if (node.links == null) {
                node.links = new BaumEl(i);
            } else {
                insert(node.links, i);
            }
        }
    }

    public boolean contains(Integer i) {
        return contains(this.wurzel, i);
    }

    private boolean contains(BaumEl node, Integer i) {
        // when es keine Node, indem i enthaltet, gibt, zb: suche 8 in Baum Seite 8/15,
        // dann nach alle Noten gesucht werdem, node.rechts == null
        if (node == null) {
            return false;
        }
        if (node.data == i) {
            return true;
        }

        if (node.data < i) {
            if (node.rechts == null) {
                return false;
            }
            if (node.rechts.data == i) {
                return true;
            } else {
                contains(node.rechts, i);
            }
        } else {
            if (node.links == null) {
                return false;
            }
            if (node.links.data == i) {
                return true;
            } else {
                contains(node.links, i);
            }
        }
        return false;
        }

    public String toString(){
        if(isEmpty()){
            return "";
        }
        return toString(wurzel, "");

    }
    private String toString(BaumEl elm, String s) {
        if(elm == null) {
            return s;
        }
        s += (elm.links != null ? toString(elm.links, s) : "") + elm.data + (elm.rechts != null ? toString(elm.rechts, s) : "");
        return "(" + s + ")";
    }

    public int hoehe() {
        return hoehe(this.wurzel);
    }
    private int hoehe(BaumEl wurzel) {
        if (wurzel == null){
            return 0;
        }
        else {
            int l = hoehe(wurzel.links);
            int r = hoehe(wurzel.rechts);
           return Math.max(l,r) +1;
        }
    }
    public int size() {
        return size(this.wurzel);
    }
    private int size(BaumEl wurzel){
        if(wurzel == null) {
            return 0;
        }
        return size(wurzel.links) + 1 + size(wurzel.rechts);

    }

    public static void main(String[] args) {
        IntSuchbaum intSuchbaum = new IntSuchbaum();

        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        System.out.println(intSuchbaum.toString());
    }

    // A3




}
