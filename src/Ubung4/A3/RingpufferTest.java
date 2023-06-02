package Ubung4.A3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RingpufferTest {
    Ringpuffer<Integer> ring1;
    int [] array = {1,2,3,4,5,6,7,8};

    @BeforeEach
    void setUp() {
        ring1 = new Ringpuffer<>(8);
    }
    @Test
    void size() {
        assertEquals(0,ring1.size());
        assertThrows(NoSuchElementException.class, () ->ring1.removeFirst());
        ring1.addLast(1);
        assertEquals(1,ring1.size());
    }

    @Test
    void capacity() {
        for(int i:array){
            ring1.addLast(i);
        }
        assertEquals(8,ring1.capacity());
    }

    @Test
    void get() {
        for(int i:array){
            ring1.addLast(i);
        }
        assertEquals(2,ring1.get(1));
        assertEquals(8,ring1.get(7));
        assertThrows(IndexOutOfBoundsException.class, () -> ring1.get(8));
    }

    @Test
    void set() {
        for(int i:array){
            ring1.addLast(i);
        }
        // Test Index = 0
        ring1.set(0,11);
        assertEquals(11,ring1.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> ring1.set(8, 18));
    }

    @Test
    void addFirst() {
        ring1.addLast(6);
        ring1.addLast(3);
        ring1.addLast(5);
        ring1.addLast(8);
        ring1.addFirst(1);
        assertEquals(1,ring1.get(7));
        ring1.addFirst(2);
        assertEquals(2,ring1.get(6));
    }

    @Test
    void addLast() {
        ring1.addLast(6);
        ring1.addLast(3);
        ring1.addLast(5);
        ring1.addLast(8);
        assertEquals(8,ring1.removeLast());
        assertEquals(5,ring1.removeLast());
        assertEquals(3,ring1.removeLast());
        assertEquals(6,ring1.removeLast());
    }

    @Test
    void removeFirst() {
        for(int i:array){
            ring1.addLast(i);
        }
        for (int i = 0; i < ring1.size() ; i++) {
            assertEquals(array[i],ring1.removeFirst());
        }
    }

    @Test
    void removeLast() { // done
    }
}