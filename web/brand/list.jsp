<%-- 
    Document   : list
    Created on : 10 de nov. de 2022, 13:35:02
    Author     : Gabriel Rodrigues
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>nome</th>
                    <th>descrição</th>
                </tr>
            </thead>
            <tbody>
                    <c:forEach items="${brands}" var="brand">
                <tr>
                    <td>${brand.getNameBrand()}</td>
                    <td>${brand.getDescriptionBrand()}</td>
                </tr>
                </c:forEach>
                 
            </tbody>
        </table>

    </body>
</html>
