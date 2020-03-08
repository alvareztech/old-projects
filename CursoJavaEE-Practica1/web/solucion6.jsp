<%-- 
    Document   : solucion6
    Created on : 18-10-2010, 08:46:07 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Práctica 1 - Solución 6</title>
    </head>
    <body>
        <h1>Solución 6</h1>
        <h3>Muestra los n primeros numeros impares.</h3>
        <c:set var="n" value="9"/>
        <c:set var="cd" value="0"/>
        <c:out value="n = ${n}"/>
        <br>
        <c:forEach var="i" begin="1" end="${n*2}" step="2">
            <c:out value="${i}, "/>
        </c:forEach>
    </body>
</html>
