<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<html>
<head>
  <title>Current User</title>
</head>
<body bgcolor="#d3d3d3">
<center>
<c:set var="val" value="${size}"/>
<form method="POST" action="/users/delete">
  <input type="hidden" name="userId" value="${user.userId}">
  <table>
    <tr>
      <td>ID</td>
      <td>${user.userId}</td>
    </tr>
    <tr>
      <td>Login</td>
      <td>${user.login}</td>
    </tr>
    <tr>
      <td>Password</td>
      <td>${user.password}</td>
    </tr>
    <tr>
      <td>Email</td>
      <td>${user.email}</td>
    </tr>
    <tr>
      <td>Places</td>
      <c:choose>
        <c:when test="${val == '0'}">
          <td>EMPTY <br/></td>
        </c:when>
        <c:otherwise>
      <td><c:forEach items="${places}" var="p">
        <a href="/place/${p.placeId}.html">${p.placeName}</a> &nbsp;&nbsp;
      </c:forEach></td>
    </tr>
        </c:otherwise>
      </c:choose>
      <br/>
  </table>
  <input type="submit" value="DELETE">
</form>
</center>

</body>
</html>