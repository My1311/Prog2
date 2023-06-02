package Ubung4.A2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {
    DynArray<Integer> dynArray;
    int [] array = {1,2,3,4,5,6};
    @BeforeEach
    public void setup(){
        dynArray = new DynArray<>();
    }

    @Test
    void size() {
        assertEquals(0,dynArray.size());
        assertThrows(NoSuchElementException.class, () -> dynArray.removeFirst());
        for(int i : array) {
            dynArray.addLast(i);
        }
        assertEquals(6,dynArray.size());
    }

    @Test
    void capacity() {
        for(int i : array) {
            dynArray.addLast(i);
        }
        assertEquals(8,dynArray.capacity());
    }

    @Test
    void get() {
        for(int i : array) {
            dynArray.addLast(i);
        }
        assertThrows(IndexOutOfBoundsException.class, ()->dynArray.get(-7));
        assertThrows(IndexOutOfBoundsException.class, ()->dynArray.get(9));
        for (int i = 0; i < dynArray.size() ; i++) {
            assertEquals(i+1,dynArray.get(i));
        }
    }
    @Test
    void set() {
        for(int i : array) {
            dynArray.addLast(i);
        }
        assertEquals(1, dynArray.set(0,56));
        assertEquals(56, dynArray.set(0,20));
    }

    @Test
    void addFirst() {
        for(int i : array) {
            dynArray.addLast(i);
        }
        dynArray.addFirst(25);
        assertEquals(25,dynArray.get(0));
        assertEquals(1,dynArray.get(1));
    }

    @Test
    void addLast() {
        for(int i : array) {
            dynArray.addLast(i);
        }
        dynArray.addLast(25);
        assertEquals(7,dynArray.size());
        int size = dynArray.size();
        assertEquals(25,dynArray.get(size-1));
    }

    @Test
    void removeFirst() {
        assertThrows(NoSuchElementException.class, () -> dynArray.removeFirst());
        for (int i : array) {
            dynArray.addLast(i);
        }
        for (int i = 0; i < array.length; i++) {
            assertEquals(i+1,dynArray.removeFirst());

        }
    }
    @Test
    void removeLast() {
        for (int i : array) {
            dynArray.addLast(i);
        }
        for (int i = 0; i < array.length; i++) {
            assertEquals(array.length-i,dynArray.removeLast());

        }
    }
}