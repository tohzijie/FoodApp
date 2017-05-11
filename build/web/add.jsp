<%-- 
    Document   : add
    Created on : 9 May, 2017, 1:09:09 AM
    Author     : TohZJ
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Food</title>
    </head>
    <body>
        <%
            ArrayList<String> errorsmsg = (ArrayList<String>) request.getAttribute("errors");
            if (errorsmsg != null) {
                out.println("<div><ol>");
                for (String msg : errorsmsg) {
                    out.println("<li>" + msg + "</li>");
                }
                out.println("<ol></div>");
            }
        %>
        <form action="/FoodApp/add-process.jsp" method="post">
            Name: <input type="text" name="name" value="<% 
                if(request.getAttribute("oname")!=null){
                out.println((String)request.getAttribute("oname"));} %>"><br>
            Price: <input type="num" name="price" value="<%  if(request.getAttribute("oprice")!=null){
                out.println((String)request.getAttribute("oprice"));}  %>" ><br><br>
            <input type ="submit" value ="Add">
        </form>
    </body>
</html>
