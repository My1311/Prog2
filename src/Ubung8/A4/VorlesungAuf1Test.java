package Ubung8.A4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VorlesungAuf1Test {

    @Test
    void maxString() {
        Puffer<String> folge = new FolgeMitDynArray<>();
        folge.insert("");
        folge.insert("ABA");
        folge.insert("ABC");
        folge.insert("AB");

        assertEquals("ABC", VorlesungAuf1.maxString(folge));
    }
    @Test
    void isSorted(){
        Puffer<String> folge = new FolgeMitDynArray<>();
        folge.insert("");
        folge.insert("AAA");
        folge.insert("BBB");
        folge.insert("CCC");
        assertTrue(VorlesungAuf1.isSorted(folge));
    }
}