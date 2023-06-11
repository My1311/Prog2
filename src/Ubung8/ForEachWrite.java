package Ubung8;

import Ubung0.A2.Puffer;

import java.util.Arrays;

public class ForEachWrite {
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        for(int element : arr) {
            element = 42;
        }
        System.out.println(Arrays.toString(arr)); // [1,2,3] , keine Veränderung
        /*for (int i = 0; i <arr.length ; i++) {
            arr[i] = 42;
            System.out.println(arr[i]); // 42,42,42
        }*/

    }
}
