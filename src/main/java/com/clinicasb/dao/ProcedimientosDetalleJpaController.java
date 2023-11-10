/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ProcedimientosDetalle;
import com.clinicasb.dto.ProcedimientosDetallePK;
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
public class ProcedimientosDetalleJpaController implements Serializable {

    public ProcedimientosDetalleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ProcedimientosDetalleJpaController() {
    }


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProcedimientosDetalle procedimientosDetalle) throws PreexistingEntityException, Exception {
        if (procedimientosDetalle.getProcedimientosDetallePK() == null) {
            procedimientosDetalle.setProcedimientosDetallePK(new ProcedimientosDetallePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(procedimientosDetalle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProcedimientosDetalle(procedimientosDetalle.getProcedimientosDetallePK()) != null) {
                throw new PreexistingEntityException("ProcedimientosDetalle " + procedimientosDetalle + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProcedimientosDetalle procedimientosDetalle) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            procedimientosDetalle = em.merge(procedimientosDetalle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ProcedimientosDetallePK id = procedimientosDetalle.getProcedimientosDetallePK();
                if (findProcedimientosDetalle(id) == null) {
                    throw new NonexistentEntityException("The procedimientosDetalle with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ProcedimientosDetallePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProcedimientosDetalle procedimientosDetalle;
            try {
                procedimientosDetalle = em.getReference(ProcedimientosDetalle.class, id);
                procedimientosDetalle.getProcedimientosDetallePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The procedimientosDetalle with id " + id + " no longer exists.", enfe);
            }
            em.remove(procedimientosDetalle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProcedimientosDetalle> findProcedimientosDetalleEntities() {
        return findProcedimientosDetalleEntities(true, -1, -1);
    }

    public List<ProcedimientosDetalle> findProcedimientosDetalleEntities(int maxResults, int firstResult) {
        return findProcedimientosDetalleEntities(false, maxResults, firstResult);
    }

    private List<ProcedimientosDetalle> findProcedimientosDetalleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProcedimientosDetalle.class));
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

    public ProcedimientosDetalle findProcedimientosDetalle(ProcedimientosDetallePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProcedimientosDetalle.class, id);
        } finally {
            em.close();
        }
    }

    public int getProcedimientosDetalleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProcedimientosDetalle> rt = cq.from(ProcedimientosDetalle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
