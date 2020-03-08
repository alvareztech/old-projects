<%-- 
    Document   : solucion7
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
        <title>Práctica 1 - Solución 7</title>
    </head>
    <body>
        <h1>Solución 7</h1>
        <h3>Muestra los n primeros numeros primos.</h3>
        <c:set var="n" value="7"/>
        <c:set var="p" value="2"/>
        <c:set var="d" value="2"/>
        <c:set var="c" value="1"/>
        <c:out value="n = ${n}"/>
        <br>
        <c:forEach var="i" begin="1" end="${n*n*n}" step="1" >
            <c:if test="${c <= n}">
                <c:if test="${p % d == 0}">
                    <c:if test="${p == d}">
                        <c:out value="${p}, "/>
                        <c:set var="c" value="${c + 1}"/>
                    </c:if>
                    <c:set var="d" value="2"/>
                    <c:set var="p" value="${p + 1}"/>
                </c:if>
                <c:if test="${p % d != 0}">
                    <c:set var="d" value="${d + 1}"/>
                </c:if>
            </c:if>
        </c:forEach>
    </body>
</html>
