package Ubung5.A3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FolgeMitRingTest {
        FolgeMitRing<Integer> intFolge;

    int [] array = {1,2,3,4,5,6};

    @BeforeEach
    void setUp() {
        intFolge = new FolgeMitRing<>(6);
    }
    @Test
    void removePos() {
        for(int i:array){
            intFolge.insert(i);
        }
        intFolge.remove(3); // remove 4
        assertEquals(1, intFolge.remove());
        assertEquals(2,intFolge.remove());
        assertEquals(3,intFolge.remove());
        assertEquals(5,intFolge.remove());
        assertEquals(6,intFolge.remove());
        assertTrue(intFolge.isEmpty());
    }

    @Test
    void insertPos() {
        intFolge.insert(0,0);
        intFolge.insert(1,1);
        intFolge.insert(2,2);
        intFolge.insert(3,3);

        assertEquals(0, intFolge.remove());
        assertEquals(1,intFolge.remove());
        assertEquals(2,intFolge.remove());
        assertEquals(3,intFolge.remove());
        assertTrue(intFolge.isEmpty());

    }
}