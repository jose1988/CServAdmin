/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.skinFacade;
import com.pangea.capadeservicios.entidades.skin;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pangea
 */
@WebService(serviceName = "GestionarSkin")
public class GestionarSkin {

    /**
     * This is a sample web service operation
     */
    @EJB
    skinFacade skinFacade;
    
    @WebMethod(operationName = "contarSkin")
    public int contarSkin() {
        
        return skinFacade.count();
    }
    
    @WebMethod(operationName = "listar")
    public List<skin> listar() {
        return skinFacade.listarSkin();
    }
    
    @WebMethod(operationName = "insertarSkin")
    public void insertarSkin(@WebParam(name = "registroSkin") skin registroSkin) {
        
        skinFacade.insertarSkin(registroSkin);
    }
    
    @WebMethod(operationName = "editarSkin")
    public void editarSkin(@WebParam(name = "registroSkin") skin registroSkin) {
        
        skinFacade.editarSkin(registroSkin);
    }

    @WebMethod(operationName = "eliminarSkin")
    public void eliminarSkin(@WebParam(name = "idSkin") String idSkin) {
        
        skinFacade.eliminarSkin(new Long(idSkin));
    }
    
    @WebMethod(operationName = "buscarSkin")
    public skin buscarSkin(@WebParam(name = "idSkin") String idSkin) {
        
        try {
            skin find = skinFacade.find(new Long(idSkin));
            return find;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @WebMethod(operationName = "restaurarSkin")
    public void restaurarSkin(@WebParam(name = "idSkin") String idSkin){
 
        skinFacade.restaurarSkin(new Long(idSkin));
    }
   
    @WebMethod(operationName = "consultarSkinXNombre")
    public skin consultarSkinXNombre(@WebParam(name = "nombreSkin") String nombreSkin) {
        
        skin Resultado;
        try {
          Resultado= skinFacade.consultarSkinXNombre(nombreSkin);
        } catch (Exception e) {
            Resultado=null;
        }
        return Resultado;
    }

    @WebMethod(operationName = "listarXBorrado")
    public List<skin> listarXBorrado(@WebParam(name = "borrado") boolean borrado) {
        return skinFacade.listarSkinXBorrado(borrado);
    }  
    
    @WebMethod(operationName = "consultarDependenciasSkin")
    public int consultarDependenciasSkin(@WebParam(name = "idSkin") String idSkin) {
        int Resultado = 0;
        skin Skin;
        try {
            Skin = skinFacade.find(Long.parseLong(idSkin));
            Resultado = Skin.getUsuarioCollection().size();
        } catch (Exception e) {
            Resultado = -1;
        }
        return Resultado;
    }
}
