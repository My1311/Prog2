package Projekt_Euler;

public class EulerProblem1 {
    public static void main(String[] args) {
        int summe = 0;
        int range = 10;
        for (int i = 0; i < range; i++) {
            if(i%3 == 0  || i % 5 == 0) {
                summe += i;
            }
        }
        System.out.println(+summe); // 23 , true
    }
}
