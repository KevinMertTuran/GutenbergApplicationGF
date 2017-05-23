/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RunMongo;

import DataAccess.MongoMapping;

/**
 *
 * @author mustafahakimi
 */
public class Main {
    public static void main(String[] args) {
        
        MongoMapping m = new MongoMapping();
        
        //m.getBooksByCity("London");
        m.getBooksByAuthor("Jules Verne");
        m.getLocationByTitle("Tom Swift Among The Diamond Makers");

    }
}
