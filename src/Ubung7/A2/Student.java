package Ubung7.A2;

public class Student extends Person implements Comparable<Student>{
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

    @Override
    public int compareTo(Student o) {
        return this.getMatrikelNr() - o.getMatrikelNr(); // kann zu gross sein
        // returm ((Integer) this.matrikelNr).compareTo(Integer)o.matriketNr;
        // returm Integer.compare(this.matrikelNr, o.martrikelNr); // beste Loesung
    }
}
