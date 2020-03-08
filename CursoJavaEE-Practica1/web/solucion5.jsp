<%-- 
    Document   : solucion5
    Created on : 18-10-2010, 08:38:40 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Práctica 1 - Solución 5</title>
    </head>
    <body>
        <h1>Solución 5</h1>
        <h3>Verifica si un número es primo o no.</h3>
        <c:set var="n" value="7"/>
        <c:set var="cd" value="0"/>
        <c:forEach var="d" begin="1" end="${n}" step="1">
            <c:if test="${n % d == 0}">
                <c:set var="cd" value="${cd + 1}"/>
            </c:if>
        </c:forEach>
        <c:if test="${cd == 2}">
            <c:out value="${n}"/> es numero primo.
        </c:if>
        <c:if test="${cd != 2}">
            <c:out value="${n}"/> es numero compuesto.
        </c:if>
    </body>
</html>
