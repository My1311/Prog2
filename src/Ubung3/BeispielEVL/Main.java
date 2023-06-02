package Ubung3.BeispielEVL;

public class Main {
    public static void main(String[] args) {
        EVL<String> liste = new EVL<>();
        String[] cities= {"Aachen","Bonn","Chemintz", "Dortmund","Essen"};

        for(String s:cities) {
            liste.appendLast(s);
            System.out.println(liste);
        }
    }
}
