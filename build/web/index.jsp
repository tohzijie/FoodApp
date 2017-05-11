<%-- 
    Document   : index
    Created on : 8 May, 2017, 11:37:33 PM
    Author     : TohZJ
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Food Menu</title>
    </head>
    <body>
        <%@page import = "java.util.*" %>
        <%@page import="foodapp.*"%>
        <table border ='0'> <tr> <th>Name</th><th>Available?</th><th>Price</th></tr>

            <%
                FoodDAO fdao = new FoodDAO();
                List<Food> result = fdao.retrieveAll();
                if (result != null) {
                    for (Food f : result) {
                        out.println("<tr><td>" + f.getFname() + "</td>");
                        out.println("<td>" + f.getStatusString() + "</td>");
                        out.println("<td>" + f.getPrice() + "</td>");
                        out.println("<td><a href = 'modify.jsp?fid=" + f.getFid() + "'> Edit </a></td>");
                        out.println("<td><a href = 'delete.jsp?fid=" + f.getFid() + "'> Delete </a></td></tr>");
                    }
                }
            %>
        </table>
        <form action="/FoodApp/add.jsp" method="get">
            <input type="submit" value ="Add food">
        </form>

    </body>
</html>
