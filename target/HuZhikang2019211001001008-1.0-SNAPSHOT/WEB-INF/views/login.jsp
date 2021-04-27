<%--
  Created by IntelliJ IDEA.
  User: 胡志康
  Date: 2021/4/5
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1 style="color:black;font-feature-settings:normal;font-size: 30px">Login</h1>
<%
    if(request.getAttribute("message")!=null){
        //error
       // System.out.println("hello");
        System.out.println(request.getAttribute("message"));
    }
%>
<%
    //read cookies
    Cookie[] allCookies=request.getCookies();//give all cookies
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        //we read 3 cookies
        for(Cookie c:allCookies){
            //get one by one
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    UserName:<input type="text" name="username" value="<%=username%>" style="width:250px;height: 30px;margin-top: 2px"><br/>
    Password:<input type="password" name="password" value="<%=password%>" style="width:250px;height: 30px;margin-top: 5px"><br/>
    RememberMe<input type="checkbox" name="rememberMe"value="1" <%=rememberMeVal.equals("1")?"checked":""%> /><br/>
    <input type="submit" name="submit" value="login" style="background-color: antiquewhite;color: black;width: 70px;height: 25px;font-size: 15px"
    />
</form>
<%@include file="footer.jsp"%>
