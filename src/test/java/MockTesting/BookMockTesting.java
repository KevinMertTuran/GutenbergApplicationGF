/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MockTesting;

import DataAccess.DBfacade;
import DomainLayer.Controller;
import DomainLayer.book;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BookMockTesting {

    public BookMockTesting() {
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

    @Test
    public void testGetBook() {
        System.out.println("getBook");

        DBfacade mockedFacade = mock(DBfacade.class);
        when(mockedFacade.getBook("1")).thenReturn(new book("1", "The Book", "Big bad book"));

        Controller instance = new Controller(mockedFacade);
        book expResult = new book("1", "The Book", "Big bad book");
        book actualResult = instance.getBook("1");
        assertEquals(expResult.toString(), actualResult.toString());
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllBooks() {
        System.out.println("getAllBooks");

        Collection<book> listAllBooks = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            listAllBooks.add(new book(i + "", "tester" + i, "" + i));
        }

        DBfacade mockedFacade = mock(DBfacade.class);
        when(mockedFacade.getAllBooks()).thenReturn(listAllBooks);

        Controller instance = new Controller(mockedFacade);

        assertEquals(listAllBooks.size(), instance.getAllBooks().size());

        for (int i = 0; i < instance.getAllBooks().size(); i++) {
            assertEquals(listAllBooks.iterator().next().toString(), instance.getAllBooks().iterator().next().toString());

        }
    }
}
