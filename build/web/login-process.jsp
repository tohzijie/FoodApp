<%-- 
    Document   : login-process
    Created on : 12 May, 2017, 3:07:55 PM
    Author     : TohZJ
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<%@page import = "java.util.*" %>
<%@page import="foodapp.*"%>


<%
    List<String> errorMsg = CheckFields.passwordChecker(request.getParameter("username"), request.getParameter("password"));
    if (!errorMsg.isEmpty()) {
        request.setAttribute("errors", errorMsg);
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }
    boolean isExist = LoginDAO.authenticate(request.getParameter("username"), request.getParameter("password"));
    if(isExist){
        session.setAttribute("admin", "true");
        response.sendRedirect("/FoodApp");
    }else{
        errorMsg.add("Invalid account");
        request.setAttribute("errors", errorMsg);
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }
    
%>