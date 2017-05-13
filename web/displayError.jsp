<%-- 
    Document   : displayError
    Created on : 13 May, 2017, 8:36:41 PM
    Author     : TohZJ
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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