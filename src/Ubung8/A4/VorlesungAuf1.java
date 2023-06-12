package Ubung8.A4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class VorlesungAuf1 {
    public static String maxString(Puffer <String> input) throws NoSuchElementException{
        if(input.isEmpty()){
            throw new NoSuchElementException();
        }

        Iterator<String> iter = input.iterator();
        String max = iter.next(); // String max = input.get(0);
        /*for (int i = 1; i < input.size() ; i++) {
            String element = input.get(i);
            if(max.compareTo(element) < 0){
                max = element;
            }
        }*/
        while (iter.hasNext()){
            String element = iter.next();
            if(max.compareTo(element) < 0){
                max = element;
            }
        }
        return max;
    }
    public static boolean allSmaller(Puffer<String> input, String s) throws NoSuchElementException{
        if (input.isEmpty()) {
            throw new NoSuchElementException();
        }
        for(String element: input){
            if (s.compareTo(element) < 0) {
                return false;
            }
        }

        /*Iterator<String> iter = input.iterator();

        while (iter.hasNext()) {
            String element = iter.next();
            if (s.compareTo(element) < 0) {
                return false;
            }
             }
                return true;
            }
        }*/

        return true;
    }

    public static boolean isSorted(Puffer<String> input) throws NoSuchElementException{
        if (input.isEmpty()) {
            throw new NoSuchElementException();
        }
        if(input.size() == 1) {
            return true;
        }

        Iterator<String> iter = input.iterator();
        String prev = iter.next();
        while (iter.hasNext()) {
            String current = iter.next();
            if (prev.compareTo(current) >= 0) {
                return false;
            }
            prev = current;// prev sollte gleicher Wert wie current und current wird nächsten Wert besitzen
        }
        return true;
    }

}
