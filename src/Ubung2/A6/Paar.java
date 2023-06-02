package Ubung2.A6;

public class Paar<E,Z> {
    E erstes;
    Z zweites;

    public Paar() {
        this.erstes = null;
        this.zweites = null;
    }
    public Paar(E erstes, Z zweites) {
        this.erstes = erstes;
        this.zweites = zweites;
    }

    public E getErstes() {
        return erstes;
    }
    public Z getZweites(){
        return zweites;
    }
    // setzen die jeweilige Komponente auf den ubergebenen Wert. Sie geben den vor- ¨
    //herigen Wert der jeweiligen Komponente zuruck, den sie vor dem ¨ Uberschreiben ¨
    //hatte.
    public E setErstes(E e) {
        E tmp = erstes;
        this.erstes = e;
        return tmp;
    }
    public Z setZweites(Z z){
        Z tmp = zweites;
        this.zweites = z;
        return tmp;
    }
    // setzen die beiden Komponenten jeweils auf den ubergebenen Wert. Geben Sie ¨
    //keinen Wert zuruck.
    public void setBeide(E e, Z z){
        this.erstes = e;
        this.zweites = z;
    }
    public boolean equals(Paar<E,Z> p) {
        return (p.getErstes().equals(this.erstes) && p.getZweites().equals(this.zweites));
    }
    public String toString() {
        return "(" + erstes.toString() +","+ zweites.toString() +")";
    }
}
