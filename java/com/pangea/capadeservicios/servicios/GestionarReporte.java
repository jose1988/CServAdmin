/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.reporteFacade;
import com.pangea.capadeservicios.entidades.reporte;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pangea
 */
@WebService(serviceName = "GestionarReporte")
public class GestionarReporte {

    @EJB
    reporteFacade reporteFacade;
    
    /**
     * Método que cuenta los reportes que estan almacenados
     * @return número entero con la cantidad de reportes
     */
    @WebMethod(operationName = "contarReporte")
    public int contarReporte() {
 
     return reporteFacade.count();
    }
    
    /**
     * Método que lista los reportes almacenadas
     * @return lista de tipo reporte
     */
    @WebMethod(operationName = "listarReporte")
    public  List<reporte> listarReporte() {
        return reporteFacade.listarReporte();
    }
    
    /**
     * Método que inserta el reporte
     * @param registro
     */
    @WebMethod(operationName = "insertarReporte")
    public void insertarReporte(@WebParam(name = "registroReporte") reporte registroReporte) {
 
      reporteFacade.create(registroReporte);
    }
    
    /**
     * Método que edita el reporte
     * @param registro
     */
    @WebMethod(operationName = "editarReporte")
    public void editarReporte(@WebParam(name = "registroReporte") reporte registroReporte) {
 
      reporteFacade.edit(registroReporte);
    }
    
    /**
     * Método que elimina el reporte de manera lógica
     * @param ID
     */
    @WebMethod(operationName = "eliminarReporte")
    public void eliminarReporte(@WebParam(name = "idReporte") String idReporte) {
 
      reporteFacade.eliminarReporte(idReporte);
    }
    
    /**
     * Método que busca el reporte
     * @param ID
     */
    @WebMethod(operationName = "buscarReporte")
    public reporte buscarReporte(@WebParam(name = "idReporte") String idReporte)  {

        try {
            reporte find = reporteFacade.find(new Long(idReporte));
            return find;
        } catch (Exception ex) {
            return null;
        }
    }
}
