package Ubung0.A3;

public class Boxer extends Person{
    private int gewicht;
    public Boxer(String name, String vorname, int gewicht) {
        super(name, vorname);
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Gewicht:" + gewicht;
    }

    @Override
    public boolean equals(Object obj) {
        Boxer b = (Boxer) obj;
        return super.equals(b) && b.gewicht == this.gewicht;
    }
}
