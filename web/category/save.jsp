<%-- 
    Document   : save
    Created on : 30 de nov. de 2022, 14:58:07
    Author     : Gabriel Rodrigues
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="savecategory" action="${pageContext.request.contextPath}/SaveBrand" method="POST">
            id: <input type="number" name="idcategory" readonly="readonly"><br>
            nome: <input type="text" name="namecategory" ><br>
            descrição: <textarea name="descriptioncategory" rows="5" cols="10"></textarea><br>
            <input type="submit" value="${category == null?'Cadastrar':'Alterar'}" />
        </form>
            ${msg}
    </body>
</html>
