package com.baidiuk.entitys;

import org.junit.Test;

import static org.junit.Assert.*;

public class FahrzeugTest {
    private Fahrzeug fahrzeug1 = new Lkw(1, "testFar", "testFarModel", 1992, 100.888);
    private Fahrzeug fahrzeug2 = new Lkw(2, "testFar2", "testFarModel2", 2000, 100);


    @Test
    public void setBaujahr() throws Exception {
        fahrzeug1.setBaujahr(2000);
        assertEquals(2000, fahrzeug1.getBaujahr());
    }

    @Test
    public void setBaujahrExep() throws Exception {
        fahrzeug1.setBaujahr(2020);//todo gavnoCod
    }

    @Test
    public void getGrundpreis() throws Exception {
        assertTrue(fahrzeug1.toString().contains("grundpreis=100.89"));
        assertTrue(fahrzeug2.toString().contains("grundpreis=100.00"));
    }

    @Test
    public void setGrundpreis() throws Exception {
        fahrzeug1.setGrundpreis(0);//todo gavnoCod
    }
    @Test
    public void setGrundpreis2() throws Exception {
        fahrzeug1.setGrundpreis(-2);//todo gavnoCod
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