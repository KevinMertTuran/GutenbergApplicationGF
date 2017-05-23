/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DomainLayer.book;
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
public class BookMapping {

    // GET
    public book getBook(Connection con, String UID) {

        book returnBook = new book("", "", "");

        String SQLString1 = "SELECT * FROM book WHERE UID = ?";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, UID);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                returnBook = new book(rs.getString(1), rs.getString(2), rs.getString(3));

            }

            System.out.println(returnBook.getTitle());
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

        return returnBook;
    }

    // GET by id
    public Collection<book> getAllBooks(Connection con) {

        Collection<book> books = new ArrayList<>();

        String SQLString1
                = "SELECT * FROM book";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                books.add(new book(rs.getString(1), rs.getString(2), rs.getString(3)));
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

        return books;
    }

    // DELETE
    public void deleteBookById(Connection con, String UID) {

        String SQLString1
                = "DELETE FROM book WHERE uid = ?";

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

    // PUT
    public void updateBookById(Connection con, String UID, String newValue) {

        String SQLString1
                = "UPDATE book SET title = ? WHERE uid = ?";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, newValue);
            statement.setString(2, UID);

            statement.executeUpdate();

            System.out.println("Record is updated");
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

    // POST
    public boolean createBook(Connection con, book b) {

        int rowsInserted = 0;

        String SQLString1
                = "INSERT into book (uid, title, text) VALUES (?,?,?)";

        PreparedStatement statement = null;

        try {
            System.out.println("Creating book - 1");
            statement = con.prepareStatement(SQLString1);

            statement.setString(1, b.getUID());
            statement.setString(2, b.getTitle());
            statement.setString(3, b.getText());

            System.out.println("Creating book - 2");

            rowsInserted = statement.executeUpdate();
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

        return rowsInserted == 1;
    }


}
