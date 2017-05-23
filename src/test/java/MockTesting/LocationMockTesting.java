package MockTesting;

import DataAccess.DBfacade;
import DomainLayer.Controller;
import DomainLayer.location;
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

public class LocationMockTesting {

    public LocationMockTesting() {
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
    public void testGetLocation() {
        System.out.println("getLocation");

        DBfacade mockedFacade = mock(DBfacade.class);
        when(mockedFacade.getLocation("1")).thenReturn(new location("1", "00", "99", "Cph"));

        Controller instance = new Controller(mockedFacade);

        location expResult = new location("1", "00", "99", "Cph");
        location actualResult = instance.getLocation("1");
        assertEquals(expResult.toString(), actualResult.toString());
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGetAllLocations() {
        System.out.println("getAllLocations");

        Collection<location> listAllLocations = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            listAllLocations.add(new location(i + "", "008" + i, "009" + i, "tester" + i));
        }

        DBfacade mockedFacade = mock(DBfacade.class);
        when(mockedFacade.getAllLocations()).thenReturn(listAllLocations);

        Controller instance = new Controller(mockedFacade);

        assertEquals(listAllLocations.size(), instance.getAllLocations().size());

        for (int i = 0; i < instance.getAllLocations().size(); i++) {
            assertEquals(listAllLocations.iterator().next().toString(), instance.getAllLocations().iterator().next().toString());

        }
    }
}
