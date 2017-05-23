
package DataAccess;

import DTO.DTOAuthorBook;
import DTO.DTOBookLocation;
import DomainLayer.author;
import DomainLayer.book;
import DomainLayer.location;
import java.sql.Connection;
import java.util.Collection;


// SINGELTON
// One connection to the database 
// One instance of the class

public class DBfacade {
 
    private AuthorMapping authorMapping;
    private LocationMapping locationMapping;
    private BookMapping bookMapping;
    private SQLMapping sqlMapping;
    private Connection con;
    
    // Singleton
    private static DBfacade instance;
    
    // Private Constructor 
    private DBfacade(){
        authorMapping = new AuthorMapping();
        locationMapping = new LocationMapping();
        bookMapping = new BookMapping();
        sqlMapping = new SQLMapping();
        con = new DBconnectorMysql().getConnection();  
        //con = new DBconnectorMongo().getConnection();
        // the connection will be released upon program 
        // termination by the garbage collector		
    }

    
    public static DBfacade getInstance(){
        if(instance == null){
            instance = new DBfacade();
        }
        return instance;
    }
    
    public author getAuthor(String UID){
        return authorMapping.getAuthor(con, UID);
    }
    
    public Collection<author> getAllAuthors(){
        return authorMapping.getAllAuthors(con);
    }
    
    public void deleteAuthorById(String UID){
        authorMapping.deleteAuthorById(con, UID);
    }
    
    public location getLocation(String UID){
        return locationMapping.getLocation(con, UID);
    }
    
    public Collection<location> getAllLocations(){
        return locationMapping.getAllLocations(con);
    }
    
    public void deleteLcoationById(String UID){
        locationMapping.deleteLocationById(con, UID);
    }
    
    public book getBook(String UID){
        return bookMapping.getBook(con, UID);
    }
    
    public Collection<book> getAllBooks(){
        return bookMapping.getAllBooks(con);
    }
    
    public void deleteBookById(String UID){
        bookMapping.deleteBookById(con, UID);
    }
    
    public void updateBookById(String UID, String newValue){
        bookMapping.updateBookById(con, UID, newValue);
    }
    
    public boolean createBook(book b){
        return bookMapping.createBook(con, b);
    }
    
    // ----------------- SQL MAPPING -------------------- // 
    
    public Collection<DTOBookLocation> getAllLocationByBookTitle(String title){
        return sqlMapping.getAllLocationByBookTitle(con, title);
    }
    
    public Collection<DTOAuthorBook> getAllBookTitleWithAuthorByCityName(String location){
        return sqlMapping.getAllBookTitleWithAuthorByCityName(con, location);
    }
    
    public Collection<DTOAuthorBook> getAllBooksAndCitiesByAuthorName(String author){
        return sqlMapping.getAllBooksAndCitiesByAuthorName(con, author);
    }
    
    public Collection<DTOAuthorBook> getAllBooksByGeolocation(String latitude, String longitude){
        return sqlMapping.getAllBooksByGeolocation(con, latitude, longitude);
    }
}
