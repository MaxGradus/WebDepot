<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<html>
<head>
  <title>All Users</title>
</head>
<body bgcolor="#d3d3d3">
<center>

<c:forEach items="${users}" var="u">
  ${u.login} - ${u.email} &nbsp;&nbsp; <a href="/users/${u.userId}.html">View</a> <br/>
</c:forEach>

<br/>
<a href="/places">Places</a> <br/>

<a href="/free_places">Free places</a>
  </center>
</body>
</html>
