<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<html>
<head>
  <title>All Places</title>
</head>
<center>
<body bgcolor="#d3d3d3">

<c:forEach items="${places}" var="p">
  ${p.placeName} - ${p.price} USD <br/>
</c:forEach>

<sec:authorize access="hasRole('ROLE_USER')">
  <td align="center"><a href="/free_places">Free places</a></td>
</sec:authorize>

</center>
</body>
</html>
