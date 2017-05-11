<%-- 
    Document   : add-process
    Created on : 9 May, 2017, 8:59:39 AM
    Author     : TohZJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import="foodapp.*"%>

<%
   List<String> errorMsg = CheckFields.checkIsEmpty(request.getParameter("name"), request.getParameter("price"));
    if (!errorMsg.isEmpty()) {
        request.setAttribute("errors", errorMsg);
        request.setAttribute("oname", request.getParameter("name"));
        request.setAttribute("oprice", request.getParameter("price"));
        RequestDispatcher view = request.getRequestDispatcher("add.jsp");
        view.forward(request, response);
    }

    FoodDAO fdao = new FoodDAO();
    fdao.create(request.getParameter("name"), 0, Double.parseDouble(request.getParameter("price")));

    response.sendRedirect("/FoodApp");
%>
