package ca.nl.cna.java3.JDBC;

/**
 * Store all the MariaDB connection properties here.
 */
public class MariaDBProperties {

    //TODO Update this port to the right port
    public static final String MARIADB_PORT = "3307";
    //?user=root&password=RootPwJoSh2024
    public static final String USER = "root";

    //TODO Update this password to the right password
    public static final String PASS = "RootPwJoSh2024";

    /*
    The common database variables
     */
    public static final String DB_URL = "jdbc:mariadb://localhost:" + MARIADB_PORT;
    public static final String JAVA_TEST_DB_URL = "jdbc:mariadb://localhost:" + MARIADB_PORT + "/java_test?user=root&password=" + PASS;
    public static final String BOOK_DB_URL = "jdbc:mariadb://localhost:" + MARIADB_PORT + "/books";
    public static final String BOOK_DB_URL_WITH_CREDENTIALS = "jdbc:mariadb://localhost:" + MARIADB_PORT + "/books?user=root&password=" + PASS;
    public static final String BOOK_TABLE_NAME = "titles";
    public static final String BOOK_COL_NAME_ISBN = "isbn";
    public static final String BOOK_COL_NAME_TITLE = "title";
    public static final String BOOK_COL_NAME_EDITION_NUMBER = "editionNumber";
    public static final String BOOK_COL_NAME_COPYRIGHT = "copyright";

    public static final String QUERY_ALL_AUTHORS = "SELECT * FROM authors;";
    public static final String QUERY_ALL_TITLES = "SELECT * FROM titles;";


}
