package Ubung3.A5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RDVLTest {
     RDVL<Integer> ring1;
     int [] array = {1,2,3,4,5,6,7,8};
    @BeforeEach
    void setUp() {
        ring1 = new RDVL<>();
    }

    @Test
    void isEmpty() {
        assertTrue(ring1.isEmpty());
        ring1.add(9);
        assertFalse(ring1.isEmpty());
    }

    @Test
    void size() {
        for(int i : array){
            ring1.add(i);
        }
        assertEquals(8,ring1.size());
    }
    @Test
    void add() {
        assertEquals(0, ring1.size());
        ring1.add(array[0]);
        ring1.add(array[1]);
        ring1.add(array[2]);
        assertEquals(3, ring1.size());
        assertEquals(array[0], ring1.entry.data); // array[0] ist immer die Entry wenn es nicht verandert.
        assertEquals(array[2],ring1.entry.prev.data);
        assertEquals(array[1],ring1.entry.prev.prev.data);
    }

    @Test
    void remove() {
        assertThrows(NoSuchElementException.class, () -> ring1.remove());
        for(int i : array){
            ring1.add(i);
        }
        // Wir bekomme ring1 als array[1], [2], [3],... [8], [0].
        for (int i = 0; i < ring1.size() ; i++) {
            assertEquals(i+1,ring1.remove());
        }
    }

    @Test
    void element() {
        for(int i : array){
            ring1.add(i);
        }
        assertEquals(array[0],ring1.element());
    }

    @Test
    void next() {
        for(int i : array){
            ring1.add(i);
        }
        ring1.next(3);
        assertEquals(array[3], ring1.element()); //4
    }

    @Test
    void prev() {
        for(int i : array){
            ring1.add(i);
        }
        ring1.prev(3);
        assertEquals(array[5],ring1.element()); // 6
    }
}