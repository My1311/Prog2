package Ubung9;

import Ubung2.A2.Puffer;
import Ubung2.A2.Schlange;
import Ubung2.A2.SchlangeMitArray;
import Ubung3.A2.SchlangeMitEVL;

public abstract class GenericUtil {
    // Aufgabe 1
    public static<T> T gambling(T e1, T e2){
        return Math.random() > 0.5 ? e1 : e2;
    }
    // Aufgabe 2
    public static<U> Schlange<U> arrayToSchlange(U [] array){
        Schlange<U>  schlange = new SchlangeMitEVL<>();
        for (U arg :
                array) {
            schlange.insert(arg);
        }
        return schlange;
    }
    public static<P> Puffer<P> gambling(Puffer p1, Puffer p2){
        return Math.random() > 0.5 ? p1 : p2;
    }

    // Auf 3
    /*printAll(), die ein Referenzobjekt
    von einem iterierbaren Typ (Iterable) annimmt und alle Elemente zeilenweise auf dem
    Bildschirm ausgibt. */
    // Typ V sollte auch iterable sein => V extends Iterable und wir forEach hier benutzen konnen.
    public static<V extends Iterable> void  printALL(V [] args){
        for (V arr : args){
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {
        System.out.println(GenericUtil.gambling("long", 1.0));
    }
}
