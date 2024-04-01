<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<! This example uses the GET method to send the form data to the server.>
<html>
<body>

<p>
    This example navigates based on the input. The correct login is Chaitanya
    and the password is beginnersbook <br> Try both values
</p>
<br>

<form action="fun-with-navigation-servlet" method="post">
    User Name:<input type="text" name="user_name"/><br/>
    Password:<input type="password" name="user_password"/><br/>
    <input type="submit" value="SUBMIT"/>
</form>

</body>
</html>