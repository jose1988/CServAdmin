/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.capadeservicios.beans;

import com.pangea.capadeservicios.clienteweb.Usuario;
import com.pangea.capadeservicios.entidades.usuario;
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
public class usuarioFacade extends AbstractFacade<usuario> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public usuarioFacade() {
        super(usuario.class);
    }

    public List<usuario> listarUsuarios(boolean borrado) {
        List<usuario> lista;
        lista = em.createNamedQuery("usuario.findByBorrado").setParameter("borrado", borrado).getResultList();
        return lista;
    }

    public List<usuario> listar() {
        List<usuario> c = null;

        c = (List<usuario>) em.createNamedQuery("usuario.findAll").getResultList();
        return c;
    }

    public void insertar(usuario registro) {

        this.create(registro);

    }

    public void editar(usuario registro) {

        this.edit(registro);

    }

    public void eliminar(String ID) {
        Query q = em.createNativeQuery("UPDATE usuario SET borrado='true' WHERE id=?");
        q.setParameter(1, ID);
        q.executeUpdate();
    }
      public usuario consultarUsuario(String idUsuario) {
        usuario Registro;
        Registro=this.find(idUsuario);
        return Registro;
    }
}
