package Ubung3.A2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitEVLTest {

    SchlangeMitEVL<String> schlange1;
    String [] buchstaben = {"A","B","C","D","E"};
    @BeforeEach
    void setUp() {
        schlange1 = new SchlangeMitEVL<>();
    }

    @Test
    void isEmpty() {
        assertTrue(schlange1.isEmpty());
        assertThrows(NoSuchElementException.class, () -> schlange1.remove());
        schlange1.insert("A");
        assertFalse(schlange1.isEmpty());
    }

    @Test
    void size() {
        int index = 0;
        for (String s : buchstaben) {
            assertEquals(index++, schlange1.size());
            schlange1.insert(s);
        }
    }

    @Test
    void capacity() {
        for (String s : buchstaben) {
            schlange1.insert(s);
        }
        assertEquals(Integer.MAX_VALUE,schlange1.capacity());
    }

    @Test
    void insertRemove() {
        for (String s : buchstaben) {
            schlange1.insert(s);
        }
        for (int i = 0; i < buchstaben.length; i++) {
            assertEquals(buchstaben[i], schlange1.remove());
    }
    }
    @Test
    void front() {
        for (String s : buchstaben) {
            schlange1.insert(s);
        }
        assertEquals("A",schlange1.front());
    }
}