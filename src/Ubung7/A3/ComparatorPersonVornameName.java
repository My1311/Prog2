package Ubung7.A3;

import Ubung0.A3.Person;

import java.util.Comparator;

// In Case wir durfen nicht Klasse Person verandern, aber mochten trotzdem Objekte vergleichen
public class ComparatorPersonVornameName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(!o1.getVorname().equals(o2.getVorname())){
            return o1.getVorname().compareTo(o2.getVorname());
        }
        if(!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        }
        return 0;
        // return vornameVergleich ....

    }
}
