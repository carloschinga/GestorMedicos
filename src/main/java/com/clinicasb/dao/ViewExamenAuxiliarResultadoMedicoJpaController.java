/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewExamenAuxiliarResultadoMedico;
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
public class ViewExamenAuxiliarResultadoMedicoJpaController implements Serializable {

    public ViewExamenAuxiliarResultadoMedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ViewExamenAuxiliarResultadoMedicoJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewExamenAuxiliarResultadoMedico viewExamenAuxiliarResultadoMedico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewExamenAuxiliarResultadoMedico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewExamenAuxiliarResultadoMedico(viewExamenAuxiliarResultadoMedico.getSecuencia()) != null) {
                throw new PreexistingEntityException("ViewExamenAuxiliarResultadoMedico " + viewExamenAuxiliarResultadoMedico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewExamenAuxiliarResultadoMedico viewExamenAuxiliarResultadoMedico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewExamenAuxiliarResultadoMedico = em.merge(viewExamenAuxiliarResultadoMedico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewExamenAuxiliarResultadoMedico.getSecuencia();
                if (findViewExamenAuxiliarResultadoMedico(id) == null) {
                    throw new NonexistentEntityException("The viewExamenAuxiliarResultadoMedico with id " + id + " no longer exists.");
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
            ViewExamenAuxiliarResultadoMedico viewExamenAuxiliarResultadoMedico;
            try {
                viewExamenAuxiliarResultadoMedico = em.getReference(ViewExamenAuxiliarResultadoMedico.class, id);
                viewExamenAuxiliarResultadoMedico.getSecuencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewExamenAuxiliarResultadoMedico with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewExamenAuxiliarResultadoMedico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewExamenAuxiliarResultadoMedico> findViewExamenAuxiliarResultadoMedicoEntities() {
        return findViewExamenAuxiliarResultadoMedicoEntities(true, -1, -1);
    }

    public List<ViewExamenAuxiliarResultadoMedico> findViewExamenAuxiliarResultadoMedicoEntities(int maxResults, int firstResult) {
        return findViewExamenAuxiliarResultadoMedicoEntities(false, maxResults, firstResult);
    }

    private List<ViewExamenAuxiliarResultadoMedico> findViewExamenAuxiliarResultadoMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewExamenAuxiliarResultadoMedico.class));
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

    public ViewExamenAuxiliarResultadoMedico findViewExamenAuxiliarResultadoMedico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewExamenAuxiliarResultadoMedico.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewExamenAuxiliarResultadoMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewExamenAuxiliarResultadoMedico> rt = cq.from(ViewExamenAuxiliarResultadoMedico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<ViewExamenAuxiliarResultadoMedico> listar(Date startDate, Date endDate, String medcod) {
        EntityManager em = getEntityManager();
        try {            
            Query q = em.createNamedQuery("ViewExamenAuxiliarResultadoMedico.findByFechaFiltroBeetwen");
            q.setParameter("medcod", medcod);
            q.setParameter("startDate", startDate);
            q.setParameter("endDate", endDate);
            List<ViewExamenAuxiliarResultadoMedico> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        }
    }

}
