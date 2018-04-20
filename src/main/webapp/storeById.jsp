<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Danil
  Date: 20.04.2018
  Time: 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>storeById</title>
</head>
<body>
<h1>Store by ID</h1>
<table border="10">
    <c items="${store}" var="store">
        <tr>
            <td><c:out value="${store.storeId}"/></td>
            <td><c:out value="${store.storeName}"/></td>
            <td><c:out value="${store.streetName}"/></td>
            <td><c:out value="${store.numberOfHouse}"/></td>
        </tr>
    </c>
</table>
<h3><a href="storePost.jsp">Post store</a></h3>
</body>
</html>

