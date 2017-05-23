/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DomainLayer.author;
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
public class AuthorMapping {

    // GET
    public author getAuthor(Connection con, String UID) {

        author returnAuthor = new author("", "");

        String SQLString1 = "SELECT * FROM author WHERE UID = ?";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, UID);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                returnAuthor = new author(rs.getString(1), rs.getString(2));
            }

            System.out.println(returnAuthor.getName());
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

        return returnAuthor;
    }

    // GET by id
    public Collection<author> getAllAuthors(Connection con) {

        Collection<author> authors = new ArrayList<>();

        String SQLString1
                = "SELECT * FROM author";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                authors.add(new author(rs.getString(1), rs.getString(2)));
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

        return authors;
    }

    // DELETE
    public void deleteAuthorById(Connection con, String UID) {

        String SQLString1
                = "DELETE FROM author WHERE uid = ?";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1,UID);

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
