package Ubung3.A1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class EVLTest {
    EVL<String> stringKette;
    EVL<Integer> integerKette;
    String[] cities= {"Aachen","Bonn","Chemintz", "Dortmund", "Essen"};
    int [] array = {1,2,3,4,5};

    @BeforeEach
    void setup(){
        stringKette = new EVL<>();

        integerKette = new EVL<>();
    }
    @Test
    void getFirst() {
        assertThrows(NoSuchElementException.class, () -> stringKette.getFirst());
        stringKette.addLast(cities[0]);
        stringKette.addLast(cities[1]);
        assertEquals(cities[0], stringKette.getFirst());

        assertThrows(NoSuchElementException.class, () -> integerKette.getFirst());
        integerKette.addLast(array[1]);
        assertEquals(array[1], integerKette.getFirst());
    }

    @Test
    void getLast() {
        assertThrows(NoSuchElementException.class, () -> stringKette.getLast());
        stringKette.addLast(cities[0]);
        stringKette.addLast(cities[1]);
        stringKette.addLast(cities[2]);
        assertEquals(cities[2], stringKette.getLast());
    }

    @Test
    void addFirst() {
        stringKette.addLast(cities[0]);
        stringKette.addLast(cities[1]);
        stringKette.addLast(cities[2]);
        stringKette.addFirst(cities[3]);
        assertEquals(cities[3], stringKette.getFirst());
    }

    @Test
    void addLast() {
        // String[] cities= {"Aachen","Bonn","Chemintz", "Dortmund", "Essen"};
        for (int i = 0; i < cities.length; i++) {
            stringKette.addLast(cities[i]);
            assertEquals(cities[i], stringKette.getLast());
        }
    }

    @Test
    void removeFirst() {
        assertThrows(NoSuchElementException.class, () -> stringKette.removeFirst() );
        stringKette.addLast(cities[0]);
        stringKette.addLast(cities[1]);
        stringKette.addLast(cities[2]);
        assertEquals(cities[0], stringKette.removeFirst());

    }

    @Test
    void removeLast() {
        assertThrows(NoSuchElementException.class, () -> stringKette.removeLast() );
        stringKette.addLast(cities[0]);
        stringKette.addLast(cities[1]);
        stringKette.addLast(cities[2]);
        assertEquals(cities[2], stringKette.removeLast());
    }

    @Test
    void contains() {
        for(String s: cities){
            stringKette.addLast(s);
        }
        assertTrue(stringKette.contains("Bonn"));
        assertFalse(stringKette.contains("ha ha"));
    }

    @Test
    void size() {
        for(String s: cities){
            stringKette.addLast(s);
        }
        assertEquals(5,stringKette.size());
    }

    @Test
    void testToString() {
        for(String s: cities){
            stringKette.addLast(s);
        }
        assertEquals("Aachen-Bonn-Chemintz-Dortmund-Essen", stringKette.toString());
    }
}