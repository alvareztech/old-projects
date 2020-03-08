<%-- 
    Document   : FormOperacionesAritmeticas
    Created on : 27-10-2010, 08:49:32 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operaciones Aitmeticas</title>
    </head>
    <body>
        <h1>Operaciones Aritmeticas</h1>
        <form name="frmOperacionesAritmeticas" method="POST" action="operar.do">
            <table border="0">
                <tr>
                    <td>Numero 1</td>
                    <td><input type="text" name="txtNumero1" value="" /></td>
                </tr>
                <tr>
                    <td>Numero 2</td>
                    <td><input type="text" name="txtNumero2" value="" /></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="+" name="btnSumar" />
                        <input type="submit" value="-" name="btnRestar" />
                        <input type="submit" value="*" name="btnMultiplicar" />
                        <input type="submit" value="/" name="btnDividir" />
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
        <!-- <h1>El resultado es <c:out value="${resultado}"/>.</h1> -->
    </body>
</html>
