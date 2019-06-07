<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student registration form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">

FirstName: <form:input path="firstName"/>

<br><br>

LastName: <form:input path="lastName"/>

<br><br>

Country:
<form:select path="country">
<form:options items="${student.countryOptions}"/>

</form:select>

<br><br>

Favorite language:

Java <form:radiobutton path="favouriteLanguage" value="Java"/>
C# <form:radiobutton path="favouriteLanguage" value="C#"/>
PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>
Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/>

<br><br>

Operating Systems:
Linux <form:checkbox path="operatingSystems" value="Linux"/>
Windows <form:checkbox path="operatingSystems" value="Windows"/>
Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>

<br><br>

<input type="submit" value="Submit"/>
</form:form>

</body>
</html>