/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.ViewWebMenuDeta;
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
public class ViewWebMenuDetaJpaController implements Serializable {

    public ViewWebMenuDetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ViewWebMenuDetaJpaController() {
    }

    public void create(ViewWebMenuDeta viewWebMenuDeta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewWebMenuDeta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewWebMenuDeta(viewWebMenuDeta.getCodmen()) != null) {
                throw new PreexistingEntityException("ViewWebMenuDeta " + viewWebMenuDeta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewWebMenuDeta viewWebMenuDeta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewWebMenuDeta = em.merge(viewWebMenuDeta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewWebMenuDeta.getCodmen();
                if (findViewWebMenuDeta(id) == null) {
                    throw new NonexistentEntityException("The viewWebMenuDeta with id " + id + " no longer exists.");
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
            ViewWebMenuDeta viewWebMenuDeta;
            try {
                viewWebMenuDeta = em.getReference(ViewWebMenuDeta.class, id);
                viewWebMenuDeta.getCodmen();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewWebMenuDeta with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewWebMenuDeta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public List<ViewWebMenuDeta> listarMenuXUsua(int usecod) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("ViewWebMenuDeta.listarXUsecod");
            q.setParameter("usecod", usecod);
          
            List<ViewWebMenuDeta> lista = q.getResultList();
            return lista;
        
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewWebMenuDeta> findViewWebMenuDetaEntities() {
        return findViewWebMenuDetaEntities(true, -1, -1);
    }

    public List<ViewWebMenuDeta> findViewWebMenuDetaEntities(int maxResults, int firstResult) {
        return findViewWebMenuDetaEntities(false, maxResults, firstResult);
    }

    private List<ViewWebMenuDeta> findViewWebMenuDetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewWebMenuDeta.class));
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

    public ViewWebMenuDeta findViewWebMenuDeta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewWebMenuDeta.class, id);
        } finally {
            em.close();
        }
    }
      public ViewWebMenuDeta buscarXCodigoYUseCod(int Codi, int usecod) {
        EntityManager em = getEntityManager();
        try {            
            Query q = em.createNamedQuery("ViewWebMenuDeta.findByCodmenYUsecod");
            q.setParameter("codmen", Codi);
            q.setParameter("usecod", usecod);
            ViewWebMenuDeta v=(ViewWebMenuDeta) q.getSingleResult();
            return v;        
        } catch (Exception e) {
            return null;
        }
    }

    public int getViewWebMenuDetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewWebMenuDeta> rt = cq.from(ViewWebMenuDeta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public  List<ViewWebMenuDeta> listarXCodRol(int codRol) {
        EntityManager em = getEntityManager();
        try {            
            Query q = em.createNamedQuery("ViewWebMenuDeta.findByCodrol");
            q.setParameter("codrol", codRol);            
            List<ViewWebMenuDeta> lista=q.getResultList();
            return lista;
        
        } catch (Exception e) {
            
            return null;
        }finally {
            em.close();
        }
    }
    
   
    public static void main(String[] args) {
        ViewWebMenuDetaJpaController dao= new ViewWebMenuDetaJpaController();
        List<ViewWebMenuDeta> lista=dao.listarXCodRol(1);
        System.out.println(lista.size());
                
    }
    
    
    
}
