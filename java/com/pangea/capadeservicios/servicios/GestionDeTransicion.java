/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.transicionFacade;
import com.pangea.capadeservicios.entidades.tarea;
import com.pangea.capadeservicios.envoltorios.WR_transicion;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author pc
 */
@WebService(serviceName = "GestionDeTransicion")
public class GestionDeTransicion {

    @EJB
    transicionFacade myTransicionFacade = new transicionFacade();

    @WebMethod(operationName = "ConsultaTransicion")
    public WR_transicion ConsultaTransicion(@WebParam(name = "idTransicion") tarea idTarea) {
        WR_transicion Resultado = new WR_transicion();
        try {
            Resultado.ingresarTransicion(myTransicionFacade.ConsultarTransicion(idTarea));
            Resultado.setEstatus("OK");
        } catch (Exception e) {
            Resultado.setEstatus("FAIL");
            Resultado.setObservacion("No se encontro la transición");
        }
        return Resultado;
    }
}
