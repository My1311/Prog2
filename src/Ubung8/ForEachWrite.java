package Ubung8;

import Ubung8.A4.Puffer;
import Ubung0.A2.SchlangeMitArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForEachWrite {

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        for(int element : arr) { // nur lokale Variable
            element = 42;
        }
        System.out.println(Arrays.toString(arr));

        // [1,2,3] , keine Veränderung
        /*for (int i = 0; i <arr.length ; i++) {
            arr[i] = 42;
            System.out.println(arr[i]); // 42,42,42
        }*/
        // , wenn wir statt eines int[] ein Puffer<Integer> in der erweiterten for-Schleife
        //verwenden wurden
         ArrayList<Integer> arr1 = new ArrayList<>(3);
         arr1.add(1);
         arr1.add(2);
         arr1.add(3);
        for(int element : arr){
            System.out.println(element);
        }

        Iterator it = arr1.iterator();
        while (it.hasNext()){
            System.out.println(it.next()); // 1 2 3
         }
        // Die Werte werden nicht verändert, weil Iterator kann nur Werte lesen und zurückgeben, es gibt keine set Method hier
    }
}
