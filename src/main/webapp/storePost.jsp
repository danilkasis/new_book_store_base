<%--
  Created by IntelliJ IDEA.
  User: Danil
  Date: 20.04.2018
  Time: 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post Store</title>
</head>
<body>
<section>
    <form method="post" action="/store">
        <dl>
            <dt>ID: </dt>
            <dd><input type="text" name="id"/></dd>
        </dl>
        <dl>
            <dt>Store Name: </dt>
            <dd><input type="text" name="storeName"/></dd>
        </dl>
        <dl>
            <dt>Street Name: </dt>
            <dd><input type="text" name="streetName"/></dd>
        </dl>
        <dl>
            <dt>Number of house: </dt>
            <dd><input type="text" name="numberOfHouse"/></dd>
        </dl>
        <button type="submit">Save</button>
    </form>
</section>
</body>
</html>
