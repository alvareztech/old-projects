<%-- 
    Document   : solucion2
    Created on : 18-10-2010, 07:54:05 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Práctica 1 - Solución 2</title>
    </head>
    <body>
        <h1>Solución 2</h1>
        <h3>Verifica si un número es par o impar.</h3>
        <c:set var="numero" value="7"/>
        <c:if test="${numero % 2 == 0}">
            <c:out value="${numero}"/> es Par.
        </c:if>
        <c:if test="${numero % 2 == 1}">
            <c:out value="${numero}"/> es Impar.
        </c:if>
    </body>
</html>
