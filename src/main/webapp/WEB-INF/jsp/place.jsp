<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<html>
<head>
  <title>Current Place</title>
</head>
<body bgcolor="#d3d3d3">
<center>
<form method="POST" action="/places/period">
  <input type="hidden" name="placeId" value="${place.placeId}">
  <table>
    <tr>
      <td></td>
      <td>${place.placeName} &nbsp;&nbsp; <select name="select">
        <option>one month</option>
        <option>two month</option>
        <option>three month</option>
      </select> </td>
    </tr>
  </table>
  <br/>
  <input type="submit" value="BUY">
</form>
  </center>

</body>
</html>