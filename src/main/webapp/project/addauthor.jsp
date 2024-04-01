<%--
  Created by IntelliJ IDEA.
  User: Josh
  Date: 2022-05-31
  Time: 9:41 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author to the Database!</title>
</head>
<body>

<h1>Add an author</h1>

<form action = "../LibraryApiServlet?action=add_author" method = "POST">
    First Name: <input type = "text" name = "first_name">
    <br />
    Last Name: <input type = "text" name = "last_name" />
    <input type = "submit" value = "Submit" />
</form>

<a href="index.jsp">Back to Main Menu</a>

</body>
</html>
