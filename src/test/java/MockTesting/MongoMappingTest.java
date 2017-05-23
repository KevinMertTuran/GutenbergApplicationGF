/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MockTesting;

import DTO.DTOAuthorBook;
import DataAccess.MongoMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author kevinturan
 */
@RunWith(Parameterized.class)
public class MongoMappingTest {
    
    public MongoMappingTest(String _author) {
    this._author = _author;
    }
    
    
    /**
     * Test of getBooksByCity method, of class MongoMapping.
     */
//    @Test
//    public void testGetBooksByCity() {
//        System.out.println("getBooksByCity");
//        String location = "";
//        
//        /*
//        DBfacade mockedFacade = mock(DBfacade.class);
//        when(mockedFacade.getBook("1")).thenReturn(new book("1", "The Book", "Big bad book"));
//        */
//        
//        MongoMapping mocked = mock(MongoMapping.class);
//        when(mocked.)
//        
//        
//        List<DTOAuthorBook> expResult = null;
//        List<DTOAuthorBook> result = instance.getBooksByCity(location);
//        
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    private String _author;
    
   @Parameters
    public static Collection<String> data() {
        return Arrays.asList(new String[]      
                 { "Author1","Author2", "Author3" } 
           );
    }
    
    /**
     * Test of getBooksByAuthor method, of class MongoMapping.
     */
    @Test
    public void testGetBooksByAuthor() {
        
        
        System.out.println("getBooksByAuthor with author: "+_author);
        
        List<DTOAuthorBook> listBooks = new ArrayList<DTOAuthorBook>();
        for (int i = 0; i < 10; i++) {
            listBooks.add(new DTOAuthorBook("title" + i, _author));
        }

        MongoMapping mocked = mock(MongoMapping.class);
        when(mocked.getBooksByAuthor(_author)).thenReturn(listBooks);

        for (int i = 0; i < 10; i++) {
            assertEquals(listBooks.iterator().next().toString(), mocked.getBooksByAuthor(_author).iterator().next().toString());
        }

    }

    /**
     * Test of getLocationByTitle method, of class MongoMapping.
     */
//    @Test
//    public void testGetLocationByTitle() {
//        System.out.println("getLocationByTitle");
//        String title = "";
//        MongoMapping instance = new MongoMapping();
//        instance.getLocationByTitle(title);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
