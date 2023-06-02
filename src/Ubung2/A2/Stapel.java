package Ubung2.A2;

import Ubung2.A2.Puffer;

public interface Stapel<T> extends Puffer<T> {
    // die das aktuell oberste Element auf dem
    //Ubung0.Stapel liefert, ohne es zu entfernen
     T top();
}
