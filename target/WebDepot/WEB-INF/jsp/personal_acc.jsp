<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<html>
<head>
  <title>Personal Account</title>
</head>
<body bgcolor="#d3d3d3">
<center>
<c:set var="val" value="${size}"/>
<c:choose>
  <c:when test="${val == '0'}">
    You have not places yet <br/>
    <a href="/places">Buy Place</a>
  </c:when>
  <c:otherwise>
    <c:forEach items="${places}" var="p">
     My place - ${p.placeName} available till ${p.date} <br/>
    </c:forEach>
  </c:otherwise>
</c:choose>
<br/>
  </center>
</body>
</html>
