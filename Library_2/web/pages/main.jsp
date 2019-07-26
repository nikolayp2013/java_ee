<%@page import="testjdbc.TestConneciton"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Онлайн библиотека</title>
        <link href="css/style_main.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <% request.setCharacterEncoding("UTF-8");%>
        <%="Привет"%>
        <h3>
            <%=request.getParameter("username")%>
        </h3>
        <h3>
            ${param["password"]}
        </h3>
        <%

        TestConneciton tc = new TestConneciton();
        tc.check();
               
%>
    </body>
</html>
