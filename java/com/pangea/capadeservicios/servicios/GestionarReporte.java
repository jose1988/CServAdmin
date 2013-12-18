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
 
        reporteFacade.eliminarReporte(new Long(idReporte));
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
    
    /**
     * Método que lista los reportes dependiendo del estado
     * @param borrado 1 si el borrado es FALSE y 1 si es TRUE
     * @return lista de tipo reporte
     */
    @WebMethod(operationName = "listarReporteByBorrado")
    public List<reporte> listarReporteByBorrado(@WebParam(name = "borrado") boolean borrado) {
        return reporteFacade.listarReporteByBorrado(borrado);
    }
    
    /**
     * Método que elimina el reporte de manera lógica
     * @param ID
     */
    @WebMethod(operationName = "restaurarReporte")
    public void restaurarReporte(@WebParam(name = "idReporte") String idReporte) {
 
        reporteFacade.restaurarReporte(new Long(idReporte));
    }
    
    /**
     * Método que consulta el nombre del reporte para verificar si existe o no
     * @param nombreReporte
     * @return
     */
    @WebMethod(operationName = "consultarReporteXNombre")
    public reporte consultarReporteXNombre(@WebParam(name = "nombreReporte") String nombreReporte) {
        
        reporte Resultado;
        try {
          Resultado= reporteFacade.consultarReporteXnombre(nombreReporte);
        } catch (Exception e) {
            Resultado=null;
        }
        return Resultado;
    }
}
