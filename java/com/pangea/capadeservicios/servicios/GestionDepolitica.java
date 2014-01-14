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
     * Método que lista todos los registros de la entidad politica
     *
     * @return lista de la entidad politica
     */    
    @WebMethod(operationName = "listarPolitica")
    public  List<politica> listarPolitica() {
        
        return politicaFacade.listarPolitica();
    }
    
    /**
     * Método encargado de insertar registros de la entidad politica
     *
     * @param registroPolitica objeto de la entidad politica, debe tener como mínimo
     * los campos obligatorios para poder insertar
     */
    @WebMethod(operationName = "insertarPolitica")
    public void insertarPolitica(@WebParam(name = "registroPolitica") politica registroPolitica) {
 
      politicaFacade.insertarPolitica(registroPolitica);
    }
    
    /**
     * Método encargado de editar registros de la entidad politica
     *
     * @param registroPolitica objeto de la entidad politica
     */
    @WebMethod(operationName = "editarPolitica")
    public void editarPolitica(@WebParam(name = "registroPolitica") politica registroPolitica) {
 
      politicaFacade.editarPolitica(registroPolitica);
    }
    
    /**
     * Método encargado de eliminar registros de la entidad politica
     *
     * @param idPolitica objeto de la entidad politica, debe tener el campo id como
     * mínimo
     */
    @WebMethod(operationName = "eliminarPolitica")
    public void eliminarPolitica(@WebParam(name = "idPolitica") String idPolitica) {
 
      politicaFacade.eliminarPolitica(new Long(idPolitica));
    }    
   
    /**
     * Método que que retorna el número de registros existentes de la entidad
     * politica
     *
     * @return entero con el número de registros de politica
     */
    @WebMethod(operationName = "contarPolitica")
    public int contarPolitica() {

        return  politicaFacade.count();
    }
    
    /**
     * Método encargado de consultar un registro de politica de acuerdo a su id
     *
     * @param idPolitica string que contiene el id del politica a consultar
     * @return objeto de la entidad politica
     */
    @WebMethod(operationName = "buscarPolitica")
    public politica  buscarPolitica(@WebParam(name = "idPolitica") String idPolitica)  {
    
        return  politicaFacade.find(new Long(idPolitica));
    }
    
    /**
     * Método que lista los registros de la entidad politica de acuerdo a su estado
     * si es borrado o no
     *
     * @param borrado booleano si es true es borrado si es false es no borrado
     * @return lista de la entidad politica
     */
    @WebMethod(operationName = "listarPoliticaByBorrado")
    public List<politica> listarPoliticaByBorrado(@WebParam(name = "borrado") boolean borrado) {
        return politicaFacade.listarPoliticaByBorrado(borrado);
    }
    
    /**
     * Método encargado de cambiar el borrado de registros de la entidad politica,
     * el borrado cambiara a false
     *
     * @param idPolitica String que contiene el id de la politica a restaurar
     */
    @WebMethod(operationName = "restaurarPolitica")
    public void restaurarPolitica(@WebParam(name = "idPolitica") String idPolitica){
 
        politicaFacade.restaurarPolitica(new Long(idPolitica));
    }
   
    /**
     * Método que consulta un registro de acuerdo al nombre de la politica
     *
     * @param nombrePolitica parametro que contiene el nombre de la politica a buscar
     * @return objeto de la entidad politica con el registro buscado
     */
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
    
    /**
     * Método encargado de comprobar si hay dependencias con respecto a la politica,
     * es decir si la politica ha sido usada para registros de otras entidades
     * dependientes de politica, si encuentra alguna dependencia mayor de 0
     * automaticamente quiere decir que no se puede borrar y retorna ese valor
     *
     * @param idPolitica objeto de la entidad politica
     * @return entero que contiene el número de dependencias,-1 si da una
     * exepción
     */
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
