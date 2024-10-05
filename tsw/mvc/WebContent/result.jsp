<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Beer Recommendations JSP</h1>
	<p>
		<%
			List<?> styles = (List<?>) request.getAttribute("styles");
			Iterator<?> it = styles.iterator();
			while (it.hasNext()) {
				out.print("<br>try: " + it.next());
			}
		%>

</body>
</html>