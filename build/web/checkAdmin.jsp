<%-- 
    Document   : checkAdmin
    Created on : 13 May, 2017, 8:13:06 PM
    Author     : TohZJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<%@page import = "java.util.*" %>
<%@page import="foodapp.*"%>


<%
   List<String> errorMsg = new ArrayList<>();
   String isAdmin = (String) session.getAttribute("admin");
    if(isAdmin == null || isAdmin.equals("false")){
        isAdmin = "false";
        session.setAttribute("admin", isAdmin);
        errorMsg.add("Please log in to view this page");
        request.setAttribute("errors", errorMsg);
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }
%>