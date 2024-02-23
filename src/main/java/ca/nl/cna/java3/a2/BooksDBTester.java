package ca.nl.cna.java3.a2;

import java.sql.*;
import java.util.List;

/**
 * Test the SimpleDBManager
 *
 * @author Josh
 */
public class BooksDBTester {

    public static void main(String[] args) {

        List<Book> bookList = null;
        try {
            bookList = SimpleDBManager.getAllBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Book book: bookList) {
            book.printBookInformation(System.out);
        }
    }

}