<%-- 
    Document   : solucion1
    Created on : 18-10-2010, 07:35:41 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Práctica 1 - Solución 1</title>
    </head>
    <body>
        <h1>Solución 1</h1>
        <h3>Serie de los números primos.</h3>
        <%
        int n = 15;
        int c = 1;
        int p = 2;
        int d = 2;
        while (c <= n)
        {
            if (p % d == 0)
            {
                if (p == d)
                {
                    %>
                    <%= p + ", " %>
                    <%
                    c++;
                }
                d = 2;
                p++;
            }
            else
               d++;
        }
        %>
    </body>
</html>
