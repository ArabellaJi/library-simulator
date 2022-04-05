/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library.model;

import java.util.Iterator;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Team 8
 */
public class PatronTest extends TestCase {
    
    public PatronTest(String testName) {
        super(testName);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of getFullName method, of class Patron.
     */
    public void testGetFullName() {
        System.out.println("getFullName");
        Patron aardvark = new Patron("Anthony", "Aardvark", "Winn Subbasement", "1");
        String expResult = "Anthony Aardvark";
        String result = aardvark.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class Patron.
     */
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Patron aardvark = new Patron("Anthony", "Aardvark", "Winn Subbasement", "1");
        String expResult = "1";
        String result = aardvark.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkOut method, of class Patron.
     */
    public void testCheckOut() {
        System.out.println("checkOut() will be checked with getetCopiesCheckedOut().");
    }

    /**
     * Test of returnCopy method, of class Patron.
     */
    public void testReturnCopy() {
        System.out.println("returnCopy() will be checked with getetCopiesCheckedOut().");
    }
    
    /**
     * Test of getCurrentCopiesOut method, of class Patron.
     */
    public void testGetCurrentCopiesOut() {
        System.out.println("getCurrentCopiesOut");
        Patron aardvark = new Patron("Anthony", "Aardvark", "Winn Subbasement", "1");
        Copy copy = new Book("QA", "LISP", "Winston").makeCopy();
        aardvark.checkOut(copy);
        int expResult = 1;
        int result = aardvark.getCurrentCopiesOut();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOverdue method, of class Patron.
     */
    @Test
    public void testGetNumberOverdue() {
        System.out.println("getNumberOverdue");
        Patron instance = new Patron("Anthony", "Aardvark", "Winn Subbasement", "1");
        Copy copy = new Book("QA", "LISP", "Winston").makeCopy();
        instance.checkOut(copy);
        SimpleDate date = SimpleDate.getToday();
        copy.checkOutTo(instance, date);
        SimpleDate.changeTodayBy(28);
        int expResult = 0;
        int result = instance.getNumberOverdue(); // ?
        assertEquals(expResult, result);
    }

   /**
     * Test of getCopiesCheckedOut method, of class Patron.
     */
    public void testGetCopiesCheckedOut() {
        System.out.println("getCopiesCheckedOut");
        Book book = new Book("QA", "LISP", "Winston");
        Patron instance = new Patron("Anthony", "Aardvark", "Winn Subbasement", "1");
        Copy copy1 = book.makeCopy();
        Copy copy2 = book.makeCopy();
        Copy copy3 = book.makeCopy();
        instance.checkOut(copy1);
        instance.checkOut(copy2);
        instance.checkOut(copy3);
        instance.returnCopy(copy1);
        Iterator<Copy> result1 = instance.getCopiesCheckedOut();
        Copy firstCopy = result1.next();
        Copy secondCopy = result1.next();
        if (firstCopy == copy2) {
            assertEquals(copy2, firstCopy);
            assertEquals(copy3, secondCopy);
       	} else {
            assertEquals(copy3, firstCopy);
            assertEquals(copy2, secondCopy);
       	}
    }

}