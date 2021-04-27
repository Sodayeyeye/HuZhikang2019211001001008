<%--
  Created by IntelliJ IDEA.
  User: 胡志康
  Date: 2021/4/13
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<h1>User List</h1>
<table border=\"1\">
    <tr>
        <td>Id</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%
        //get re from request Attribute
        ResultSet re= (ResultSet) request.getAttribute("rename");
        if (re==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>

    <%}else{

            while (re.next()) {
                out.println("<tr>");
                out.println("<td>"+re.getInt("id")+"</td>");
                out.println("<td>"+re.getString("username")+"</td>");
                out.println("<td>"+re.getString("password")+"</td>");
                out.println("<td>"+re.getString("email")+"</td>");
                out.println("<td>"+re.getString("gender")+"</td>");
                out.println("<td>"+re.getString("birthdate")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");

        }
    %>
</table>

<%@include file="footer.jsp"%>
