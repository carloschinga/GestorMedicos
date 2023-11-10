/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewWebPaquetesDetalle;
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
public class ViewWebPaquetesDetalleJpaController implements Serializable {

    public ViewWebPaquetesDetalleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public ViewWebPaquetesDetalleJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewWebPaquetesDetalle viewWebPaquetesDetalle) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewWebPaquetesDetalle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewWebPaquetesDetalle(viewWebPaquetesDetalle.getInvnum()) != null) {
                throw new PreexistingEntityException("ViewWebPaquetesDetalle " + viewWebPaquetesDetalle + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewWebPaquetesDetalle viewWebPaquetesDetalle) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewWebPaquetesDetalle = em.merge(viewWebPaquetesDetalle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewWebPaquetesDetalle.getInvnum();
                if (findViewWebPaquetesDetalle(id) == null) {
                    throw new NonexistentEntityException("The viewWebPaquetesDetalle with id " + id + " no longer exists.");
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
            ViewWebPaquetesDetalle viewWebPaquetesDetalle;
            try {
                viewWebPaquetesDetalle = em.getReference(ViewWebPaquetesDetalle.class, id);
                viewWebPaquetesDetalle.getInvnum();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewWebPaquetesDetalle with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewWebPaquetesDetalle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewWebPaquetesDetalle> findViewWebPaquetesDetalleEntities() {
        return findViewWebPaquetesDetalleEntities(true, -1, -1);
    }

    public List<ViewWebPaquetesDetalle> findViewWebPaquetesDetalleEntities(int maxResults, int firstResult) {
        return findViewWebPaquetesDetalleEntities(false, maxResults, firstResult);
    }

    private List<ViewWebPaquetesDetalle> findViewWebPaquetesDetalleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewWebPaquetesDetalle.class));
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

    public ViewWebPaquetesDetalle findViewWebPaquetesDetalle(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewWebPaquetesDetalle.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewWebPaquetesDetalleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewWebPaquetesDetalle> rt = cq.from(ViewWebPaquetesDetalle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public  List<ViewWebPaquetesDetalle> listar(int invnum) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("ViewWebPaquetesDetalle.findByInvnum");
            q.setParameter("invnum", invnum);
            List<ViewWebPaquetesDetalle> lista = q.getResultList();
            return lista;
        } catch (Exception ex) {
            System.out.println("Errorr en listar");
            return null;
        }finally {
            em.close();
        }
    
    }

    public static void main(String[] args) {
        ViewWebPaquetesDetalleJpaController dao= new ViewWebPaquetesDetalleJpaController();
        List<ViewWebPaquetesDetalle> lista=  dao.listar(247);
        System.out.println(lista.size());
    }
}
