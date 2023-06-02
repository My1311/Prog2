package Ubung2.A2;

public interface Puffer<T> {
    // ob der Speicher leer ist
    boolean isEmpty() ;
    // die aktelle Groeße des Speichers zu liefern (= Anzahl belegter Speicherplaetze)
    int size();
    // die maximale Groeße des Speichers zu liefern
    int capacity();
    // ein Element anzunehmen und in den Speicher einzufugen
    // fugt ein Element am Ende der Folge an.
    void insert(T elm) throws java.lang.IllegalStateException;
    // ein Element aus dem Speicher zu entnehmen
    T remove() throws java.util.NoSuchElementException;
}

