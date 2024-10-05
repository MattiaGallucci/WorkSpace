<!doctype html>

<html lang="en">
<head>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/imgs/sum.png">
 <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
 <script src="<%=request.getContextPath()%>/js/jquery-1.12.1.js"></script>

 <title>SUM NUMBERS</title>

 <script>
 $( document ).ready(function() {
  
	$("#reset").click(function(){
		 $("#first").val("");
		 $("#second").val("");
		 $("#result").val("");
		 $("#error").remove();
		});	
 });
 </script>
</head>

<%
String login = (String) request.getAttribute("login");
if(login == null) {
	login = "";
}

String password = (String) request.getAttribute("password");
if(password == null) {
	password = "";
}

String first = (String) request.getAttribute("first");
if(first == null) {
	first = "";
}

String second = (String) request.getAttribute("second");
if(second == null) {
	second = "";
}

String result = (String) request.getAttribute("result");
if(result == null) {
	result = "";
} 

String error = (String) request.getAttribute("error");
%>

<body>
<div class="panel">
<h3>SUM NUMBERS WITH DUAL</h3>
<br>
<a href="<%=request.getContextPath()%>/index.jsp">
<img style="position: absolute;top:35px;width:50px;" src="./imgs/sum.png"></a>
<form method="post" action="connection" name="DatabaseConnection">
 Database credentials:<br>
 <br>
 <label for="login">Login </label><input id="login" type="text" name="login" value="<%=login %>" required/><br>
 <br>
 <label for="second">Password </label><input id="password" type="password" name="password" value="<%=password %>"required/><br>
 <br>
 <hr>
 Perform the sum of two numbers:<br>
 <br>
 <label for="first">A = </label><input id="first" type="number" name="first" step="any" value="<%=first %>" autocomplete="off" required/><br>
 <br>
 <label for="second">B = </label><input id="second" type="text" name="second" step="any" value="<%=second %>" autocomplete="off" required/><br>
 <br>
 <hr>
 <br>
 <label for="result">A + B = </label><input id="result" type="text" name="result" value="<%=result %>" readonly/><br>
 <br>
 <% if(error != null) {%>
 	<div id="error" class="error"><%= error %></div>
 <%} %>
 <input type="submit" value="Compute"><input id="reset" type="button" value="Reset">
</form>
</div>

</body>
</html>
