<%--
  Created by IntelliJ IDEA.
  User: Josh
  Date: 2022-05-31
  Time: 9:40 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a book to the database!</title>
</head>
<body>

Add a Book

<!--
    private String isbn;
    private String title;
    private int editionNumber;
    private String copyright;
-->

<h1>Add a Book!</h1>

<form action = "library-data" method = "POST">
    ISBN: <input type = "text" name = "isbn"> <br />
    Title: <input type = "text" name = "title" /> <br />
    Edition Number: <input type = "text" name = "edition_number" /> <br />
    Copyright: <input type = "text" name = "copyright" />
    <input type="hidden" id="view" name="view" value="add_book">
    <input type = "submit" value = "Submit" />
</form>

</br>
<a href="a2/index.jsp">Back to Main Menu</a>


</body>
</html>
