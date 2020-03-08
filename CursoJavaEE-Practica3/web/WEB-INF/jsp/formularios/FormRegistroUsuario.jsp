<%-- 
    Document   : FormRegistroUsuario
    Created on : 23-10-2010, 09:19:51 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilo.css" type="text/css" />
        <title>Formulario Registro de Usuario</title>
    </head>
    <body>
        <label class="titulo">Registro de Usuario</label>
        <form name="frmRegistrarUsuario" method="post" action="muestrausuario.do">
            <table border="0">
                <tr>
                    <td>
                        <label>*</label>
                        Nombre
                    </td>
                    <td>
                        <input type="text" name="txtNombre" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>*</label>
                        Login
                    </td>
                    <td>
                        <input type="text" name="txtLogin" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>*</label>
                        Contraseña
                    </td>
                    <td>
                        <input type="password" name="txtContrasenia" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>*</label>
                        Confirmar Contraseña
                    </td>
                    <td>
                        <input type="password" name="txtConfContrasenia" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Aceptar" name="btnAceptar" />
                        <input type="reset" value="Limpiar" name="btnLimpiar" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
