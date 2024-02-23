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
    <title>Book Database Online!</title>
</head>
<body>

<li><a href="../addbook.jsp">Add a Book</a></li>
<li><a href="addauthor.jsp">Add an Author</a></li>

<!-- //TODO Add in a param to differentiate the books vs authors -->
<li><a href="../library-data?view=books">View all books</a></li>
<li><a href="../library-data">View all Authors</a></li>


</body>
</html>
