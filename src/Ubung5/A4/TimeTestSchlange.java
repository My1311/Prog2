package Ubung5.A4;
import Ubung5.A3.FolgeMitDynArray;

import java.util.Scanner;
public class TimeTestSchlange {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Wiederholung der inneren Schleifen in Tausend: ");
        int wdh = s.nextInt() * 1000; //Wdh. der inneren Schleife
    FolgeMitDynArray<Integer> schnittDynArr = new FolgeMitDynArray<>();
    SchlangeMitRing<Integer> schnittRing = new SchlangeMitRing<>(wdh);
        System.out.print("Wiederholung des Tests: ");
    int testWdh = s.nextInt(); //Test Wdh.
        s.close();
    long zeitDynArr = 0;
    long zeitRing = 0;
        for (int i = 0; i < testWdh; i++) {
        zeitDynArr += testDynArr(schnittDynArr, wdh); // gesamte Zeit für geforderte Wdh. errechnen
        zeitRing += testRing(schnittRing, wdh);       // gesamte Zeit für geforderte Wdh. errechnen
        if(i % testWdh/10 == 0){
            System.out.print(".");
        }
    }
        System.out.printf("\nDurchschnitt SchlangemitDynArray: %s\n" +
                "Durchschnitt SchlangemitRing: %s", (double)zeitDynArr/testWdh, (double)zeitRing/testWdh); //gesamt Zeit durch Wdh. teilen um Duchschnitt zu erhalten.
}
    public static long testDynArr(FolgeMitDynArray<Integer> schlange, int wdh){
        long start = System.currentTimeMillis();
        for (int i = 0; i < wdh; i++) {
            schlange.insert(i);             //geforderte anzahl an elementen werden hinzugefühgt
        }
        for (int i = 0; i < wdh; i++) {
            schlange.remove();             //geforderte anzahl an elementen werden gelöscht
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public static long testRing(SchlangeMitRing<Integer> schlange, int wdh){
        long start = System.currentTimeMillis();
        for (int i = 0; i < wdh; i++) {
            schlange.insert(i);             //geforderte anzahl an elementen werden hinzugefühgt
        }
        for (int i = 0; i < wdh; i++) {
            schlange.remove();              //geforderte anzahl an elementen werden gelöscht
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

}
