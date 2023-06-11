package Ubung8.A4;

public interface Schlange<T> extends Puffer<T> {
    // die das aktuell vorderste Element in Schlange liefert, ohne es zu entfernen
     T front();
}
