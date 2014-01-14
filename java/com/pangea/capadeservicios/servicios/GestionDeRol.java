/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.rolFacade;
import com.pangea.capadeservicios.beans.usuario_grupo_rolFacade;
import com.pangea.capadeservicios.entidades.rol;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pangea
 */
@WebService(serviceName = "GestionDeRol")
public class GestionDeRol {

    @EJB
    rolFacade rolFacade;
    @EJB
    usuario_grupo_rolFacade usuarioGrupoRolFacade;

    /**
     * Método que que retorna el número de registros existentes de la entidad
     * rol
     *
     * @return entero con el número de roles
     */
    @WebMethod(operationName = "contarRol")
    public int contarRol() {
        return rolFacade.count();
    }

    /**
     * Método que lista los registros de la entidad rol de acuerdo a su estado
     * si es borrado o no
     *
     * @param borrado booleano si es true es borrado si es false es no borrado
     * @return lista de la entidad rol
     */
    @WebMethod(operationName = "listarRol")
    public List<rol> listarRol(@WebParam(name = "borrado") boolean borrado) {
        return rolFacade.listarRol(borrado);
    }

    /**
     * Método encargado de insertar registros de la entidad rol
     *
     * @param registroRol objeto de la entidad rol , debe tener como mínimo los
     * campos obligatorios para poder insertar
     */
    @WebMethod(operationName = "insertarRol")
    public void insertarRol(@WebParam(name = "registroRol") rol registroRol) {
        rolFacade.insertar(registroRol);
    }

    /**
     * Método encargado de editar registros de la entidad rol
     *
     * @param registroRol objeto de la entidad rol
     */
    @WebMethod(operationName = "editarRol")
    public void editarRol(@WebParam(name = "registroRol") rol registroRol) {
        rolFacade.editar(registroRol);
    }

    /**
     * Método encargado de eliminar registros de la entidad rol
     *
     * @param idRol objeto de la entidad rol , debe tener el campo id como
     * mínimo
     */
    @WebMethod(operationName = "eliminarRol")
    public void eliminarRol(@WebParam(name = "idRol") String idRol) {
        rolFacade.eliminar(idRol);
    }

    /**
     * Método encargado de cambiar el borrado de registros de la entidad rol, el
     * borrado cambiara a false
     *
     * @param idRol String que contiene el id del rol a restaurar
     */
    @WebMethod(operationName = "restaurarRol")
    public void restaurarRol(@WebParam(name = "idRol") String idRol) {
        rolFacade.restaurar(idRol);
    }

    /**
     * Método encargado de consultar un registro de rol de acuerdo a su id
     *
     * @param idRol string que contiene el id del rol a consultar
     * @return objeto de la entidad rol
     */
    @WebMethod(operationName = "consultarRol")
    public rol consultarRol(@WebParam(name = "idRol") String idRol) {
        rol Resultado;
        try {
            Resultado = rolFacade.consultarRol(Long.parseLong(idRol));
        } catch (Exception e) {
            Resultado = null;
        }
        return Resultado;
    }

    /**
     * Método que consulta un registro de acuerdo al nombre del rol
     *
     * @param nombreRol parametro que contiene el nombre del rol a buscar
     * @return objeto de la entidad rol con el registro buscado
     */
    @WebMethod(operationName = "consultarRolXNombre")
    public rol consultarRolXNombre(@WebParam(name = "nombreRol") String nombreRol) {
        rol Resultado;
        try {
            Resultado = rolFacade.consultarRolXnombre(nombreRol);
        } catch (Exception e) {
            Resultado = null;
        }
        return Resultado;

    }

    /**
     * Método encargado de comprobar si hay dependencias  con
     * respecto al rol , es decir si el rol ha sido usado para registros de
     * otras entidades dependientes de rol, si encuentra alguna dependencia mayor de 0
     * automaticamente quiere decir que no se puede borrar y retorna ese valor
     *
     * @param idRol objeto de la entidad rol
     * @return entero que contiene el número de dependencias,-1 si da una
     * exepción
     */
    @WebMethod(operationName = "consultarDependenciasRol")
    public int consultarDependenciasRol(@WebParam(name = "idRol") String idRol) {
        int Resultado = 0;
        rol registroRol;
        try {
            registroRol = rolFacade.consultarRol(Long.parseLong(idRol));
            Resultado = registroRol.getDestinatarioCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = registroRol.getReporterolCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = registroRol.getTarearolCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }
            Resultado = registroRol.getUsuariogruporolCollection().size();
            if (Resultado > 0) {
                return Resultado;
            }

        } catch (Exception e) {
            Resultado = -1;
        }
        return Resultado;
    }
}
