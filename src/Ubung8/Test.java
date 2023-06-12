package Ubung8;

import java.util.NoSuchElementException;

public class Test {
    public static void main(String[] args) {

        class Iterator{
            private  int [] zahlen;
            private int i;

            Iterator(int[] zahlen){
                this.zahlen = zahlen;
                this.i = 0;
            }
            public boolean hasNext(){
                return this.i < this.zahlen.length;
            };
            public int next(){
                if(!this.hasNext()){
                    throw new NoSuchElementException();
                }
                return zahlen[this.i ++];
            }
        }
        int[] zahlen = {1,2,3};
        Iterator it = new Iterator(zahlen);
        while (it.hasNext()){
            int zahl = it.next();
            System.out.println(zahl);
        }
    }
}
