<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Form</title>
<style>
div.error {
	color: red;
}

div.message {
	color: green;
}
</style>
</head>
<body>
<%
String name = (String)request.getAttribute("name");
if(name == null) name = "";

String surname = (String)request.getAttribute("surname");
if(surname == null) surname = "";


String error = (String)request.getAttribute("error");
if(error != null) {
%>
<div class="error"><%=error %></div>
<%
}

String message = (String)request.getAttribute("message");
if(message != null) {
%>
<div class="message"><%=message %></div>
<%
  }
%>

<form name="checkformname" method="POST" action="CheckServlet">
Name: <input type="text" name="name" placeholder="Your name" value="<%=name %>"><br>
Surname: <input type="text" name="surname" placeholder="Your surname" value="<%=surname %>"><br>
<br>
<input type="submit">
<input type="reset">
</form>

</body>
</html>