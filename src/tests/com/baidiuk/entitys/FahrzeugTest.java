package com.baidiuk.entitys;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class FahrzeugTest {
    private Fahrzeug fahrzeug1;
    private Fahrzeug fahrzeug2;

    @Before
    public void setUp() throws Exception {
        fahrzeug1 = new Lkw(1, "testFar", "testFarModel", 1992, 100.888);
        fahrzeug2 = new Lkw(2, "testFar2", "testFarModel2", 2000, 100);
    }

    @Test
    public void setBaujahr() throws Exception {
        fahrzeug1.setBaujahr(2000);
        assertEquals(2000, fahrzeug1.getBaujahr());
    }

    @Test(expected = Exception.class)
    public void setBaujahrExep() throws Exception {
        fahrzeug1.setBaujahr(2020);
    }

    @Test
    public void getGrundpreis() throws Exception {
        System.out.println(fahrzeug1.toString());
        System.out.println(fahrzeug2.toString());
        assertTrue(fahrzeug1.toString().contains("Grundpreis:  100.89"));
        assertTrue(fahrzeug2.toString().contains("Grundpreis:  100.00"));
    }

    @Test(expected = Exception.class)
    public void setGrundpreis() throws Exception {
        fahrzeug1.setGrundpreis(0);
    }

    @Test(expected = Exception.class)
    public void setGrundpreis2() throws Exception {
        fahrzeug1.setGrundpreis(-2);
    }

    @Test
    public void getAlter() throws Exception {
        assertEquals(25, fahrzeug1.getAlter());
        assertEquals(17, fahrzeug2.getAlter());
    }

    @Test
    public void equals() throws Exception {
        assertFalse(fahrzeug1 == fahrzeug2);
    }
}