<%-- 
    Document   : solucion9
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
        <title>Práctica 1 - Solución 9</title>
    </head>
    <body>
        <h1>Solución 9</h1>
        <h3>Muestra los meses que tienen 31 dias.</h3>
        <%
                    String[] nombres = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                    int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                    pageContext.setAttribute("nombres", nombres);
                    pageContext.setAttribute("dias", dias);
        %>
        <c:forEach var="i" begin="0" end="11" step="1">
            <c:if test="${dias[i] == 31}">
                <c:out value="El mes de ${nombres[i]} tiene 31 dias."/><br>
            </c:if>
        </c:forEach>
    </body>
</html>
