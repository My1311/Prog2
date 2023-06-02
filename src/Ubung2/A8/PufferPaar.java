package Ubung2.A8;


import Ubung0.A3.Boxer;
import Ubung0.A3.Student;
import Ubung2.A2.Puffer;
import Ubung2.A2.SchlangeMitArray;
import Ubung2.A2.StapelMitArray;
import Ubung2.A6.Paar;

public class PufferPaar<S,E> {
    public static void main(String[] args) {
        // Puffer kann nur 1 Typ T speicher, hier ist Paar. Und Paar speicher 2 Typen.
        Puffer <Paar<Student, String>> servicePoint;
        Puffer <Paar<Boxer, Boxer>> boxEvent;

        servicePoint = new SchlangeMitArray<>(4);

        boxEvent = new StapelMitArray<>(3);

        Student s1 = new Student("Keppeler","Tom", 901234);
        Student s2 = new Student("a", "bc", 12345);
        Student s3 = new Student("Schwarz","Laura", 12346);
        Student s4 = new Student("Heitzer","Patrick", 23456);

        servicePoint.insert(new Paar<>(s1,"Frage an System"));
        servicePoint.insert(new Paar<>(s2,"hallo"));
        servicePoint.insert(new Paar<>(s3,"Frage uber horde"));
        servicePoint.insert(new Paar<>(s4," Job bewerben"));

        Boxer b1 = new Boxer("Muhammad", "Ali", 89);
        Boxer b2 = new Boxer("Moore", "Archie", 90);
        Boxer b3 = new Boxer("Monzon", "Carlos", 70);
        Boxer b4 = new Boxer("Hopkins", "Bernard", 89);
        Boxer b5 = new Boxer("Robinson", "Ray", 100);
        Boxer b6 = new Boxer("Hammer", "Christian", 80);

        boxEvent.insert(new Paar<>(b1,b2));
        boxEvent.insert(new Paar<>(b3,b4));
        boxEvent.insert(new Paar<>(b5,b6));

        // while(! servicePoint.isEmpty) {};
        for (int i = 0; i < servicePoint.capacity() ; i++) {
            System.out.println(servicePoint.remove());
        }

        System.out.println();
        for (int i = 0; i < boxEvent.capacity(); i++) {
            System.out.println(boxEvent.remove());

        }
        }

}
