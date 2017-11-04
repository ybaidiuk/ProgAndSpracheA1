package com.baidiuk.daos;

import com.baidiuk.entitys.Fahrzeug;
import com.baidiuk.entitys.Lkw;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class SerializedFahrzeugDAOTest {
    private static final String filePaht = "testSer";
    private Fahrzeug fahrzeug1;
    private Fahrzeug fahrzeug2;

    private FahrzeugDAO dao = new SerializedFahrzeugDAO(filePaht);


    @Before
    public void setUp() throws Exception {
        dao.clear();

        fahrzeug1 = new Lkw(1, "testSer", "testSerModel", 1992, 100);
        fahrzeug2 = new Lkw(2, "testSer2", "testSerModel2", 1992, 100);
        dao.save(fahrzeug1);
        dao.save(fahrzeug2);
    }


    @AfterClass
    public static void tearDownClass() {
        File file = new File(filePaht);
        file.delete();
    }

    @Test
    public void getFahrzeugList() throws Exception {
        assertEquals(2, dao.getList().size());
    }

    @Test
    public void getFahrzeugbyId() throws Exception {
        assertEquals(fahrzeug1, dao.get(fahrzeug1.getId()));
    }


    @Test
    public void saveFahzeug() throws Exception {
        dao.clear();
        dao.save(fahrzeug1);
        assertEquals(1, dao.get(fahrzeug1.getId()).getId());
    }

    @Test
    public void saveFahzeugNull() throws Exception {
        assertNull(dao.get(0));
    }

    @Test(expected = Exception.class)
    public void saveFahzeugExeption() throws Exception {
        dao.save(fahrzeug1);
    }


    @Test
    public void deleteFahrzeug() throws Exception {
        dao.remove(fahrzeug1.getId());
        dao.remove(fahrzeug2.getId());
        assertTrue(dao.getList().isEmpty());
    }

    @Test(expected = Exception.class)
    public void deleteFahrzeugExeption() throws Exception {
        dao.remove(0);
    }

}