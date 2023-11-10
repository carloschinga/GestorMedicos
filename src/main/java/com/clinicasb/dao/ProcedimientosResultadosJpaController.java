/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ProcedimientosResultados;
import com.clinicasb.dto.ProcedimientosResultadosPK;
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
public class ProcedimientosResultadosJpaController implements Serializable {

    public ProcedimientosResultadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ProcedimientosResultadosJpaController() {
    }

    public void create(ProcedimientosResultados procedimientosResultados) throws PreexistingEntityException, Exception {
        if (procedimientosResultados.getProcedimientosResultadosPK() == null) {
            procedimientosResultados.setProcedimientosResultadosPK(new ProcedimientosResultadosPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(procedimientosResultados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProcedimientosResultados(procedimientosResultados.getProcedimientosResultadosPK()) != null) {
                throw new PreexistingEntityException("ProcedimientosResultados " + procedimientosResultados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProcedimientosResultados procedimientosResultados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            procedimientosResultados = em.merge(procedimientosResultados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ProcedimientosResultadosPK id = procedimientosResultados.getProcedimientosResultadosPK();
                if (findProcedimientosResultados(id) == null) {
                    throw new NonexistentEntityException("The procedimientosResultados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ProcedimientosResultadosPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProcedimientosResultados procedimientosResultados;
            try {
                procedimientosResultados = em.getReference(ProcedimientosResultados.class, id);
                procedimientosResultados.getProcedimientosResultadosPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The procedimientosResultados with id " + id + " no longer exists.", enfe);
            }
            em.remove(procedimientosResultados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProcedimientosResultados> findProcedimientosResultadosEntities() {
        return findProcedimientosResultadosEntities(true, -1, -1);
    }

    public List<ProcedimientosResultados> findProcedimientosResultadosEntities(int maxResults, int firstResult) {
        return findProcedimientosResultadosEntities(false, maxResults, firstResult);
    }

    private List<ProcedimientosResultados> findProcedimientosResultadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProcedimientosResultados.class));
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

    public ProcedimientosResultados findProcedimientosResultados(ProcedimientosResultadosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProcedimientosResultados.class, id);
        } finally {
            em.close();
        }
    }

    public int getProcedimientosResultadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProcedimientosResultados> rt = cq.from(ProcedimientosResultados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) throws Exception {
        
        

    }

}
