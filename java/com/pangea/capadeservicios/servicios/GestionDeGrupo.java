/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.servicios;

import com.pangea.capadeservicios.beans.grupoFacade;
import com.pangea.capadeservicios.beans.usuario_grupo_rolFacade;
import com.pangea.capadeservicios.entidades.grupo;
import com.pangea.capadeservicios.entidades.rol;
import com.pangea.capadeservicios.entidades.usuario;
import com.pangea.capadeservicios.entidades.usuario_grupo_rol;
import com.pangea.capadeservicios.envoltorios.WR_rol;
import com.pangea.capadeservicios.envoltorios.WR_usuario_grupo_rol;
import com.pangea.capadeservicios.validadores.GestionDeGrupoValidador;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pangea
 */
@WebService(serviceName = "GestionDeGrupo")
public class GestionDeGrupo {

    @EJB
    grupoFacade grupoFacade;
    @EJB
    usuario_grupo_rolFacade ugrFacade;
    GestionDeGrupoValidador myValidador = new GestionDeGrupoValidador();

    /**
     * Método que cuenta la cantidad de grupos que estan almacenados
     * @return número entero con la cantidad de grupos
     */
    @WebMethod(operationName = "contarGrupo")
    public int contarGrupo() {

        return grupoFacade.count();
    }
    
    /**
     * Método que lista la información de la tabla usuario_grupo_rol
     * especificamente por el usuario ingresado cuando se inicia sesión,
     * listando la información de los grupos que posee dicho usuario
     *
     * @param usr
     * @return
     */
    @WebMethod(operationName = "gruposUsuario")
    public Collection<grupo> gruposUsuario(@WebParam(name = "user") usuario usr) {

        return ugrFacade.gruposUsuario(usr);
    }

    /**
     * Método que lista los grupos almacenados y los ordena por nombre
     *
     * @return lista de tipo grupo
     */
    @WebMethod(operationName = "listarGrupos")
    public List<grupo> listarGrupos() {

        return grupoFacade.listarGrupos();
    }

    /**
     * Método que lista la información de la tabla usuario_grupo_rol
     * especificamente los usuarios dependiendo del grupo que se selecciona en
     * la página y se verifica que dicha información no este borrada,
     * verificando que el dato borrado sea false
     *
     * @param idGrupo
     * @param borradoo
     * @return
     */
    @WebMethod(operationName = "listarUsuariosGrupo")
    public Collection<usuario_grupo_rol> listarUsuariosGrupo(@WebParam(name = "grupousuarios") grupo idGrupo, @WebParam(name = "borrado") boolean borradoo) {

        return ugrFacade.listarUsuariosGrupo(idGrupo, borradoo);
    }

    /**
     * Método que devuelve una lista de los roles que existen por un grupo
     * determinado
     *
     * @param idGrupo objeto de la clase Grupo que contiene el identificador(id)
     * del grupo por el que se buscara los roles
     * @param borradoo booleano con el cual identifica si esta como no borrado
     * @return un objeto de la clase WR_rol que poseera la lista de los roles
     * que cumplan con los requerimientos y el resultado de la operación
     */
    @WebMethod(operationName = "listarRolesPorGrupo")
    public WR_rol listarRolesPorGrupo(@WebParam(name = "grupousuarios") grupo idGrupo, @WebParam(name = "borrado") boolean borradoo) {
        WR_rol Resultado = new WR_rol();
        Resultado = myValidador.validarListarRolesPorGrupo(idGrupo);
        if (Resultado.getEstatus().compareTo("OK") != 0) {
            return Resultado;
        }
        try {
            List<rol> Roles = ugrFacade.listarRolesPorGrupos(idGrupo, borradoo);
            for (int i = 0; i < Roles.size(); i++) {
                Resultado.ingresarRol(Roles.get(i));
            }
            //Resultado.setRols( (ArrayList<rol>) ugrFacade.listarRolesPorGrupos(idGrupo, borradoo));
            Resultado.setEstatus("OK");
        } catch (Exception e) {
            Resultado.setEstatus("Fail");
            Resultado.setObservacion(e.getMessage());
            System.out.print("*******************************************************************************");
            e.printStackTrace();
        }
        return Resultado;
    }

    /**
     * Método que devuelve una lista de la clase usuario_grupo_rol con los
     * usuarios que existen por un grupo y un por rol determinado
     *
     * @param idGrupo objeto de la clase Grupo que contiene el identificador(id)
     * del grupo por el que se buscara los usuarios
     * @param idRol objeto de la clase Rol que contiene el identificador(id) del
     * rol por el que se buscara los usuarios
     * @return un objeto de la clase WR_usuario_grupo_rol que poseera la lista
     * de usuarioGrupoRol que cumplan con los requerimientos y el resultado de
     * la operación
     */
    @WebMethod(operationName = "listarUsuariosPorGrupoYRol")
    public WR_usuario_grupo_rol listarUsuariosPorGrupoYRol(@WebParam(name = "grupousuarios") grupo idGrupo, @WebParam(name = "roles") rol idRol) {
        WR_usuario_grupo_rol Resultado = new WR_usuario_grupo_rol();
        Resultado = myValidador.ValidarListarUsuariosPorGrupoYRol(idGrupo, idRol);
        if (Resultado.getEstatus().compareTo("OK") != 0) {
            return Resultado;
        }
        try {
            List<usuario_grupo_rol> Lista = ugrFacade.listarUsuariosporGrupoyRol(idGrupo, idRol);
            for (int i = 0; i < Lista.size(); i++) {
                Resultado.ingresarUsuarioGrupoRol(Lista.get(i));
            }
            Resultado.setEstatus("OK");
        } catch (Exception e) {
            Resultado.setEstatus("Fail");
            Resultado.setObservacion(e.getMessage());
            System.out.print("*******************************************************************************");
            e.printStackTrace();
        }
        return Resultado;
    }
    
    
    /**
     * Método que inserta el grupo
     * @param registro
     */
    @WebMethod(operationName = "insertarGrupo")
    public void insertarGrupo(@WebParam(name = "registroGrupo") grupo registro) {
 
      grupoFacade.insertarGrupo(registro);
    }
    
    /**
     * Método que edita el grupo
     * @param registro
     */
    @WebMethod(operationName = "editarGrupo")
    public void editarGrupo(@WebParam(name = "registroGrupo") grupo registro) {
 
      grupoFacade.editarGrupo(registro);
    }
    
    /**
     * Método que elimina el grupo de manera lógica
     * @param ID
     */
    @WebMethod(operationName = "eliminarGrupo")
    public void eliminarGrupo(@WebParam(name = "idGrupo") String ID) {
 
      grupoFacade.eliminarGrupo(ID);
    }
}
