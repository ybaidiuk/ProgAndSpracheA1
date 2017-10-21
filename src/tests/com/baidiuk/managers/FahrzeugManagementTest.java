package com.baidiuk.managers;

import com.baidiuk.entitys.Fahrzeug;
import com.baidiuk.entitys.Lkw;
import com.baidiuk.entitys.Pkw;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FahrzeugManagementTest {
    private static final String filePaht = "testManag";
    private Fahrzeug fahrzeug1;
    private Fahrzeug fahrzeug2;

    private FahrzeugManagement fm = new FahrzeugManagement(filePaht);


    @Before
    public void setUp() throws Exception {
        fm.clear();
        fahrzeug1 = new Lkw(1, "testManag", "testManagModel", 1992, 100.10);
        fahrzeug2 = new Pkw(2, "testManag2Lkw", "testManagModel2", 2000, 200.20, 2002);

        fm.add(fahrzeug1);
        fm.add(fahrzeug2);
    }


    @AfterClass
    public static void tearDownClass() {
        File file = new File(filePaht);
        file.delete();
    }

    @Test
    public void add() throws Exception {
        assertEquals(2, fm.getAll().size());
    }

    @Test
    public void delete() throws Exception {
        fm.delete(fahrzeug1);
        assertEquals(1, fm.getAll().size());
    }

    @Test
    public void size() throws Exception {
        assertEquals(2, fm.getAll().size());
    }

    @Test
    public void sizeOfPkw() throws Exception {
        assertEquals(1, fm.sizeOfPkw());
    }

    @Test
    public void sizeOfLkw() throws Exception {
        assertEquals(1, fm.sizeOfLkw());
    }

    @Test
    public void priceAvg() throws Exception {//todo Check aufgabe
        System.out.println(fm.priceAvg());
        assertEquals("150.15", fm.priceAvg());
    }

    @Test
    public void getOldestFahrzeugId() throws Exception {
        assertEquals(fahrzeug1.getId(), fm.getOldestFahrzeugId());
    }

    @Test
    public void clear() throws Exception {
        assertEquals(2, fm.getAll().size());
        fm.clear();
        assertEquals(0, fm.getAll().size());

    }

    @Test
    public void getAll() throws Exception {
        assertEquals(2, fm.getAll().size());
    }

}