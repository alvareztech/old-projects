<%-- 
    Document   : solucion4
    Created on : 18-10-2010, 08:17:57 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Práctica 1 - Solución 4</title>
    </head>
    <body>
        <h1>Solución 4</h1>
        <h3>Hallar el factorial de un número n.</h3>
        <c:set var="n" value="7"/>
        <c:set var="f" value="1"/>
        <c:forEach var="i" begin="1" end="${n}" step="1">
            <c:set var="f" value="${f * i}"/>
        </c:forEach>
        <c:out value="${n}"/>! = <c:out value="${f}"/>
    </body>
</html>
