<%-- 
    Document   : FormRegistroOpciones
    Created on : 23-10-2010, 09:44:00 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilo.css" type="text/css" />
        <title>Formulario de Registro de Opciones</title>
    </head>
    <body>
        <label class="titulo">Registro de Opciones</label>
        <form name="frmRegistrarOpciones" method="post">
            <table border="0">
                <tr>
                    <td>
                        <label>*</label>
                        URL
                    </td>
                    <td>
                        <input type="text" name="txtURL" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>*</label>
                        Descripcion
                    </td>
                    <td>
                        <textarea name="txaDescripcion" rows="4" cols="20">
                        </textarea>
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
