<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#username").on("blur", function() {
                var username = $(this).val();
                $.post("registrazione", { mode: "checkUsername", username: username }, function(data) {
                    if (data.trim() === "non disponibile") {
                        $("#usernameMessage").text("Username non disponibile").css("color", "red");
                    } else {
                        $("#usernameMessage").text("Username disponibile").css("color", "green");
                    }
                });
            });

            $("#email").on("blur", function() {
                var email = $(this).val();
                $.post("registrazione", { mode: "checkEmail", email: email }, function(data) {
                    if (data.trim() === "non disponibile") {
                        $("#emailMessage").text("Email non disponibile").css("color", "red");
                    } else {
                        $("#emailMessage").text("Email disponibile").css("color", "green");
                    }
                });
            });
        });
    </script>
</head>
<body>
    <h2>Registrazione</h2>

    <% 
        String error = (String) session.getAttribute("error");
        String result = (String) session.getAttribute("result");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <% 
        session.removeAttribute("error");
        } else if (result != null) {
    %>
        <p style="color:green;"><%= result %></p>
    <% 
        session.removeAttribute("result");
        } 
    %>

    <form action="registrazione" id="registrazione" method="post">
        <input type="hidden" name="mode" value="register">

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <span id="usernameMessage"></span><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="passwordCheck">Conferma Password:</label>
        <input type="password" id="passwordCheck" name="passwordCheck" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <span id="emailMessage"></span><br><br>

        <button>Registrati</button>
    </form>
</body>
</html>
