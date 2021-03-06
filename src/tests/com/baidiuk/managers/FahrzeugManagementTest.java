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
        fm.delete(1);
        assertEquals(1, fm.getAll().size());
    }

    @Test
    public void size() throws Exception {
        assertEquals(2, fm.getAll().size());
    }

    @Test
    public void sizeOfPkw() throws Exception {
        assertEquals(1, fm.countPkw());
    }

    @Test
    public void sizeOfLkw() throws Exception {
        assertEquals(1, fm.countLkw());
    }

    @Test
    public void priceAvg() throws Exception {
        fm.show();
        System.out.println(fm.meanprice());
        assertEquals("125.12", fm.meanprice());
    }

    @Test
    public void getOldestFahrzeugId() throws Exception {
        assertEquals(new Integer(fahrzeug1.getId()), fm.oldest().get(0));
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