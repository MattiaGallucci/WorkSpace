<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
      <h2>Servlet SendRedirect Example</h2>
      <form id="loginFormId" method="post" action="loginServlet">
             Username:<input id="userInput" type="text" name="username" required/>
             <br>
             Password:<input id="passInput" type="password" name="password" required/>
             <br>
             <input id="btn" type="submit" value="Login" />
          <%if(request.getAttribute("error") != null) {%>
          	<p style='color: red;'>You are not an authorized user!</p>
          <% } %>
      </form>
</html>

