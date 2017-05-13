<%-- 
    Document   : login
    Created on : 12 May, 2017, 12:57:17 PM
    Author     : TohZJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@include file = "displayError.jsp" %>
        <form action="/FoodApp/login-process.jsp" method="post">
            Username: <input type ="text"  name ="username" value =""> <br/>
            Password: <input type ="password" name ="password" value=""><br/>

            <input type ="submit" value ="Log in">
        </form>
    </body>
</html>
