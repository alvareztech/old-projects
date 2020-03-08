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
public class RegistroRolController extends AbstractController {

    public RegistroRolController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        String nombre = request.getParameter("txtNombre");
        String descripcion = request.getParameter("txaDescripcion");

        Map pareja = new HashMap();
        pareja.put("nombre", nombre);
        pareja.put("descripcion", descripcion);
        return new ModelAndView("formularios/Rol", pareja);
    }

}