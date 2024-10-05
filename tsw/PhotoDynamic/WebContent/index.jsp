<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,it.unisa.model.Lecture"%>

<%
	Collection<?> model = (Collection<?>)request.getAttribute("lecturers");
	if(model == null) {
		request.getRequestDispatcher("./getLecturers").forward(request, response);
		return;
	}
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Photo</title>
	</head>
	<body>
		<h3>List Lecturers</h3>
		<%
			if(model != null && model.size() > 0) {
				Iterator<?> it = model.iterator(); 
				while(it.hasNext()) {
					Lecture item = (Lecture)it.next();
		%>
		<%=item.getId()%>
		<img src="./getPicture?id=<%=item.getId()%>" onerror="this.src='./imgs/nophoto.png'" style="width:100px;height:100px">
		<%=item.getName()%>
		<%=item.getSurname()%>
		<br>
		<%
				}
			}	
		%>
		<br>
		<hr>
		<h3>Upload photo:</h3>
		<form action="UploadPhoto" enctype="multipart/form-data" method="post">
			Name-surname:
			<select name="id">
		<%
			if(model != null && model.size() > 0) {
				Iterator<?> it = model.iterator(); 
				while(it.hasNext()) {
					Lecture item = (Lecture)it.next();
		%>	
				<option value="<%=item.getId()%>"><%=item.getName()%> <%=item.getSurname()%></option>
		<%
				}
			}	
		%>		
			</select>
			<br>
			<input class="file" type="file" name="talkPhoto" value="" maxlength="255">	
			<br>		
			<input type="submit" value="Upload"><input type="reset">
		</form>
		<hr>
		<h3>Add lecturer:</h3>
		<form action="addLecturer" method="post">
			<input type="text" name="name" required placeholder="Your name">
			<br>
			<input type="text" name="surname" required placeholder="Your surname">
			<br>
			<input type="submit" value="Add"><input type="reset">	
		</form>
		
		</body>
</html>