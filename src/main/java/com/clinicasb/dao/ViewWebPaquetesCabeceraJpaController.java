/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewWebPaquetesCabecera;
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
public class ViewWebPaquetesCabeceraJpaController implements Serializable {

    public ViewWebPaquetesCabeceraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ViewWebPaquetesCabeceraJpaController() {
    }

    public void create(ViewWebPaquetesCabecera viewWebPaquetesCabecera) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewWebPaquetesCabecera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewWebPaquetesCabecera(viewWebPaquetesCabecera.getInvnum()) != null) {
                throw new PreexistingEntityException("ViewWebPaquetesCabecera " + viewWebPaquetesCabecera + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewWebPaquetesCabecera viewWebPaquetesCabecera) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewWebPaquetesCabecera = em.merge(viewWebPaquetesCabecera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewWebPaquetesCabecera.getInvnum();
                if (findViewWebPaquetesCabecera(id) == null) {
                    throw new NonexistentEntityException("The viewWebPaquetesCabecera with id " + id + " no longer exists.");
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
            ViewWebPaquetesCabecera viewWebPaquetesCabecera;
            try {
                viewWebPaquetesCabecera = em.getReference(ViewWebPaquetesCabecera.class, id);
                viewWebPaquetesCabecera.getInvnum();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewWebPaquetesCabecera with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewWebPaquetesCabecera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewWebPaquetesCabecera> findViewWebPaquetesCabeceraEntities() {
        return findViewWebPaquetesCabeceraEntities(true, -1, -1);
    }

    public List<ViewWebPaquetesCabecera> findViewWebPaquetesCabeceraEntities(int maxResults, int firstResult) {
        return findViewWebPaquetesCabeceraEntities(false, maxResults, firstResult);
    }

    private List<ViewWebPaquetesCabecera> findViewWebPaquetesCabeceraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewWebPaquetesCabecera.class));
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

    public ViewWebPaquetesCabecera findViewWebPaquetesCabecera(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewWebPaquetesCabecera.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewWebPaquetesCabeceraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewWebPaquetesCabecera> rt = cq.from(ViewWebPaquetesCabecera.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public  List<ViewWebPaquetesCabecera> listar(Date startDate, Date endDate) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("ViewWebPaquetesCabecera.findByFechaFiltroBeetwen");
            q.setParameter("startDate", startDate);
            q.setParameter("endDate", endDate);
            List<ViewWebPaquetesCabecera> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        }finally {
            em.close();
        }
    
    }
    
}
