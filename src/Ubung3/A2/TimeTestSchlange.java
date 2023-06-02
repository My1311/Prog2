package Ubung3.A2;

import Ubung2.A2.SchlangeMitArray;


public class TimeTestSchlange {
    public static void main(String[] args) {
        final int MaxSize = 100000;
        final int Runden = 1;
        // 2 Objekte zum Vergleichen
        SchlangeMitEVL<Integer> schlangeL = new SchlangeMitEVL<>();
        SchlangeMitArray<Integer> schlangeA = new SchlangeMitArray<>(100000);
        // 3 Variable, um Zeitdauder zu rechnen
        long start,finish;
        // EVL
        start = System.currentTimeMillis();
        for (int i = 0; i < MaxSize ; i++) {
            schlangeL.insert(i);
        }

        while (!schlangeL.isEmpty()) {
            schlangeL.remove();
        }
        finish = System.currentTimeMillis();

        System.out.println("Mit EVL dauert: "+(finish-start)+" ms." ); // 16987ms

        // Array
        start = System.currentTimeMillis();
        for (int i = 0; i < MaxSize ; i++) {
            schlangeA.insert(i);
        }

        while (!schlangeL.isEmpty()) {
            schlangeA.remove();
        }
        finish = System.currentTimeMillis();

        System.out.println("Mit Array dauert: "+(finish-start)+" ms." ); // 16ms

    }
}
