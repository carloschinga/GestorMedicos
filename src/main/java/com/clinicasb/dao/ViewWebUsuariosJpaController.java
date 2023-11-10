/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewWebUsuarios;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USUARIO
 */
public class ViewWebUsuariosJpaController implements Serializable {

    public ViewWebUsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ViewWebUsuariosJpaController() {
    }

    
    public void create(ViewWebUsuarios viewWebUsuarios) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewWebUsuarios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewWebUsuarios(viewWebUsuarios.getUsecod()) != null) {
                throw new PreexistingEntityException("ViewWebUsuarios " + viewWebUsuarios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewWebUsuarios viewWebUsuarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewWebUsuarios = em.merge(viewWebUsuarios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewWebUsuarios.getUsecod();
                if (findViewWebUsuarios(id) == null) {
                    throw new NonexistentEntityException("The viewWebUsuarios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewWebUsuarios viewWebUsuarios;
            try {
                viewWebUsuarios = em.getReference(ViewWebUsuarios.class, id);
                viewWebUsuarios.getUsecod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewWebUsuarios with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewWebUsuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewWebUsuarios> findViewWebUsuariosEntities() {
        return findViewWebUsuariosEntities(true, -1, -1);
    }

    public List<ViewWebUsuarios> findViewWebUsuariosEntities(int maxResults, int firstResult) {
        return findViewWebUsuariosEntities(false, maxResults, firstResult);
    }

    private List<ViewWebUsuarios> findViewWebUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewWebUsuarios.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ViewWebUsuarios findViewWebUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewWebUsuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewWebUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewWebUsuarios> rt = cq.from(ViewWebUsuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
