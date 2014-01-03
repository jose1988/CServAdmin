/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;



import com.pangea.capadeservicios.beans.politicaFacade;
import com.pangea.capadeservicios.entidades.politica;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pangea
 */


@WebService(serviceName = "GestionDepolitica")
public class GestionDepolitica {
@EJB
politicaFacade politicaFacade;
    /**
     * This is a sample web service operation
     */
    
    @WebMethod(operationName = "listarPolitica")
    public  List<politica> listarPolitica() {
        
        return politicaFacade.listarPolitica();
    }
    
    @WebMethod(operationName = "insertarPolitica")
    public void insertarPolitica(@WebParam(name = "registroPolitica") politica registroPolitica) {
 
      politicaFacade.insertarPolitica(registroPolitica);
    }
    
    @WebMethod(operationName = "editarPolitica")
    public void editarPolitica(@WebParam(name = "registroPolitica") politica registroPolitica) {
 
      politicaFacade.editarPolitica(registroPolitica);
    }
    
    @WebMethod(operationName = "eliminarPolitica")
    public void eliminarPolitica(@WebParam(name = "idPolitica") String idPolitica) {
 
      politicaFacade.eliminarPolitica(new Long(idPolitica));
    }    
   
    @WebMethod(operationName = "contarPolitica")
    public int contarPolitica() {

        return  politicaFacade.count();
    }
    
    @WebMethod(operationName = "buscarPolitica")
    public politica  buscarPolitica(@WebParam(name = "idPolitica") String idPolitica)  {
    
        return  politicaFacade.find(new Long(idPolitica));
    }
    
    @WebMethod(operationName = "listarPoliticaByBorrado")
    public List<politica> listarPoliticaByBorrado(@WebParam(name = "borrado") boolean borrado) {
        return politicaFacade.listarPoliticaByBorrado(borrado);
    }
    
    @WebMethod(operationName = "restaurarPolitica")
    public void restaurarPolitica(@WebParam(name = "idPolitica") String idPolitica){
 
        politicaFacade.restaurarPolitica(new Long(idPolitica));
    }
   
    @WebMethod(operationName = "consultarPoliticaXNombre")
    public politica consultarPoliticaXNombre(@WebParam(name = "nombrePolitica") String nombrePolitica) {
        
        politica Resultado;
        try {
          Resultado= politicaFacade.consultarPoliticaXNombre(nombrePolitica);
        } catch (Exception e) {
            Resultado=null;
        }
        return Resultado;
    }
    
    @WebMethod(operationName = "consultarDependenciasPolitica")
    public int consultarDependenciasPolitica(@WebParam(name = "idPolitica") String idPolitica) {
        int Resultado = 0;
        politica registroPolitica;
        
        try {
            registroPolitica = politicaFacade.find(Long.parseLong(idPolitica));
            
            Resultado = registroPolitica.getGrupopoliticatareaCollection().size();            
            if (Resultado > 0) {
                return Resultado;
            }
            
            Resultado = registroPolitica.getTareaCollection().size();            
            if (Resultado > 0) {
                return Resultado;
            }
            
        } catch (Exception e) {
            Resultado = -1;
        }
        return Resultado;
    }
        
}
