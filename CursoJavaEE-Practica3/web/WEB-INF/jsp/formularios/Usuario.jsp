<%-- 
    Document   : Usuario
    Created on : 27-10-2010, 10:05:58 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <h1>Usuario</h1>
        Nombre: <c:out value="${nombre}"/>
        <br>
        Login: <c:out value="${login}"/>
        <br>
        Contraseña: <c:out value="${contrasenia}"/>
        <br>
        Confirmación de Contraseña: <c:out value="${confContrasenia}"/>
        <br>
        <font color="red"><c:out value="${mensaje}!"/></font>
    </body>
</html>
