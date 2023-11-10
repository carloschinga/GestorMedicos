/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewWebMenuDetaRol;
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
public class ViewWebMenuDetaRolJpaController implements Serializable {

    public ViewWebMenuDetaRolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");    

    public ViewWebMenuDetaRolJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewWebMenuDetaRol viewWebMenuDetaRol) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewWebMenuDetaRol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewWebMenuDetaRol(viewWebMenuDetaRol.getCodmen()) != null) {
                throw new PreexistingEntityException("ViewWebMenuDetaRol " + viewWebMenuDetaRol + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewWebMenuDetaRol viewWebMenuDetaRol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewWebMenuDetaRol = em.merge(viewWebMenuDetaRol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewWebMenuDetaRol.getCodmen();
                if (findViewWebMenuDetaRol(id) == null) {
                    throw new NonexistentEntityException("The viewWebMenuDetaRol with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewWebMenuDetaRol viewWebMenuDetaRol;
            try {
                viewWebMenuDetaRol = em.getReference(ViewWebMenuDetaRol.class, id);
                viewWebMenuDetaRol.getCodmen();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewWebMenuDetaRol with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewWebMenuDetaRol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewWebMenuDetaRol> findViewWebMenuDetaRolEntities() {
        return findViewWebMenuDetaRolEntities(true, -1, -1);
    }

    public List<ViewWebMenuDetaRol> findViewWebMenuDetaRolEntities(int maxResults, int firstResult) {
        return findViewWebMenuDetaRolEntities(false, maxResults, firstResult);
    }

    private List<ViewWebMenuDetaRol> findViewWebMenuDetaRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewWebMenuDetaRol.class));
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

    public ViewWebMenuDetaRol findViewWebMenuDetaRol(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewWebMenuDetaRol.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewWebMenuDetaRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewWebMenuDetaRol> rt = cq.from(ViewWebMenuDetaRol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public  List<ViewWebMenuDetaRol> listarXCodRol(int codRol) {
        EntityManager em = getEntityManager();
        try {            
            Query q = em.createNamedQuery("ViewWebMenuDetaRol.findByCodrol");
            q.setParameter("codrol", codRol);            
            List<ViewWebMenuDetaRol> lista=q.getResultList();
            return lista;
        
        } catch (Exception e) {
            
            return null;
        }finally {
            em.close();
        }
    }
}
