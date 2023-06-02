package Ubung0.A3;

public class Student extends  Person{
    private int matrikelNr;
    public Student(String name, String vorname, int mNr) {
        super(name, vorname);
        this.matrikelNr = mNr;
    }
    public int getMatrikelNr(){
        return matrikelNr;
    }

    @Override
    public String toString() {
        return super.toString() + " " + matrikelNr;
    }

    @Override
    public boolean equals(Object obj) {
        Student s = (Student) obj;
        return super.equals(s) && s.matrikelNr == this.matrikelNr;
    }
}
