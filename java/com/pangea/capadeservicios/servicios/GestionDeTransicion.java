/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.transicionFacade;
import com.pangea.capadeservicios.entidades.tarea;
import com.pangea.capadeservicios.envoltorios.WR_transicion;
import com.pangea.capadeservicios.validadores.GestionDeTransicionValidador;
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
    GestionDeTransicionValidador myValidador = new GestionDeTransicionValidador();

    
    @WebMethod(operationName = "consultaTransicionXTarea")
    public WR_transicion consultaTransicionXTarea(@WebParam(name = "idTarea") tarea idTarea) {
        WR_transicion Resultado = new WR_transicion();
        Resultado=myValidador.validarConsultaTransicionXTarea(idTarea);
        if (Resultado.getEstatus().compareTo("OK") != 0) {
            return Resultado;
        }
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
