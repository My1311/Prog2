package Ubung0;

public interface Puffer {
    // ob der Speicher leer ist
    boolean isEmpty() ;
    // die aktelle Groeße des Speichers zu liefern (= Anzahl belegter Speicherplaetze)
     int size();
    // die maximale Groeße des Speichers zu liefern
     int capacity();
    // ein Element anzunehmen und in den Speicher einzufugen
     void insert(int elm);
    // ein Element aus dem Speicher zu entnehmen
    int remove();
}
