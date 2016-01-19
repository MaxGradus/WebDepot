<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<html>
<head>

  <title>Available Places</title>
</head>

<body bgcolor="#d3d3d3">

<center>
<c:forEach items="${places}" var="p">
  ${p.placeName} <a href="/places/${p.placeId}.html">NEXT</a> <br/>
<br/>
</c:forEach>

<sec:authorize access="hasRole('ROLE_USER')">
  <td align="center"><a href="/places">All places</a></td>
</sec:authorize>
  </center>
</body>
</html>