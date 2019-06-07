<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Confirmation</title>
</head>
<body>

The user has been confirmed: ${user.firstName} ${user.lastName}

<br><br>

Free Passes: ${user.freePasses}

<br><br>

Postal Code: ${user.postalCode}

<br><br>

Course Code: ${user.courseCode}

</body>
</html>