<%-- 
    Document   : save
    Created on : 10 de nov. de 2022, 00:30:20
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="savebrand" action="${pageContext.request.contextPath}/SaveBrand" method="POST">
            <input type="number" name="idbrand" readonly="readonly"><br>
            <input type="text" name="namebrand"><br>
            <textarea id="descriptionbrand" name="descriptionbrand" rows="5" cols="10"></textarea><br>
            <input type="submit" value="" name="Enviar" />
        </form>
            ${msg}
    </body>
</html>
