package ca.nl.cna.java3.a2;
/**
 *
 * YOU HAVE TO FOLLOW THE ASSIGNMENT. I BUILD SOME STRUCTURE FOR YOU TO FOLLOW.
 *
 * 1.	Get the DM Manager Class Working
 *
 * 2.	Create a Servlet called LibraryData
 * •	The Servlet should override the doPost and doGet methods
 * •	Note: Do not have any SQL queries or connections in this servlet. It all has to be in the DBConnection class.
 * •	The doPost method will handle submissions of form data, one for each of a book and and an author. You will differentiate the submission through the use of a “hidden” form field (see JSP objectives for more details, and check out this link on HTML hidden fields: https://www.w3schools.com/tags/att_input_type_hidden.asp).
 * •	Posted form data will be used to insert records into the database. You should use a prepared statement for all insert statements. (Do not handle this in the LibraryData servlet - Call a method in the DBConnection class)
 * •	On submission, print a confirmation message to the user and allow them to return to your main JSP page.
 *
 * •	The doGet method will handle book and author “views” that will be driven from queries for the respective data. The view that is delivered will be differentiated by a URL variable called “view” (see JSP objectives for more details).
 * •	The book view is essentially a listing of titles from the database. Note that you should include a list of author(s) for each book title.
 * •	The author view is essentially a listing of the authors from the database. Note that you should include a list of any books that an author has written.
 * •	You can use any HTML you would like to format these outputs.
 * •	After generating a view, provide a means for the user to return to the main JSP page.
 *
 *
 * Part 3: JSP
 *
 * •	Create a main JSP page (index.jsp) that will provide a menu to allow a user to choose the following options:
 * o	Add a new book (links to addbook.jsp)
 * o	Add an author (links to addauthor.jsp)
 * o	View books (links to LibraryData Servlet with appropriate URL attribute)
 * o	View authors (links to LibraryData Servlet with appropriate URL attribute)
 * •	Create an addbook.jsp page that will have a form allowing a user to enter a new book, including author. Your form should submit to the LibraryData Servlet. You should include a hidden html field that should be set to a value of “book”. You will use this to differentiate your posted data in your Servlet.
 * •	*NOTE: For the purposes of this assignment, let’s assume that you can only add one author for a new book entry. Also, assume that an author you are adding with a book is a new author (i.e. doesn’t already exist in the DB). Just for the purpose of simplicity.
 * •	Create an addauthor.jsp page that will have a form allowing a user to enter a new author. Your form should submit to the LibraryData Servlet. You should include a hidden html field that should be set to a value of “author”. You will use this to differentiate your posted data in your Servlet.
 * •	Note that each of the two pages (addbook.jsp and addauthor.jsp) should provide a link at the bottom to allow a user to return to the index.jsp page without submitting the form.
 *
 */