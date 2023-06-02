package Ubung3.A5;

public class Josephus {
    // Klassenmethode (static), sodass wir mussen Josephus nicht instanziieren.
    public static int loese(int n, int k){
        RDVL<Integer>  ring = new RDVL<>();
        for (int i = 1; i <= n ; i++) {
            ring.add(i);
        }
        while (!(ring.size() == 1)) {
            ring.next(k-1);
            ring.remove();
        }
        return ring.element();
    }

    public static void main(String[] args){
        System.out.println(loese(5,2));
    }
    /*
    public int loese(int n, int k)
    public static void main(String[] args) {
        Josephus y = new Josephus();
                y.loese(7,4);
    }
    Das funktioniert( Bei Instanzmethode mussen wir in main neue Objekt von Klasse instanziieren.)
     */

}
