<%-- 
    Document   : delete
    Created on : 9 May, 2017, 1:17:04 AM
    Author     : TohZJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="foodapp.*"%>

<%
    FoodDAO fdao = new FoodDAO();
    fdao.delete(Integer.parseInt(request.getParameter("fid")));
    response.sendRedirect("/FoodApp");
%>