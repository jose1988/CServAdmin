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

    /**
     * Método que que retorna el número de registros existentes de la entidad
     * skin
     *
     * @return entero con el número de registros de skin
     */
    @WebMethod(operationName = "contarSkin")
    public int contarSkin() {

        return skinFacade.count();
    }

    /**
     * Método que lista todos los registros de la entidad skin
     *
     * @return lista de la entidad skin
     */
    @WebMethod(operationName = "listar")
    public List<skin> listar() {
        return skinFacade.listarSkin();
    }

    /**
     * Método encargado de insertar registros de la entidad skin
     *
     * @param registroSkin objeto de la entidad skin , debe tener como mínimo
     * los campos obligatorios para poder insertar
     */
    @WebMethod(operationName = "insertarSkin")
    public void insertarSkin(@WebParam(name = "registroSkin") skin registroSkin) {
        skinFacade.insertarSkin(registroSkin);
    }

    /**
     * Método encargado de editar registros de la entidad skin
     *
     * @param registroSkin objeto de la entidad skin
     */
    @WebMethod(operationName = "editarSkin")
    public void editarSkin(@WebParam(name = "registroSkin") skin registroSkin) {

        skinFacade.editarSkin(registroSkin);
    }

    /**
     * Método encargado de eliminar registros de la entidad skin
     *
     * @param idSkin objeto de la entidad skin , debe tener el campo id como
     * mínimo
     */
    @WebMethod(operationName = "eliminarSkin")
    public void eliminarSkin(@WebParam(name = "idSkin") String idSkin) {

        skinFacade.eliminarSkin(new Long(idSkin));
    }

    /**
     * Método encargado de consultar un registro de skin de acuerdo a su id
     *
     * @param idSkin string que contiene el id del skin a consultar
     * @return objeto de la entidad skin
     */
    @WebMethod(operationName = "buscarSkin")
    public skin buscarSkin(@WebParam(name = "idSkin") String idSkin) {

        try {
            skin find = skinFacade.find(new Long(idSkin));
            return find;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     *
     * Método encargado de cambiar el borrado de registros de la entidad skin,
     * el borrado cambiara a false
     *
     * @param idSkin String que contiene el id del skin a restaurar
     */
    @WebMethod(operationName = "restaurarSkin")
    public void restaurarSkin(@WebParam(name = "idSkin") String idSkin) {

        skinFacade.restaurarSkin(new Long(idSkin));
    }

    /**
     * Método que consulta un registro de acuerdo al nombre del skin
     *
     * @param nombreSkin parametro que contiene el nombre del skin a buscar
     * @return objeto de la entidad skin con el registro buscado
     */
    @WebMethod(operationName = "consultarSkinXNombre")
    public skin consultarSkinXNombre(@WebParam(name = "nombreSkin") String nombreSkin) {

        skin Resultado;
        try {
            Resultado = skinFacade.consultarSkinXNombre(nombreSkin);
        } catch (Exception e) {
            Resultado = null;
        }
        return Resultado;
    }

    /**
     *
     * Método que lista los registros de la entidad skin de acuerdo a su estado
     * si es borrado o no
     *
     * @param borrado booleano si es true es borrado si es false es no borrado
     * @return lista de la entidad skin
     */
    @WebMethod(operationName = "listarXBorrado")
    public List<skin> listarXBorrado(@WebParam(name = "borrado") boolean borrado) {
        return skinFacade.listarSkinXBorrado(borrado);
    }

    /**
     * Método encargado de comprobar si hay dependencias con respecto al skin ,
     * es decir si el skin ha sido usado para registros de otras entidades
     * dependientes de skin, si encuentra alguna dependencia mayor de 0
     * automaticamente quiere decir que no se puede borrar y retorna ese valor
     *
     * @param idSkin objeto de la entidad skin
     * @return entero que contiene el número de dependencias,-1 si da una
     * exepción
     */
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
