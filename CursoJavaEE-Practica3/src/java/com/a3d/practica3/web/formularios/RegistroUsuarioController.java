/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.a3d.practica3.web.formularios;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Daniel
 */
public class RegistroUsuarioController extends AbstractController {

    public RegistroUsuarioController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        String nombre = request.getParameter("txtNombre");
        String login = request.getParameter("txtLogin");
        String contrasenia = request.getParameter("txtContrasenia");
        String confContrasenia = request.getParameter("txtConfContrasenia");

        String mensaje = confContrasenia.equals(contrasenia) ? "Contraseña Correcta" : "Contraseña Incorrecta";

        Map pareja = new HashMap();
        pareja.put("nombre", nombre);
        pareja.put("login", login);
        pareja.put("contrasenia", contrasenia);
        pareja.put("confContrasenia", confContrasenia);
        pareja.put("mensaje", mensaje);
        return new ModelAndView("formularios/Usuario", pareja);
    }

}