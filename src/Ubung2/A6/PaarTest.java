package Ubung2.A6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PaarTest {
     Paar<Integer, String> paar1, paar2,paar3;

     @BeforeEach
     public void setup() {
          paar1 = new Paar<>(1,"i");
          paar2 = new Paar<>(2,"aha");
          paar3 = new Paar<>(20,"hi hi");
     }

     @Test
     void getErstes() {

          assertEquals(1, paar1.getErstes());
     }

     @Test
     void getZweites() {
          assertEquals("aha", paar2.getZweites());
     }

     @Test
     void setErstes() {
          int x,y;
          x= paar1.setErstes(50);
          assertEquals(1,x);
          y = paar1.setErstes(30);
          assertEquals(50,y);
          System.out.println(paar1.setErstes(40)); // return 30, true
          System.out.println(paar1.getErstes());// return 40, true
     }

     @Test
     void setZweites() {
          String s;
          assertEquals("i", paar1.setZweites("aaa"));
     }

     @Test
     void setBeide() {
          paar3 = new Paar<>(20,"hi hi");
          assertEquals(20,paar3.getErstes());
          assertEquals("hi hi", paar3.getZweites());
     }

     @Test
     void testEquals() {
          paar2.setBeide(20,"hi hi");
          assertTrue(paar2.equals(paar3));
     }

     @Test
     void testToString() {
          String erwarted = "(2,aha)";
          assertEquals(erwarted,paar2.toString());
     }

}