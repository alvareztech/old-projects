<%-- 
    Document   : formRegistroReclamo
    Created on : 23-10-2010, 08:56:53 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="ejemploCss.css" type="text/css" />
        <title>Formulario de Reclamos</title>
    </head>
    <body>
        <label class="titulo">
            REGISTRAR RECLAMO
        </label>
        <form name="frmRegistrarReclamo" method="POST">
            <table border="0">
                <tr>
                    <td>
                        <label>*</label>
                        Servicio
                    </td>
                    <td>
                        <select name="cbxServicios" size="1">
                            <option value="1">RENTA DE EQUIPOS</option>
                            <option value="2">SOFTWARE</option>
                            <option value="3">TELEFONIA</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>*</label>
                        Cedula Identidad:
                    </td>
                    <td>
                        <input type="text" name="txtCI" value="" maxlength="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>*</label>
                        Nombre Cliente:
                    </td>
                    <td>
                        <input type="text" name="txtNombre" value="" size="60" maxlength="200" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>*</label>
                        Descripcion:
                    </td>
                    <td>
                        <textarea name="txtDescripcion" rows="4" cols="20"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Registrar" name="btnRegistrar" />
                        <input type="reset" value="Limpiar" name="btnLimpiar" />
                    </td>
                </tr>
            </table>

        </form>
    </body>
</html>
