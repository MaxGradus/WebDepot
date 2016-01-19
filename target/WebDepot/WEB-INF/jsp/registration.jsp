<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Registration</title>
</head>
<body bgcolor="#d3d3d3">
<form method="post" action="/saveNew">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Enter Information Here</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>User Login</td>
                <td><input type="text" name="userLogin" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="userPass" value="" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="userEmail" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
                <td colspan="2">Sign in <a href="/login">Login Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
