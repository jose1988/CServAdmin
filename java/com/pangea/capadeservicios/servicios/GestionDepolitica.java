/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;



import com.pangea.capadeservicios.beans.politicaFacade;
import com.pangea.capadeservicios.entidades.politica;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
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
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    
     
       @WebMethod(operationName = "listar")
    public  List<politica> listar() {
        return politicaFacade.listarPolitica();
    }
    
    @WebMethod(operationName = "insertarPolitica")
    public void insertarPolitica(@WebParam(name = "registroUsuario") politica registro) {
 
      politicaFacade.insertarPolitica(registro);
    }
    
     @WebMethod(operationName = "editarPolitica")
    public void editarPolitica(@WebParam(name = "registroUsuario") politica registro) {
 
      politicaFacade.editarPolitica(registro);
    }
      @WebMethod(operationName = "eliminarPolitica")
    public void eliminarPolitica(@WebParam(name = "idPolitica") String ID) {
 
      politicaFacade.eliminarPolitica(ID);
    }
    
   
       @WebMethod(operationName = "contarPolitica")
    public int contarPolitica() {

        return  politicaFacade.count();
    }
    
          @WebMethod(operationName = "buscarPolitica")
    public politica  buscarPolitica(@WebParam(name = "ID") String ID)  {
    
        return  politicaFacade.find(new Long(ID));
    }
       
    
}
