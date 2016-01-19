<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<html>
<head>
  <title>Buy Place</title>
</head>
<body bgcolor="#d3d3d3">
<center>
<h3>Your choose: <br/></h3>

<form method="POST" action="/places/buy">
<input type="hidden" name="multiplier" value="${multiplier}">
  <input type="hidden" name="placeId" value="${place.placeId}">

${place.placeName} for ${period} - ${price} USD <br/>
  <br/>
  <input type="submit" value="BUY">
</form>
  </center>
</body>
</html>