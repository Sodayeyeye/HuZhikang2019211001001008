<%--
  Created by IntelliJ IDEA.
  User: 胡志康
  Date: 2021/3/16
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">go to ecjtu</a><!-- method is GET-->
<form method="post"><!--what is method when we use form?--><!-- its GET, why? default is GET,form data is added in the URL , u can see-->
<!-- its better to use POST in form,date in not added in the URL -->
    Name :<input type="text" name="name"><br/>
    ID:<input type="text" name="id"><br/>
    <input type="submit" value="Send data to server"/>
    <br/>
    This is HuZhiKang's JSP page.
</form>

</body>
</html>
<%@include file="footer.jsp"%>