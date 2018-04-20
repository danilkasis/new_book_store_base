<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Danil
  Date: 19.04.2018
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StoreList</title>
</head>
<body>
<h1>Stores</h1>
<table border="10">
    <c:forEach items="${storeList}" var="st">
        <tr>
            <td><c:out value="${st.storeId}"/></td>
            <td><c:out value="${st.storeName}"/></td>
            <td><c:out value="${st.streetName}"/></td>
            <td><c:out value="${st.numberOfHouse}"/></td>
        </tr>

    </c:forEach>
</table>
<h3><a href="storePost.jsp">Post store</a></h3>
</body>
</html>
