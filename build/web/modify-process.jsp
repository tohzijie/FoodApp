<%-- 
    Document   : modify-process
    Created on : 9 May, 2017, 2:52:30 PM
    Author     : TohZJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<%@page import = "java.util.*" %>
<%@page import="foodapp.*"%>
<%
    List<String> errorMsg = CheckFields.checkIsEmpty(request.getParameter("name"), request.getParameter("price"));
    if (!errorMsg.isEmpty()) {
        request.setAttribute("errors", errorMsg);
        RequestDispatcher view = request.getRequestDispatcher("modify.jsp?fid=" + request.getParameter("fid"));
        view.forward(request, response);
    }
    FoodDAO fdao = new FoodDAO();
    Food toBeUpdated = fdao.retrieve(Integer.parseInt(request.getParameter("fid")));
    toBeUpdated.setPrice(Double.parseDouble(request.getParameter("price")));
    toBeUpdated.setFname(request.getParameter("name"));
    fdao.update(toBeUpdated);
    response.sendRedirect("/FoodApp");
%>