package Ubung0.A3;

import java.util.Objects;

// die abstract Klasse wird hier verhindert, dass Person installisiert wird ( kein new Person).
public abstract class Person {
    private String name;
    private String vorname;
    public Person(String name, String vorname) {
        this.name= name;
        this.vorname = vorname;
    }
    public String getName() {
        return name;
    }
    public String getVorname() {
        return vorname;
    }
    public String toString() {
        return "<" + name +">, <" + vorname+">";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(vorname, person.vorname);
    }
    /*public boolean equals(Object o) {
        // Wir verwandeln 1 Objekt o in einem Person (type casting), muss ! beachtet sein
        if ( o == null) {
            return false;
        }
        Person p = (Person) o;
        return (p.name.equals(this.name)) &&(p.vorname.equals(this.vorname));*/
}
