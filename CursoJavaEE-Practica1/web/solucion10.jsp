<%-- 
    Document   : solucion10
    Created on : 18-10-2010, 09:10:39 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Práctica 1 - Solución 10</title>
    </head>
    <body>
        <h1>Solución 10</h1>
        <h3>Muestra a los estudiantes que tienen nota mayor a 71.</h3>
        <%
                    String[] estudiantes = {"Daniel", "Katherine", "Pablo", "Raquel", "Alejandro", "Vivian"};
                    int[] notas = {95, 45, 78, 30, 51, 88};
                    pageContext.setAttribute("estudiantes", estudiantes);
                    pageContext.setAttribute("notas", notas);
        %>
        <c:set var="i" value="0"/>
        <c:forEach var="est" items="${estudiantes}" varStatus="estado">
            <c:if test="${notas[i] > 71}">
                <c:out value="El estudiante ${est} tiene una nota de ${notas[i]}."/><br>
            </c:if>
            <c:set var="i" value="${i + 1}"/>
        </c:forEach>
    </body>
</html>
