<%-- 
    Document   : logout
    Created on : 13 May, 2017, 8:03:34 PM
    Author     : TohZJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<%@page import = "java.util.*" %>
<%@page import="foodapp.*"%>


<%
    session.invalidate();
    response.sendRedirect("/FoodApp");
%>