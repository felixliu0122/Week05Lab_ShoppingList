<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="<c:url value='/shoppingList'/>" method="POST">
            <label>Username:</label>
            <input type="text" name="username"/>
            <input type="hidden" name="action" value="register"/>
            <input type="submit" value="Register Name"/>
            <br><br>
            ${message} 
        </form>
    </body>
</html>