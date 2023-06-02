package Ubung1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import Ubung0.A2.SchlangeMitArray;


class SchlangeMitArrayTest {
    SchlangeMitArray schlange;
    @BeforeEach
    public void setup(){
        schlange = new SchlangeMitArray(4);
    }
    @Test
    public void TestIsEmpty() {
        assertTrue(schlange.isEmpty());
        assertThrows(NoSuchElementException.class, () -> schlange.remove());
        schlange.insert(1);
        assertFalse(schlange.isEmpty());
    }
    static int ai[] = {1, 2, 3, 4};
    @Test
    public void TestInsertRemove(){
        int index = 0;
        for (int i : ai) {
            assertEquals(index++, schlange.size());
            schlange.insert(i);
        }
        assertThrows(IllegalStateException.class, () -> schlange.insert(5));
        for (int j = 0; j < ai.length ; j++) {
            assertEquals(ai[j],schlange.remove());
        }
    }
    @Test
    public void TestFront(){
        for(int i : ai) {
            schlange.insert(i);
        }
        assertEquals(1,schlange.front());
    }

}