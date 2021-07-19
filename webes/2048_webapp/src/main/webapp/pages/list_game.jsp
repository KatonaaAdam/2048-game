<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<html>
<head>
    <jsp:include page="common/common-header.jsp"/>
    <link rel="stylesheet" href="../css/list.css">
    <title>List Game</title>
</head>
<body>

<jsp:include page="../GameController"/>
<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Time</th>
            <th scope="col">Level</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${requestScope.gameList}">
            <tr>
                <td>${item.time}</td>
                <td>${item.level}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="../Vissza" method="post">
   <button id="meret"  class="btn btn-primary">Főoldal</button>
    </form>



</div>

</body>
</html>


