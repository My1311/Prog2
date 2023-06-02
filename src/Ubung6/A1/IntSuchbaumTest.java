package Ubung6.A1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {
    IntSuchbaum intSuchbaum;

    @BeforeEach
    void setUp() {
        intSuchbaum = new IntSuchbaum();
    }

    @Test
    void isEmpty() {
        assertTrue(intSuchbaum.isEmpty());
        intSuchbaum.insert(1);
        assertFalse(intSuchbaum.isEmpty());
    }

    @Test
    void insert() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        assertEquals( "(((1)2)3((4)5(7)))", intSuchbaum.toString());
    }

    @Test
    void contains() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        assertTrue(intSuchbaum.contains(5));
        assertFalse(intSuchbaum.contains(12));
    }

    @Test
    void hoehe() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        assertEquals(3, intSuchbaum.hoehe());
    }

    @Test
    void size() {
        intSuchbaum.insert(3);
        intSuchbaum.insert(2);
        intSuchbaum.insert(5);
        intSuchbaum.insert(4);
        intSuchbaum.insert(1);
        intSuchbaum.insert(7);
        assertEquals(6, intSuchbaum.size());
    }

}