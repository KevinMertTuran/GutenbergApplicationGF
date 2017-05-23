/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import DataAccess.MongoMapping;
import DomainLayer.Controller;
import DomainLayer.book;

/**
 *
 * @author mustafahakimi
 */
public class Main {
    public static void main(String[] args) {
        
        Controller c = new Controller();
        MongoMapping m = new MongoMapping();
        book tempBook = new book("9001", "testCreate", "text.txt");
        
        //c.getAuthor("1");
        //System.out.println("");
        //c.getLocation("1000501");
        //System.out.println("");
        //c.getBook("1");
        //c.deleteAuthorById("9000");
        //c.deleteLocationById("1");
        //c.deleteBookById("9000");
        //c.updateBookById("9000", "testUpdated");
        //c.createBook(tempBook);
        //m.HowManyBooks();
        
        // Given a city name your application returns all book titles with corresponding authors that mention this city.
        //c.getAllBookTitleWithAuthorByCityName("London");
        
        // Given a book title, your application plots all cities mentioned in this book onto a map.
        //c.getAllLocationByBookTitle("Industrial Biography");
        
        //Jules Verne
        //c.getAllBooksAndCitiesByAuthorName("Jules Verne");
        c.getAllBooksByGeolocation("-33.01529", "27.91162");
    }
}
