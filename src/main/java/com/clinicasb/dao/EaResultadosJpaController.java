/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.EaResultados;
import com.clinicasb.dto.EaResultadosPK;
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
public class EaResultadosJpaController implements Serializable {

    public EaResultadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public EaResultadosJpaController() {
    }

    public void create(EaResultados eaResultados) throws PreexistingEntityException, Exception {
        if (eaResultados.getEaResultadosPK() == null) {
            eaResultados.setEaResultadosPK(new EaResultadosPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(eaResultados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEaResultados(eaResultados.getEaResultadosPK()) != null) {
                throw new PreexistingEntityException("EaResultados " + eaResultados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EaResultados eaResultados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            eaResultados = em.merge(eaResultados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EaResultadosPK id = eaResultados.getEaResultadosPK();
                if (findEaResultados(id) == null) {
                    throw new NonexistentEntityException("The eaResultados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EaResultadosPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EaResultados eaResultados;
            try {
                eaResultados = em.getReference(EaResultados.class, id);
                eaResultados.getEaResultadosPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eaResultados with id " + id + " no longer exists.", enfe);
            }
            em.remove(eaResultados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EaResultados> findEaResultadosEntities() {
        return findEaResultadosEntities(true, -1, -1);
    }

    public List<EaResultados> findEaResultadosEntities(int maxResults, int firstResult) {
        return findEaResultadosEntities(false, maxResults, firstResult);
    }

    private List<EaResultados> findEaResultadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EaResultados.class));
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

    public EaResultados findEaResultados(EaResultadosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EaResultados.class, id);
        } finally {
            em.close();
        }
    }

    public int getEaResultadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EaResultados> rt = cq.from(EaResultados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
