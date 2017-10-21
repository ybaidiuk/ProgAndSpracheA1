package com.baidiuk.entitys;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PkwTest {
    private Pkw pkw;
    private Pkw pkw1;

    @Before
    public void setUp() throws Exception {
        pkw = new Pkw(1, "PkwTest", "modelTest", 1999, 1000, 2017);
        pkw1 = new Pkw(1, "PkwTest", "modelTest", 2016, 1000, 2016);
    }

    @Test
    public void getServicejahr() throws Exception {

    }

    @Test(expected = Exception.class)
    public void setServicejah1Exep() throws Exception {
        pkw.setServicejahr(1000);


    }

    @Test(expected = Exception.class)
    public void setServicejahr2Exep() throws Exception {
        pkw.setServicejahr(4000);

    }

    @Test
    public void getRabatt1() throws Exception {
        double price = pkw.getPreis();
        assertEquals("850.0", Double.toString(price));
    }

    @Test
    public void getRabatt2() throws Exception {
        double rabet = pkw1.getPreis();
        System.out.println(rabet);
        assertEquals("930.0", Double.toString(rabet));
    }


}