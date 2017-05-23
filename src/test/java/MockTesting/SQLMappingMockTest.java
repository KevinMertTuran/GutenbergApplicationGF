package MockTesting;

import DTO.DTOAuthorBook;
import DataAccess.DBfacade;
import DomainLayer.Controller;
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

public class SQLMappingMockTest {

    public SQLMappingMockTest() {
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
    public void getAllBookTitleWithAuthorByCityNameTest() {
        System.out.println("getAllBookTitleWithAuthorByCityName");

        Collection<DTOAuthorBook> books = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            books.add(new DTOAuthorBook("title" + i + " author" + i));
        }

        DBfacade mockedFacade = mock(DBfacade.class);
        for (int i = 0; i < 10; i++) {
            when(mockedFacade.getAllBookTitleWithAuthorByCityName("London" + i)).thenReturn(books);

        }

        Controller c = new Controller(mockedFacade);

        //assertEquals(books.size(), c.getAllBookTitleWithAuthorByCityName("London").size());
        for (int i = 0; i < 10; i++) {

            assertEquals(books.iterator().next().toString(), c.getAllBookTitleWithAuthorByCityName("London" + i).iterator().next().toString());

        }
    }

}
