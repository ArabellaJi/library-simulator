/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team 8
 */
public class DVDTest {
    
    public DVDTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getDescription method, of class DVD.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        DVD instance = new DVD("PN", "Shrek", "Myers", "PG");
        String expResult = "Shrek (DVD)";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
    /**
     * Test of getCheckoutPeriod method, of class DVD.
     */
    @Test
    public void testGetCheckoutPeriod() {
        System.out.println("getCheckoutPeriod");
        DVD instance = new DVD("PN", "Shrek", "Myers, Mike", "PG");
        int expResult = 7;
        int result = instance.getCheckoutPeriod();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllowedNumberOfRenewals method, of class DVD.
     */
    @Test
    public void testGetAllowedNumberOfRenewals() {
        System.out.println("getAllowedNumberOfRenewals");
        DVD instance = new DVD("PN", "Shrek", "Myers, Mike", "PG");
        int expResult = 0;
        int result = instance.getAllowedNumberOfRenewals();
        assertEquals(expResult, result);
    }
}
