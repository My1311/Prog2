package Ubung1;

import Ubung0.A2.StapelMitArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StapelMitArrayTest {
    StapelMitArray stack;

    @BeforeEach
    public void setup() {
        stack = new StapelMitArray(4);
    }
    @Test
    public void TestIsEmpty() {
        assertEquals(true, stack.isEmpty());
        assertThrows(NoSuchElementException.class, () -> stack.remove());
        stack.insert(1);
        assertFalse(stack.isEmpty());

    }

    @Test
    public void TestSize() {
        assertEquals(0, stack.size());
        stack.insert(1);
        stack.insert(2);
        assertEquals(2, stack.size());
    }

    @Test
    public void TestCapicity() {
        assertEquals(4, stack.capacity());
    }

    @Test
    public void TestIsFull() {
        assertFalse(stack.isFull());
        stack.insert(1);
        stack.insert(2);
        stack.insert(3);
        stack.insert(4);
        assertTrue(stack.isFull());
        assertThrows(IllegalStateException.class, () -> stack.insert(5));
    }

    static int ai[] = {1, 2, 3, 4};

    @Test
    public void TestInsertRemove() {
        int index = 0;
        for (int i : ai) {
            assertEquals(index++, stack.size());
            stack.insert(i);
        }
        assertThrows(IllegalStateException.class, () -> stack.insert(5));
        for (int j = ai.length -1; j >= 0 ; j--) {
            assertEquals(ai[j],stack.remove());
        }
    }
    @Test
    public void TestTop() {
        for(int i : ai) {
            stack.insert(i);
        }
        assertEquals(4,stack.top());
    }
    @Test
    public void TestApplyToAll(){
        for(int i : ai) {
            stack.insert(i);
        }
        stack.applyToAll((i) -> (i*2));
        for (int j = ai.length-1; j >=0 ; j--) {
            assertEquals(ai[j] *2, stack.remove());

        }
    }



}