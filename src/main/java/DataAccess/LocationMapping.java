/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DomainLayer.author;
import DomainLayer.location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author mustafahakimi
 */
public class LocationMapping {

    // GET
    public location getLocation(Connection con, String UID) {

        location returnLocation = new location("", "", "", "");

        String SQLString1 = "SELECT * FROM location WHERE UID = ?";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, UID);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                returnLocation = new location(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));

            }

            System.out.println(returnLocation.getName());
        } catch (Exception e) {
            System.out.println("Fail in mapping");
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                System.out.println("Fail in closing connection");
                System.out.println(e.getMessage());
            }
        }

        return returnLocation;
    }
    
    // GET by id
    public Collection<location> getAllLocations(Connection con) {

        Collection<location> locations = new ArrayList<>();

        String SQLString1
                = "SELECT * FROM location";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                locations.add(new location(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in closing connection");
                System.out.println(e.getMessage());
            }
        }

        return locations;
    }

    // DELETE
    public void deleteLocationById(Connection con, String UID) {

        String SQLString1
                = "DELETE FROM location WHERE uid = ?";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, UID);

            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Fail in mapping");
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in closing connection");
                System.out.println(e.getMessage());
            }
        }

    }
}
