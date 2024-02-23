package ca.nl.cna.java3.a2;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import ca.nl.cna.java3.JDBC.DBProperties;

/**
 * Simple class to manage the database connection and retrieve all the books from the database.
 * This class is not meant to be used in a production environment.
 * It is meant to be used for educational purposes only.
 */
public class SimpleDBManager {

    /**
     * Retrieve all of the books from the database into a LinkedList.
     * Note: this method is dangerous if the database is large. In our example it isn't.
     * @return List of Book objects
     */
    public static List<Book> getAllBooks() throws SQLException {
        LinkedList bookList = new LinkedList();

        Connection connection = getBooksDBConnection();
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * from " + DBProperties.BOOK_TABLE_NAME;

        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while(resultSet.next()) {
            bookList.add(
                    new Book(
                            resultSet.getString(DBProperties.BOOK_COL_NAME_ISBN),
                            resultSet.getString(DBProperties.BOOK_COL_NAME_TITLE),
                            resultSet.getInt(DBProperties.BOOK_COL_NAME_EDITION_NUMBER),
                            resultSet.getString(DBProperties.BOOK_COL_NAME_COPYRIGHT)
                    )
            );
        }
        return bookList;
    }

    /**
     * Insert book into the database
     * @param book
     * @throws SQLException
     */
    public static void insertBook(Book book) throws SQLException {
        Connection connection = getBooksDBConnection();

        String sqlQuery = "INSERT INTO " + DBProperties.BOOK_TABLE_NAME +
                " VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

        //The 4 values are the books attributes
        preparedStatement.setString(1, book.getIsbn());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setInt(3, book.getEditionNumber());
        preparedStatement.setString(4, book.getCopyright());

        preparedStatement.executeQuery();

    }

    /**
     * Get a connection to the Books Database - details in the inner class Books Database SQL
     * @return connection
     * @throws SQLException
     */
    private static Connection getBooksDBConnection() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            System.out.println("Option 1: Find the class worked!");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: unable to load driver class!");
        } catch(IllegalAccessException ex) {
            System.err.println("Error: access problem while loading!");
        } catch(InstantiationException ex){
            System.err.println("Error: unable to instantiate driver!");
        }

        return DriverManager.getConnection(DBProperties.BOOK_DB_URL, DBProperties.USER, DBProperties.PASS);
    }

}
