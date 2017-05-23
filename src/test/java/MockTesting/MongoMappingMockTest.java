package MockTesting;

import DTO.DTOAuthorBook;
import DataAccess.MongoMapping;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MongoMappingMockTest {

    static MongoMapping mapping;
    static DataSource dataSource;
    static Connection con;
    static PreparedStatement statement1;
    static ResultSet rs;
    static Statement statement2;

    public MongoMappingMockTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception, SQLException {
        mapping = mock(MongoMapping.class);
        dataSource = mock(DataSource.class);
        con = mock(Connection.class);
        statement1 = mock(PreparedStatement.class);
        statement2 = mock(Statement.class);
        rs = mock(ResultSet.class);

        assertNotNull(dataSource);
        when(con.prepareStatement(any(String.class))).thenReturn(statement1);
        when(con.createStatement()).thenReturn(statement2);
        when(dataSource.getConnection()).thenReturn(con);

        when(statement1.executeQuery()).thenReturn(rs);
        when(con.prepareStatement(any(String.class))).thenReturn(statement1);
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

//    @Test
//    public void getBooksByCityTest() throws SQLException {
//        when(rs.getString("title")).thenReturn("mocked title").thenReturn("mocked title 2");
//        when(rs.getString("author.name")).thenReturn("mocked author").thenReturn("mocked author 2");
//        when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
//        
//        List<DTOAuthorBook> test = mapping.test("johny");
//        
//        assertThat(test.size(), is(2));
//        assertThat(test.get(0).getTitle(), is("mocked title"));
//        assertThat(test.get(0).getAuthor(), is("mocked author"));
//
//    }
}
