package Ubung0.A2;

public interface Puffer {
    // ob der Speicher leer ist
    boolean isEmpty() ;
    // die aktelle Groeße des Speichers zu liefern (= Anzahl belegter Speicherplaetze)
     int size();
    // die maximale Groeße des Speichers zu liefern
     int capacity();
    // ein Element anzunehmen und in den Speicher einzufugen
     void insert(int elm) throws java.lang.IllegalStateException;
    // ein Element aus dem Speicher zu entnehmen
    int remove() throws java.util.NoSuchElementException;
}
