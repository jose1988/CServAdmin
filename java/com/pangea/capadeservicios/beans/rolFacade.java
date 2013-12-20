/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pangea
 */
@Stateless
public class rolFacade extends AbstractFacade<rol> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public rolFacade() {
        super(rol.class);
    }

    public List<rol> listarRol(boolean borrado) {
        List<rol> listaRol = null;
        listaRol = (List<rol>) em.createNamedQuery("rol.findByBorrado").setParameter("borrado", borrado).getResultList();
        return listaRol;
    }

    public void insertar(rol registro) {
        this.create(registro);
    }

    public void editar(rol Registro) {
        Query q = em.createNativeQuery("UPDATE rol SET borrado=?,descripcion=?,documentacion=?,estado=?,id_clasificacion_rol=?,nombre=? WHERE id=?");
        q.setParameter(1, Registro.getBorrado());
        q.setParameter(2, Registro.getDescripcion());
        q.setParameter(3, Registro.getDocumentacion());
        q.setParameter(4, Registro.getEstado());
        q.setParameter(5, Registro.getIdClasificacionRol().getId());
        q.setParameter(6, Registro.getNombre());
        q.setParameter(7, Registro.getId());
        q.executeUpdate();
    }

    public void eliminar(String ID) {
        Query q = em.createNativeQuery("UPDATE rol SET borrado='true' WHERE id=?");
        q.setParameter(1, Long.parseLong(ID));
        q.executeUpdate();
    }

    public rol consultarRol(long idRol) {
        rol Registro;
        Registro = this.find(idRol);
        return Registro;
    }

    public rol consultarRolXnombre(String nombreRol) {
        rol Registro;
        Registro = (rol) em.createNamedQuery("rol.findByNombre").setParameter("nombre", nombreRol).getSingleResult();
        return Registro;
    }
}
