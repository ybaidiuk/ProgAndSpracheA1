package com;

import com.baidiuk.daos.FahrzeugDAO;
import com.baidiuk.daos.SerializedFahrzeugDAO;
import com.baidiuk.entitys.Lkw;
import com.baidiuk.entitys.Pkw;
import com.baidiuk.managers.FahrzeugManagement;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class FahrzeugClientTest {

    @Test
    public void testPkwSerialisation() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();
        fm.add(new Pkw(1, "Audi", "A6", 2015, 995));
        fm.add(new Pkw(2, "Mercedes", "Fyra", 2011, 6666));
        FahrzeugDAO sfd = new SerializedFahrzeugDAO("Junit.ser");
        assertEquals(995.00, sfd.getFahrzeugbyId(1).getGrundpreis(), 0);
        assertEquals(6666.00, sfd.getFahrzeugbyId(2).getGrundpreis(), 0);
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testSerialisationInFolder() {
        FahrzeugManagement fm = new FahrzeugManagement("Folder1/f2/f3/file");
        fm.clear();
        fm.add(new Pkw(1, "Audi", "A6", 2015, 995));
        fm.add(new Pkw(2, "Mercedes", "Fyra", 2011, 6666));
        FahrzeugDAO sfd = new SerializedFahrzeugDAO("Folder1/f2/f3/file");
        assertEquals(995.00, sfd.getFahrzeugbyId(1).getGrundpreis(), 0);
        assertEquals(6666.00, sfd.getFahrzeugbyId(2).getGrundpreis(), 0);

        new File("Folder1/f2/f3/file").delete();
        new File("Folder1/f2/f3").delete();
        new File("Folder1/f2/").delete();
        new File("Folder1").delete();

    }

    @Test
    public void testDel() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();
        fm.add(new Pkw(1, "Mercedes", "Fyra", 2011, 10000));
        fm.delete(1);
        assertEquals(0, fm.getAll().size());
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testGetById() throws Exception { // get Fahrzeug mit  solche Id soll null zuruck lliefern!
        FahrzeugDAO fm = new SerializedFahrzeugDAO("Junit.ser");
        File file = new File("Junit.ser");
        file.delete();
        Lkw lkw = new Lkw(1, "Mercedes", "Fyra", 2011, 10000);
        fm.saveFahzeug(lkw);
        assertEquals(null, fm.getFahrzeugbyId(9998));


    }

    @Test
    public void testCount() {
        FahrzeugManagement fm2 = new FahrzeugManagement("Junit.ser");
        fm2.clear();

        fm2.add(new Pkw(1, "Mercedes", "Fyra", 2011, 10000));
        fm2.delete(1);
        fm2.add(new Pkw(1, "Mercedes", "Fyra", 2011, 10000));
        fm2.add(new Pkw(2, "Mercedes", "Fyra", 2011, 10000));
        fm2.add(new Pkw(5, "Mercedes", "Fyra", 2011, 10000));
        assertEquals(3, fm2.size());
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testCountLkw() {
        FahrzeugManagement fm2 = new FahrzeugManagement("Junit.ser");
        fm2.clear();

        fm2.add(new Pkw(1, "Mercedes", "Fyra", 2011, 10000));
        fm2.delete(1);
        fm2.add(new Pkw(99, "Mercedes", "Fyra", 2011, 10000)); // +1
        fm2.add(new Pkw(2, "Mercedes", "Fyra", 2011, 10000));  // +1
        fm2.add(new Pkw(5, "Mercedes", "Fyra", 2011, 10000)); // pkw
        assertEquals(2, fm2.size());
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testCountPkw() {
        FahrzeugManagement fm2 = new FahrzeugManagement("Junit.ser");
        fm2.clear();

        fm2.add(new Pkw(1, "Mercedes", "Fyra", 2011, 10000));
        fm2.delete(1);
        fm2.add(new Pkw(123, "Mercedes", "Fyra", 2011, 10000));
        fm2.add(new Pkw(2, "Mercedes", "Fyra", 2011, 10000));
        fm2.add(new Pkw(5, "Mercedes", "Fyra", 2011, 10000));
        assertEquals(2, fm2.size());
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testMeanAge() {
        FahrzeugManagement fm2 = new FahrzeugManagement("Junit.ser");
        fm2.clear();

        fm2.add(new Pkw(1, "Mercedes", "Fyra", 2011, 10000));
        fm2.delete(1);
        fm2.add(new Pkw(123, "Mercedes", "Fyra", 2001, 10));
        fm2.add(new Pkw(2, "Mercedes", "Fyra", 2006, 29));
        assertEquals(12.5, fm2.priceAvg(), 0);
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testMeanPrice() {
        FahrzeugManagement fm2 = new FahrzeugManagement("Junit.ser");
        fm2.clear();

        fm2.add(new Pkw(1, "Mercedes", "Fyra", 2011, 10000));
        fm2.delete(1);
        fm2.add(new Pkw(123, "Mercedes", "Fyra", 2001, 10));
        fm2.add(new Pkw(2, "Mercedes", "Fyra", 2006, 29));
        assertEquals((10 * 0.8 + 29 * 0.85) / 2, fm2.priceAvg(), 0);
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testMeanPricePkw() {
        FahrzeugManagement fm2 = new FahrzeugManagement("Junit.ser");
        fm2.clear();

        fm2.add(new Pkw(1, "Mercedes", "Fyra", 2011, 10000));
        fm2.delete(1);
        fm2.add(new Pkw(123, "Mercedes", "Fyra", 2001, 10));
        fm2.add(new Pkw(2, "Mercedes", "Fyra", 2006, 29)); //   24.65  15%
        fm2.add(new Pkw(3, "Mercedes", "Fyra", 2015, 249)); //7% 231.57
        assertEquals((249 * 0.93 + 29 * 0.85) / 2.0, fm2.priceAvg(), 0.1);
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testMeanPriceLkw() {
        FahrzeugManagement fm2 = new FahrzeugManagement("Junit.ser");
        fm2.clear();

        fm2.add(new Pkw(1, "Mercedes", "Fyra", 2011, 10000));
        fm2.delete(1);
        fm2.add(new Pkw(123, "Mercedes", "Fyra", 2001, 10));
        fm2.add(new Pkw(2, "Mercedes", "Fyra", 2014, 29));
        fm2.add(new Pkw(3, "Mercedes", "Fyra", 2014, 249));
        assertEquals((10 * 0.80 + 29 * 0.90) / 2.0, fm2.priceAvg(), 0);
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testOldest() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();

        fm.add(new Pkw(1, "Mercedes", "Fyra", 2001, 10000));
        fm.add(new Pkw(2, "Mercedes", "Fyra", 2000, 10000));
        fm.delete(1);
        fm.add(new Pkw(3, "Mercedes", "Fyra", 2000, 10));
        fm.add(new Pkw(4, "Mercedes", "Fyra", 2002, 29));
        fm.add(new Pkw(5, "Mercedes", "Fyra", 2004, 29));
        fm.add(new Pkw(6, "Mercedes", "Fyra", 2000, 249));
        //oldest 2 3 6
        List<Integer> expected = Arrays.asList(2, 3, 6);
        assertEquals(expected, fm.getOldestFahrzeugId());
        File file = new File("Junit.ser");
        file.delete();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetMarke() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();
        fm.add(new Pkw(6, "", "Fyra", 2015, 249));
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetModel() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();
        fm.add(new Pkw(6, "Ford", "", 2013, 249));
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetYear() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();
        fm.add(new Pkw(6, "Ford", "Fokus", 2018, 249));
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetGrundPrise() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();
        fm.add(new Pkw(6, "Ford", "Fokus", 2014, -249));
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testPkwPrise() {
        Pkw pkw = new Pkw(1, "Audi", "A6", 2014, 1000);
//        System.out.println("Rabatt: " + pkw.getRabatt());
//        System.out.println("Prise: " + pkw.getPreis());
        assertEquals(860, pkw.getPreis(), 0);
    }

    @Test
    public void testPkwPrise2() {
        Pkw pkw = new Pkw(1, "Audi", "A6", 2010, 1000);
//        System.out.println("Rabatt: " + pkw.getRabatt());
//        System.out.println("Prise: " + pkw.getPreis());
        assertEquals(850, pkw.getPreis(), 0);
    }

    @Test
    public void testLkwPrise() {
        Lkw lkw = new Lkw(1, "Mercedes", "Fyra", 2015, 10000);
//        System.out.println("Rabatt: " + lkw.getRabatt());
//        System.out.println("Prise: " + lkw.getPreis());
        assertEquals(9500, lkw.getGrundpreis(), 0);
    }

    @Test
    public void testLkwPrise2() {
        Lkw lkw = new Lkw(1, "Mercedes", "Fyra", 2011, 10000);
//        System.out.println("Rabatt: " + lkw.getRabatt());
//        System.out.println("Prise: " + lkw.getPreis());
        assertEquals(8000, lkw.getPreis(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetId() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();
        fm.add(new Pkw(6, "Ford", "Fokus", 2014, 249));
        fm.add(new Pkw(6, "Ford", "Fokus", 2014, 249));
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDataIsLessAsYear() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();
        fm.add(new Pkw(6, "Mercedes", "Fyra", 2015, 249));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetPkwDatum2() {
        FahrzeugManagement fm = new FahrzeugManagement("Junit.ser");
        fm.clear();
        fm.add(new Pkw(6, "Ford", "Fokus", 2014, 249));
        File file = new File("Junit.ser");
        file.delete();
    }

    @Test
    public void testDoubleFormatPriseLkw() {
        Lkw p1 = new Lkw(2, "Tesla Motors", "Model S", 2015, 1000);
        assertEquals(true, p1.toString().contains("950.00"));
    }

    @Test
    public void testDoubleFormatGrundPriseLkw() {
        Lkw p1 = new Lkw(2, "Tesla Motors", "Model S", 2015, 1000);
        assertEquals(true, p1.toString().contains("1000.00"));
    }

    @Test
    public void testDoubleFormatPrisePkw() {
        Pkw p1 = new Pkw(2, "Tesla Motors", "Model S", 2015, 1000);
        assertEquals(true, p1.toString().contains("950.00"));
    }

    @Test
    public void testDoubleFormatGrundPrisePkw() {
        Pkw p1 = new Pkw(2, "Tesla Motors", "Model S", 2015, 1000);
        assertEquals(true, p1.toString().contains("1000.00"));
    }

}
