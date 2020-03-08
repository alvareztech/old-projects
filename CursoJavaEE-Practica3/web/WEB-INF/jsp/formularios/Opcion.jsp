<%-- 
    Document   : Opcion
    Created on : 27-10-2010, 10:06:06 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opcion</title>
    </head>
    <body>
        <h1>Opcion</h1>
        URL: <c:out value="${url}"/>
        <br>
        Descripcion: <c:out value="${descripcion}"/>
    </body>
</html>
