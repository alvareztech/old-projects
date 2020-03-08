/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a3d.practica3.web.numeros;

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
public class OperacionesBasicasController extends AbstractController {

    public OperacionesBasicasController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String numero1 = request.getParameter("txtNumero1");
        String numero2 = request.getParameter("txtNumero2");
        String sumar = request.getParameter("btnSumar");
        String restar = request.getParameter("btnRestar");
        String multiplicar = request.getParameter("btnMultiplicar");
        String dividir = request.getParameter("btnDividir");
        int r = 0;
        if (sumar != null)
            r = Integer.parseInt(numero1) + Integer.parseInt(numero2);
        if (restar != null)
            r = Integer.parseInt(numero1) - Integer.parseInt(numero2);
        if (multiplicar != null)
            r = Integer.parseInt(numero1) * Integer.parseInt(numero2);
        if (dividir != null)
            r = Integer.parseInt(numero1) / Integer.parseInt(numero2);
        Map pareja = new HashMap();
        pareja.put("resultado", r);
        return new ModelAndView("operaciones/Mensaje", pareja);
    }
}
