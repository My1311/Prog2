package Projekt_Euler;

import java.sql.SQLOutput;

public class Euler6 {
    public static void main(String[] args) {
        int summeQuadrate =0 ;
        int quadratSumme = 0;
        int range = 10;
        int kleinSum = 0;
        // Die Summe der Quadrate der ersten 10 naturlichen Zahlen
        for (int i = 0; i < range+1 ; i++) {
            summeQuadrate += Math.pow(i,2);
            kleinSum += i;
            quadratSumme = (int) Math.pow(kleinSum,2);
        }
        System.out.println("Die Differenz aus der Summe der Quadrate und dem Quadrat der Summe ist: " + (quadratSumme - summeQuadrate) );
    }
}
