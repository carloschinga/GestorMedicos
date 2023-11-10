/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewExamenAuxiliar;
import java.io.Serializable;
import java.util.Date;
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
public class ViewExamenAuxiliarJpaController implements Serializable {

    public ViewExamenAuxiliarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ViewExamenAuxiliarJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewExamenAuxiliar viewExamenAuxiliar) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewExamenAuxiliar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewExamenAuxiliar(viewExamenAuxiliar.getSecuencia()) != null) {
                throw new PreexistingEntityException("ViewExamenAuxiliar " + viewExamenAuxiliar + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewExamenAuxiliar viewExamenAuxiliar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewExamenAuxiliar = em.merge(viewExamenAuxiliar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewExamenAuxiliar.getSecuencia();
                if (findViewExamenAuxiliar(id) == null) {
                    throw new NonexistentEntityException("The viewExamenAuxiliar with id " + id + " no longer exists.");
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
            ViewExamenAuxiliar viewExamenAuxiliar;
            try {
                viewExamenAuxiliar = em.getReference(ViewExamenAuxiliar.class, id);
                viewExamenAuxiliar.getSecuencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewExamenAuxiliar with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewExamenAuxiliar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewExamenAuxiliar> findViewExamenAuxiliarEntities() {
        return findViewExamenAuxiliarEntities(true, -1, -1);
    }

    public List<ViewExamenAuxiliar> findViewExamenAuxiliarEntities(int maxResults, int firstResult) {
        return findViewExamenAuxiliarEntities(false, maxResults, firstResult);
    }

    private List<ViewExamenAuxiliar> findViewExamenAuxiliarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewExamenAuxiliar.class));
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

    public ViewExamenAuxiliar findViewExamenAuxiliar(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewExamenAuxiliar.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewExamenAuxiliarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewExamenAuxiliar> rt = cq.from(ViewExamenAuxiliar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    } public List<ViewExamenAuxiliar> listar(Date startDate, Date endDate, String medcod) {
        EntityManager em = getEntityManager();
        try {            
            Query q = em.createNamedQuery("ViewExamenAuxiliar.findByFechaFiltroBeetwen");
            q.setParameter("medcod", medcod);
            q.setParameter("startDate", startDate);
            q.setParameter("endDate", endDate);
            List<ViewExamenAuxiliar> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        }
    }
    
}
