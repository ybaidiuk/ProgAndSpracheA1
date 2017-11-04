package com.baidiuk.entitys;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LkwTest {
    private Lkw lkw;
    private Lkw lkw1;

    @Before
    public void setUp() throws Exception {
        lkw = new Lkw("1", "LkwTest", "modelTest", "1999", "1000");
        lkw1 = new Lkw("1", "LkwTest", "modelTest", "2015", "1000");
    }

    @Test
    public void getRabatt() throws Exception {
        double rabat = lkw.getRabatt();
        assertEquals("200.0", Double.toString(rabat));
    }
    @Test
    public void getRabatt1() throws Exception {
        double rabat = lkw1.getRabatt();
        assertEquals("100.0", Double.toString(rabat));
    }



}