/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewTrazabilidadProcedimiento;
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
public class ViewTrazabilidadProcedimientoJpaController implements Serializable {

    public ViewTrazabilidadProcedimientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ViewTrazabilidadProcedimientoJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewTrazabilidadProcedimiento viewTrazabilidadProcedimiento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewTrazabilidadProcedimiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewTrazabilidadProcedimiento(viewTrazabilidadProcedimiento.getSecuencia()) != null) {
                throw new PreexistingEntityException("ViewTrazabilidadProcedimiento " + viewTrazabilidadProcedimiento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewTrazabilidadProcedimiento viewTrazabilidadProcedimiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewTrazabilidadProcedimiento = em.merge(viewTrazabilidadProcedimiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewTrazabilidadProcedimiento.getSecuencia();
                if (findViewTrazabilidadProcedimiento(id) == null) {
                    throw new NonexistentEntityException("The viewTrazabilidadProcedimiento with id " + id + " no longer exists.");
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
            ViewTrazabilidadProcedimiento viewTrazabilidadProcedimiento;
            try {
                viewTrazabilidadProcedimiento = em.getReference(ViewTrazabilidadProcedimiento.class, id);
                viewTrazabilidadProcedimiento.getSecuencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewTrazabilidadProcedimiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewTrazabilidadProcedimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewTrazabilidadProcedimiento> findViewTrazabilidadProcedimientoEntities() {
        return findViewTrazabilidadProcedimientoEntities(true, -1, -1);
    }

    public List<ViewTrazabilidadProcedimiento> findViewTrazabilidadProcedimientoEntities(int maxResults, int firstResult) {
        return findViewTrazabilidadProcedimientoEntities(false, maxResults, firstResult);
    }

    private List<ViewTrazabilidadProcedimiento> findViewTrazabilidadProcedimientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewTrazabilidadProcedimiento.class));
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

    public ViewTrazabilidadProcedimiento findViewTrazabilidadProcedimiento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewTrazabilidadProcedimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewTrazabilidadProcedimientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewTrazabilidadProcedimiento> rt = cq.from(ViewTrazabilidadProcedimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<ViewTrazabilidadProcedimiento> listar(Date startDate, Date endDate) {
        EntityManager em = getEntityManager();
        try {

            Query q = em.createNamedQuery("ViewTrazabilidadLa.findByFechaFiltroBeetwen");
            q.setParameter("startDate", startDate);
            q.setParameter("endDate", endDate);
            List<ViewTrazabilidadProcedimiento> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        } finally {
            em.close();
        }
    }

}
