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
            <input type="number" name="idbrand" readonly="readonly" value="${brand.getIdBrand()}"><br>
            <input type="text" name="namebrand" value="${brand.getNameBrand()}"><br>
            <textarea id="descriptionbrand" name="descriptionbrand" rows="5" cols="10">${brand.getDescriptionBrand()}</textarea><br>
            <input type="submit" value="${brand == null?'Cadastrar':'Alterar'}" />
        </form>
            ${msg}
    </body>
</html>
