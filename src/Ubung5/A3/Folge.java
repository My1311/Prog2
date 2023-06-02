package Ubung5.A3;

import Ubung2.A2.Puffer;

public interface Folge<T> extends Puffer<T> {
    T get(int pos) throws IndexOutOfBoundsException;
    // uberschreibt das Element an Index ¨ pos und gibt den alten
    //Wert zuruck. ¨
    T set(int pos, T e) throws IndexOutOfBoundsException;
    // das Element soll am Index pos entfernt werden und alle darauf folgenden Elemente nachrutschen.
    void remove(int pos) throws IndexOutOfBoundsException;
    // e an der spezifizierten Position pos eingefugt.
    // as Element, das momentan an der Position steht und die folgenden ¨
    //(wenn vorhanden) werden nach rechts verschoben
    void insert(int pos, T e) throws IndexOutOfBoundsException;
}
