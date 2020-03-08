<%-- 
    Document   : solucion3
    Created on : 18-10-2010, 08:06:36 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Práctica 1 - Solución 3</title>
    </head>
    <body>
        <h1>Solución 3</h1>
        <h3>Mostrar el literal de un número del 1 al 10</h3>
        <c:set var="numero" value="7"/>
        <c:choose>
            <c:when test="${numero == 1}">
                Uno
            </c:when>
            <c:when test="${numero == 2}">
                Dos
            </c:when>
            <c:when test="${numero == 3}">
                Tres
            </c:when>
            <c:when test="${numero == 4}">
                Cuatro
            </c:when>
            <c:when test="${numero == 5}">
                Cinco
            </c:when>
            <c:when test="${numero == 6}">
                Seis
            </c:when>
            <c:when test="${numero == 7}">
                Siete
            </c:when>
            <c:when test="${numero == 8}">
                Ocho
            </c:when>
            <c:when test="${numero == 9}">
                Nueve
            </c:when>
            <c:when test="${numero == 10}">
                Diez
            </c:when>
            <c:otherwise>
                El valor <c:out value="${numero}"/> esta fuera de rango.
            </c:otherwise>
        </c:choose>
    </body>
</html>
