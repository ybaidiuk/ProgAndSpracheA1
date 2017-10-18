package com.baidiuk.daos;

import com.baidiuk.entitys.Fahrzeug;
import com.baidiuk.entitys.Lkw;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class SerializedFahrzeugDAOTest {
    private static final String filePaht = "testSer";
    private Fahrzeug fahrzeug1 = new Lkw(1, "testSer", "testSerModel", 1992, 100);
    private Fahrzeug fahrzeug2 = new Lkw(2, "testSer2", "testSerModel2", 1992, 100);

    private FahrzeugDAO dao = new SerializedFahrzeugDAO(filePaht);


    @Before
    public void setUp() throws Exception {
        dao.clear();
        dao.saveFahzeug(fahrzeug1);
        dao.saveFahzeug(fahrzeug2);
    }


    @AfterClass
    public static void tearDownClass() {
        File file = new File(filePaht);
        file.delete();
    }

    @Test
    public void getFahrzeugList() throws Exception {
        assertEquals(2, dao.getFahrzeugList().size());
    }

    @Test
    public void getFahrzeugbyId() throws Exception {
        assertEquals(fahrzeug1, dao.getFahrzeugbyId(fahrzeug1.getId()));
    }


    @Test
    public void saveFahzeug() throws Exception {
        dao.clear();
        dao.saveFahzeug(fahrzeug1);
        assertEquals(1, dao.getFahrzeugbyId(fahrzeug1.getId()).getId());
    }

    @Test
    public void saveFahzeugNull() throws Exception {
        assertNull(dao.getFahrzeugbyId(0));
    }

    @Test(expected = Exception.class)
    public void saveFahzeugExeption() throws Exception {
        dao.saveFahzeug(fahrzeug1);
    }


    @Test
    public void deleteFahrzeug() throws Exception {
        dao.deleteFahrzeug(fahrzeug1.getId());
        dao.deleteFahrzeug(fahrzeug2.getId());
        assertTrue(dao.getFahrzeugList().isEmpty());
    }

    @Test(expected = Exception.class)
    public void deleteFahrzeugExeption() throws Exception {
        dao.deleteFahrzeug(0);
    }

}