<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello <c:out value="${username}"/>, 
            <a href="<c:url value='/shoppingList?action=logout'/>">Logout</a>
        </p>

        <h2>List</h2>
        <form action="<c:url value='/shoppingList'/>" method="POST">
            <input type="hidden" name="action" value="add"/>
            <label>Add Item:</label>
            <input type="text" name="itemAdd"/> 
            <input type="submit" value="Add"/>
        </form>
        <br>
        <c:if test="${itemList.size() > 0}">
            <form action="<c:url value='/shoppingList'/>" method="POST">
                <c:forEach var='item' items="${itemList}">
                    ${item}
                    <input type="radio" name="itemDel" value="${item}"/>
                    <br>
                </c:forEach>
                <input type="submit" value="Delete"/>
                <input type="hidden" name="action" value="delete"/>
            </form>
        </c:if>
    </body>
</html>