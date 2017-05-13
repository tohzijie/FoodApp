<%-- 
    Document   : modify
    Created on : 9 May, 2017, 2:01:30 AM
    Author     : TohZJ
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Food</title>
    </head>
    <body>
        <%@page import = "java.util.*" %>
        <%@page import="foodapp.*"%>
        <%@include file = "checkAdmin.jsp" %>
        <%@include file = "displayError.jsp" %>
        <form action="/FoodApp/modify-process.jsp" method="post">
            <%                FoodDAO fdao = new FoodDAO();
            
                Food curr = fdao.retrieve(Integer.parseInt(request.getParameter("fid")));
                out.println("<input type = \"hidden\" name = \"fid\" value = " + request.getParameter("fid") + ">");
                out.println("Name: <input type = \"text\" name = \"name\" value = \"" + curr.getFname() + "\"> <br/>");
                out.println("Status: " + curr.getStatusString());
                out.println("<br/> Price: <input type = \"text\" name = \"price\" value = " + curr.getPrice() + "><br/>");
            %>
            <input type ="submit" value ="Modify">
        </form>

    </body>
</html>
