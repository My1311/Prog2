package Ubung8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SnakeIterable2DArray2<T> implements Iterable<T> {
    private T[][] m; // matrix m
    private int i,j = 0;
    public  SnakeIterable2DArray2(T[][] m){
        this.m = m;
        this.i = 0;
        this.j = 0;
    }

    class InnererIterator implements Iterator<T> {
        private T[][] m; // matrix m
        private int i,j = 0;
        public  InnererIterator(T[][] m){
            this.m = m;
            this.i = 0;
            this.j = 0;
        }
        @Override
        public boolean hasNext() {
            return i < m.length && j < m[i].length;
        }
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T value = m[i][j];
            // increment i j
            if(i % 2 == 0){ // gerade
                if(j +1 < m[i].length){ // nicht am Ende
                    j++;
                }
                else { // am Ende
                    j = m[i].length - 1; // am Ende, hier j = 3
                    i++;
                }
            }
            else {// ungerade
                if(j > 0) { // nicht am Ende
                    j--;
                }
                else{
                    i++; // am Ende
                }
            }
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new InnererIterator(m);
    }
    public static void main(String[] args) {

        SnakeIterable2DArray2<Integer> sa = new SnakeIterable2DArray2<>(new Integer[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        });
        for(Integer i : sa) {
            System.out.println(i);
        }
    }
}
