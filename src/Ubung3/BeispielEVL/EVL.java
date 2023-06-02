package Ubung3.BeispielEVL;

public class EVL<T> {
    Listenelement first = null; // Zeiger auf das erste Element
    int size = 0;       // Anzahl der Listenelemente

    class Listenelement{
        T data;
        Listenelement next = null;
        Listenelement(T o){
            data = o;
        }
    }
    public void appendLast(T o) {
        Listenelement l = new Listenelement(o);
        if(size == 0) {
            first = l;
        }
        else {
            Listenelement tmp = first;
            while (null != tmp.next) {
                tmp = tmp.next;
                System.out.println(tmp.data);
            }
                tmp.next = l;
        }
        size++;
    }
    public String toString() {
        String s = "{";
        Listenelement tmp = first;
        while (null != tmp) {
            if(tmp != first)
                s = s + ",";
            s = s + tmp.data;
            tmp = tmp.next;
        }
        s = s + "}";
        return s;
    }
}
