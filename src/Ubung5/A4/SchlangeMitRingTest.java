package Ubung5.A4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitRingTest {
    SchlangeMitRing<Integer> speicher;
    int []array = {1,2,3,4};

    @BeforeEach
    void setUp() {
        speicher = new SchlangeMitRing<>(5);
    }

    @Test
    void isEmpty() {
        assertThrows(NoSuchElementException.class, () -> speicher.remove());
    }

    @Test
    void size() {
        assertEquals(0, speicher.size());
        for(int i:array){
            speicher.insert(i);
        }
        assertEquals(4, speicher.size());
    }
    @Test
    void capacity() {
        assertEquals(5, speicher.capacity());
    }

    @Test
    void insertRemove() {
        for(int i:array){
            speicher.insert(i);
        }
        assertEquals(1,speicher.remove());
        assertEquals(2,speicher.remove());
        assertEquals(3,speicher.remove());
        assertEquals(4,speicher.remove());
    }


    @Test
    void front() {
        for(int i:array){
            speicher.insert(i);
        }
        assertEquals(1,speicher.front());
    }
}