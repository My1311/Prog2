package Projekt_Euler;

import java.math.BigInteger;
import java.util.ArrayList;

public class Euler25 {
    public static void main(String[] args) {
        ArrayList<BigInteger> fibonacciNummers = new ArrayList<BigInteger>();
        int n = 2; // Anfangsindex von Fibonacci Nummers
        BigInteger nextNummer = null;
        // limit ist die ersten Glieds der Fibonacci, die 1000 Stellen hat
        BigInteger limit = new BigInteger("10").pow(2);

        fibonacciNummers.add(BigInteger.ONE);
        fibonacciNummers.add(BigInteger.ONE);
        do {
            nextNummer = fibonacciNummers.get(n-1).add(fibonacciNummers.get(n-2));
            fibonacciNummers.add(nextNummer);
            n++;
        } while (nextNummer.compareTo(limit) <=0);
        System.out.println("der Index des ersten Glieds\n" +
                "der Fibonacci-Folge, das 1000 Stellen hat, ist " + fibonacciNummers.size());
    }

}
