package MockTesting;

import DataAccess.DBfacade;
import DomainLayer.Controller;
import DomainLayer.author;
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

public class AuthorMockTest {

    public AuthorMockTest() {
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
    public void testGetAuthor() {
        System.out.println("getAuthor");

        // mock dbfacade getAuthor
        DBfacade mockedFacade = mock(DBfacade.class);
        when(mockedFacade.getAuthor("1")).thenReturn(new author("1", "tester"));

        // create controller instance with mocked dbfacade injection
        Controller c = new Controller(mockedFacade);

        String expResult = "1" + "tester";
        String result = c.getAuthor("1").getUID() + c.getAuthor("1").getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGetAllAuthors() {
        System.out.println("getAllAuthors");

        Collection<author> listAllAuthors = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            listAllAuthors.add(new author(i + "", "tester" + i));
        }

        DBfacade mockedFacade = mock(DBfacade.class);
        when(mockedFacade.getAllAuthors()).thenReturn(listAllAuthors);

        Controller instance = new Controller(mockedFacade);

        assertEquals(listAllAuthors.size(), instance.getAllAuthors().size());

        for (int i = 0; i < instance.getAllAuthors().size(); i++) {
            assertEquals(listAllAuthors.iterator().next().toString(), instance.getAllAuthors().iterator().next().toString());

        }

    }
}
