<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% request.setCharacterEncoding("UTF-8"); %>
        <%="Привет " %>
        <h3>
            <%=request.getParameter("username") %>
        </h3>
        <h3>
            <%=request.getParameter("password") %>
        </h3>
        <h3>
            ${param["password"]}
        </h3>
    </body>
</html>
