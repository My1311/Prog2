package Ubung2.A2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SchlangeMitArrayTest {
    SchlangeMitArray<Double> schlange;
    SchlangeMitArray<String> schlange2;
    @BeforeEach
    public void setup(){

        schlange = new SchlangeMitArray<>(4);
        schlange2= new SchlangeMitArray<>(4);
    }
    @Test
    public void TestIsEmpty() {
        assertTrue(schlange.isEmpty());
        assertThrows(NoSuchElementException.class, () -> schlange.remove());
        schlange.insert(1.0);
        assertFalse(schlange.isEmpty());

        assertTrue(schlange2.isEmpty());
        assertThrows(NoSuchElementException.class, () -> schlange2.remove());

    }
    static double ai[] = {1.2, 2.4, 3.6, 4.8};
    static String test[] ={ "hallo", "ich", "bin","My"};
    @Test
    public void TestInsertRemove(){
        int index = 0;
        for (double i : ai) {
            assertEquals(index++, schlange.size());
            schlange.insert(i);
        }
        assertThrows(IllegalStateException.class, () -> schlange.insert(5.9));
        for (int j = 0; j < ai.length ; j++) {
            assertEquals(ai[j],schlange.remove());
        }

        for (String j : test) {
            schlange2.insert(j);
        }
        assertThrows(IllegalStateException.class, () ->schlange2.insert("hey"));
        for (int i = 0; i < test.length; i++) {
            assertEquals(test[i], schlange2.remove());

        }
    }
    @Test
    public void TestFront(){
        for(double i : ai) {
            schlange.insert(i);
        }
        assertEquals(1.2,schlange.front());
    }

    public static void main(String[] args) {
        SchlangeMitArray<String> schlange2= new SchlangeMitArray<>(4);
        schlange2.insert("Ein");
        schlange2.insert("Stock");
        System.out.println(schlange2);
    }

}
