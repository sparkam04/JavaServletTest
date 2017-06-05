<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 04.06.2017
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>

<html>
<head>
    <title>Jsp Test Title</title>
</head>
<body>
<%!
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public void jspInit() {
        String initParameter = getServletConfig().getInitParameter("defaultParamNameJSP");
        getServletConfig().getServletContext().setAttribute("jspInitParamXml", initParameter);
    }
%>

<h1>Hello from JSP</h1> <br>
It is <%=new Date()%> <br><br>

<form method="get" action="index.jsp">
    i: <input name="i"/>
    j: <input name="j"/>
    <br><br>

    <input type="submit"/>

</form>
<%
    int i = 0;
    int j = 0;
    if (request.getParameter("i") != null && !request.getParameter("i").equals("")){
        i = Integer.parseInt(request.getParameter("i"));
    }
    if (request.getParameter("j") != null && !request.getParameter("j").equals("")){
        j = Integer.parseInt(request.getParameter("j"));
    }
%>

i + j = <%=add(i, j)%><br><br>

JSP Servlet Context parameter value is: <%=getServletConfig().getServletContext().getAttribute("jspInitParamXml")%><br>
JSP Servlet Config parameter is: <%=getServletConfig().getInitParameter("defaultParamNameJSP")%>


</body>
</html>
