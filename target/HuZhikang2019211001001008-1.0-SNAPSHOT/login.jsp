<%--
  Created by IntelliJ IDEA.
  User: 胡志康
  Date: 2021/4/5
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1 style="color:black;font-feature-settings:normal;font-size: 30px">Login</h1>
<form method="post" action="login">
    UserName:<input type="text" name="username" style="width:250px;height: 30px;margin-top: 2px"><br/>
    Password:<input type="password" name="password" style="width:250px;height: 30px;margin-top: 5px"><br/>
    <input type="submit" name="submit" value="login" style="background-color: antiquewhite;color: black;width: 70px;height: 25px;font-size: 15px"
    />
</form>
<%@include file="footer.jsp"%>
