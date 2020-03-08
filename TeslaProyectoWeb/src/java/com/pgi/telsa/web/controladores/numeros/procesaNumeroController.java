/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgi.telsa.web.controladores.numeros;

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
public class procesaNumeroController extends AbstractController {

    public procesaNumeroController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Map pareja = new HashMap();
        String numeroCad = request.getParameter("txtNumero");
        int numeroModificado = Integer.parseInt(numeroCad) * 100;
        pareja.put("resultado", numeroModificado);
        return new ModelAndView("Ejemplos/mensaje", pareja);
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
