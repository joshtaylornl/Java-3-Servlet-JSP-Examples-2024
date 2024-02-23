package ca.nl.cna.java3.JDBC;

/**
 * Store all the MariaDB connection properties here.
 */
public class DBProperties {

    public static final String DB_URL = "jdbc:mariadb://localhost:3307";

    //?user=root&password=RootPwJoSh2024
    public static final String USER = "root";
    public static final String PASS = "RootPwJoSh2024";

    //Specific test database URL
    public static final String JAVA_TEST_DB_URL = "jdbc:mariadb://localhost:3307/java_test?user=root&password=RootPwJoSh2024";

    //Book Table Information
    public static final String BOOK_DB_URL = "jdbc:mariadb://localhost:3307/books";
    public static final String BOOK_TABLE_NAME = "titles";
    public static final String BOOK_COL_NAME_ISBN = "isbn";
    public static final String BOOK_COL_NAME_TITLE = "title";
    public static final String BOOK_COL_NAME_EDITION_NUMBER = "editionNumber";
    public static final String BOOK_COL_NAME_COPYRIGHT = "copyright";



}
