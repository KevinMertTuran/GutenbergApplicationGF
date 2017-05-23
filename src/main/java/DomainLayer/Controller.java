/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer;

import DTO.DTOAuthorBook;
import DTO.DTOBookLocation;
import DataAccess.DBfacade;
import java.util.Collection;

/**
 *
 * @author mustafahakimi
 */
public class Controller {

    private DBfacade dbf;

    public Controller() {
        dbf = DBfacade.getInstance();
    }

    public Controller(DBfacade dbf) {
        this.dbf = dbf;
    }

    public author getAuthor(String UID) {
        return dbf.getAuthor(UID);
    }

    public Collection<author> getAllAuthors() {
        return dbf.getAllAuthors();
    }
    
    public void deleteAuthorById(String UID){
        dbf.deleteAuthorById(UID);
    }

    public location getLocation(String UID) {
        return dbf.getLocation(UID);
    }

    public Collection<location> getAllLocations() {
        return dbf.getAllLocations();
    }
    
    public void deleteLocationById(String UID){
        dbf.deleteLcoationById(UID);
    }

    public book getBook(String UID) {
        return dbf.getBook(UID);
    }

    public Collection<book> getAllBooks() {
        return dbf.getAllBooks();
    }
    
    public void deleteBookById(String UID){
        dbf.deleteBookById(UID);
    }
    
    public void updateBookById(String UID, String newValue){
        dbf.updateBookById(UID, newValue);
    }
    
    public boolean createBook(book b){
        return dbf.createBook(b);
    }
    
    // ------------------------ SQL MAPPING ---------------------- //
    
    public Collection<DTOAuthorBook> getAllBookTitleWithAuthorByCityName(String location){
        return dbf.getAllBookTitleWithAuthorByCityName(location);
    }
    
    public Collection<DTOBookLocation> getAllLocationByBookTitle(String title){
        return dbf.getAllLocationByBookTitle(title);
    }
    
    public Collection<DTOAuthorBook> getAllBooksAndCitiesByAuthorName(String author){
        return dbf.getAllBooksAndCitiesByAuthorName(author);
    }
    
    public Collection<DTOAuthorBook> getAllBooksByGeolocation(String latitude, String longitude){
        return dbf.getAllBooksByGeolocation(latitude, longitude);
    }
}
