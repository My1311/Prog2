package Ubung7.A2;

public class Boxer extends Person implements Comparable<Boxer>{
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

    @Override
    public int compareTo(Boxer o) {
        if(this.getGewicht() != o.getGewicht()){
            return this.getGewicht() - o.getGewicht();
        }
        if(!this.getName().equals((o.getName()))){
            return this.getName().compareTo(o.getName());
        }
        return this.getVorname().compareTo(o.getVorname());
    }
    /*int gewichtVergleich = Integer.compare(this.gewicht, o.gewicht);
    int nameVergleich = this.name.compareTo(o.name);
    int vornameVergleich = this.vorname.compareTo(o.vorname);
    if(gewichtVergleich == 0) {
        if(nameVergleich == 0) {
            return vornameVergleich;
        }
        else{
            return nameVergleich;
        }
    } else{
        return gewichtVergleich;
    }*/
}
