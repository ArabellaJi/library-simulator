/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import junit.framework.TestCase;

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
public class BookTest extends TestCase {
    
    public BookTest(String testName) {
        super(testName);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    /**
     *
     */
    @Test
    public void testGetDescription(){
        System.out.println("getDescription");
        Book instance = new Book("QA", "Lisp", "Winston");
        String expResult = "Lisp";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCheckoutPeriod method, of class Book.
     */
    @Test
    public void testGetCheckoutPeriod() {
        System.out.println("getCheckoutPeriod");
        Book instance = new Book("QA", "Lisp", "Winston, Patrick");
        int expResult = 28;
        int result = instance.getCheckoutPeriod();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAllowedNumberOfRenewals method, of class Book.
     */
    @Test
    public void testGetAllowedNumberOfRenewals() {
        System.out.println("getAllowedNumberOfRenewals");
        Book instance = new Book("QA", "Lisp", "Winston, Patrick");
        int expResult = 1;
        int result = instance.getAllowedNumberOfRenewals();
        assertEquals(expResult, result);
    }
}
