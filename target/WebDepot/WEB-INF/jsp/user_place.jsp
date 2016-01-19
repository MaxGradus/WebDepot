<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<html>
<head>
  <title>User's Place</title>
</head>
<body bgcolor="#d3d3d3">
<center>
  <table>
    <tr>
      <td>Place Name</td>
      <td>${place.placeName}</td>
    </tr>
    <tr>
      <td>Paid till</td>
      <td>${place.date}</td>
    </tr>
  </table>
  <br/>
  <a href="/admin">Admin Panel</a> <br/>
  </center>
</body>
</html>