<%--
  Created by IntelliJ IDEA.
  User: 胡志康
  Date: 2021/4/13
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    //read cookies
    Cookie [] allCookies=request.getCookies();//all cookies
    for(Cookie c:allCookies){
        //get one by one
        out.println("<br/>"+c.getName()+" --- "+c.getValue());
    }
%>
<table>
    <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>Email:</td><td><%=request.getAttribute("email")%></td></tr>
    <tr><td>Sex:</td><td><%=request.getAttribute("gender")%></td></tr>
    <tr><td>Birthday:</td><td><%=request.getAttribute("birthdate")%></td><br></tr>
</table>
<%@include file="footer.jsp"%>
