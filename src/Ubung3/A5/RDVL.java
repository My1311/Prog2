package Ubung3.A5;


import java.util.NoSuchElementException;

// geschlossene doppelt verkettete Liste darstellen
// Ring
public class RDVL<T>{
    private int size = 0;
    Listenelement entry = null;
    class Listenelement {
        T data;
        Listenelement prev, next = null;

        Listenelement(T o) {
            data = o;
        }
    }
    // ob die Liste leer ist
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    // ein neues Listenelement, dass e beinhaltet vor entry eingefugt -> bedeutet, am Ende List.
    // entry wird im Anschluss nicht verschoben.
    public void add(T e) {
        Listenelement neuElement = new Listenelement(e);
        if (size == 0) {
             this.entry = neuElement;
             this.entry.prev = neuElement;
             this.entry.next = neuElement;
        } else {
            Listenelement vorEntry = this.entry.prev;
            this.entry.prev = neuElement;
            neuElement.next = this.entry;
            vorEntry.next = neuElement;
            neuElement.prev = vorEntry;
        }
        size++;
    }
    // Das aktuelle Listenelement wird gelöscht und der Inhalt daraus zurückgegeben.
    //Danach steht entry auf dem nächsten Element
    public T remove(){
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Listenelement aktuell = entry;
        aktuell.data = this.entry.data; // das gelöschte Listenelement
        // Das nächste Element von vorEntry ist das nächste Element von Entry
        this.entry.prev.next = this.entry.next;
        // und umgekehrt
        this.entry.next.prev = this.entry.prev;
        // Entry wird gelöscht
        this.entry = this.entry.next;
        size--;
        return aktuell.data;
    }
    // Der Inhalt des aktuellen Listenelements (entry) wird zurückgegeben.
    public T element(){
        if (size == 0 ){
            throw new NoSuchElementException();
        }
        return entry.data;
    }
    // Verschiebt das aktuelle Element (entry) um s Schritte nach vorne.
    public void next(int s){
        while(s != 0) {
            this.entry = this.entry.next;
            s--;
        }
    }
    // Verschiebt das aktuelle Element (entry) um s Schritte nach hinten.
    public void prev(int s){
        while(s != 0) {
            this.entry = this.entry.prev;
            s--;
        }
    }

}
