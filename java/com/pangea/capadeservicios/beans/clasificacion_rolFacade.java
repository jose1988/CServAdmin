/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.entidades.clasificacion_rol;
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
public class clasificacion_rolFacade extends AbstractFacade<clasificacion_rol> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public clasificacion_rolFacade() {
        super(clasificacion_rol.class);
    }

    public List<clasificacion_rol> listarClasifRol(boolean borrado) {
        List<clasificacion_rol> c = null;
        c = (List<clasificacion_rol>) em.createNamedQuery("clasificacion_rol.findByBorrado").setParameter("borrado", borrado).getResultList();
        return c;
    }

    public void insertar(clasificacion_rol registro) {
        this.create(registro);
    }

    public void editar(clasificacion_rol Registro) {
        Query q = em.createNativeQuery("UPDATE clasificacion_rol SET borrado=?,descripcion=?,fecha_modificacion=?,nombre=? WHERE id=?");
        System.out.println("fecha..........."+Registro.getFechaModificacion().toString());
        q.setParameter(1, Registro.getBorrado());
        q.setParameter(2, Registro.getDescripcion());
        q.setParameter(3, Registro.getFechaModificacion());
        q.setParameter(4, Registro.getNombre());
        q.setParameter(5, Registro.getId());
        q.executeUpdate();
    }

    public void eliminar(String ID) {
        Query q = em.createNativeQuery("UPDATE clasificacion_rol SET borrado='true' WHERE id=?");
        q.setParameter(1,Long.parseLong(ID));
        q.executeUpdate();
    }

    public clasificacion_rol consultarClasifRol(long idClasifRol) {
        clasificacion_rol Registro;
        Registro = this.find(idClasifRol);
        return Registro;
    }

    public clasificacion_rol consultarClasifRolXnombre(String Nombre) {
        clasificacion_rol Registro;
        Registro = (clasificacion_rol) em.createNamedQuery("clasificacion_rol.findByNombre").setParameter("nombre", Nombre).getSingleResult();
        return Registro;
    }
}
