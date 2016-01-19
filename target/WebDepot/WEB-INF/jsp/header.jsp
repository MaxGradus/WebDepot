<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
    <meta charset="utf-8">
    <style>
        @font-face {
            font-family: Pompadur;
            src: url(/static/faith_collapsing/FaithCollapsing.ttf);
        }
        P {
            font-family: Pompadur;
        }
    </style>
</head>
<table width="100%">
    <tr>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
      <td align="center"><h2><a href="<c:url value="/admin" />" > Administration</a></h2></td>
    </sec:authorize>
    <td align="center"><h2><a href="/my_places">Personal Account</a></h2> </td>
    <td align="center"><h2><a href="/places">Buy Placement</a></h2> </td>
    <td align="center"><h2><a href="/history">History</a></h2> </td>
    <td align="center"><h2><a href="/contacts">Contacts</a></h2> </td>
    <td align="center"><h2><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2></td>

  </tr>
</table>
<br/>
