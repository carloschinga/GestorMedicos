/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dao;

import com.clinicasb.dao.exceptions.NonexistentEntityException;
import com.clinicasb.dao.exceptions.PreexistingEntityException;
import com.clinicasb.dto.EaResultadosImagenes;
import com.clinicasb.dto.EaResultadosImagenesPK;
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
public class EaResultadosImagenesJpaController implements Serializable {

    public EaResultadosImagenesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.clinicasb.persis");

    public EaResultadosImagenesJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EaResultadosImagenes eaResultadosImagenes) throws PreexistingEntityException, Exception {
        if (eaResultadosImagenes.getEaResultadosImagenesPK() == null) {
            eaResultadosImagenes.setEaResultadosImagenesPK(new EaResultadosImagenesPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(eaResultadosImagenes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEaResultadosImagenes(eaResultadosImagenes.getEaResultadosImagenesPK()) != null) {
                throw new PreexistingEntityException("EaResultadosImagenes " + eaResultadosImagenes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EaResultadosImagenes eaResultadosImagenes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            eaResultadosImagenes = em.merge(eaResultadosImagenes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EaResultadosImagenesPK id = eaResultadosImagenes.getEaResultadosImagenesPK();
                if (findEaResultadosImagenes(id) == null) {
                    throw new NonexistentEntityException("The eaResultadosImagenes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EaResultadosImagenesPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EaResultadosImagenes eaResultadosImagenes;
            try {
                eaResultadosImagenes = em.getReference(EaResultadosImagenes.class, id);
                eaResultadosImagenes.getEaResultadosImagenesPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eaResultadosImagenes with id " + id + " no longer exists.", enfe);
            }
            em.remove(eaResultadosImagenes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EaResultadosImagenes> findEaResultadosImagenesEntities() {
        return findEaResultadosImagenesEntities(true, -1, -1);
    }

    public List<EaResultadosImagenes> findEaResultadosImagenesEntities(int maxResults, int firstResult) {
        return findEaResultadosImagenesEntities(false, maxResults, firstResult);
    }

    private List<EaResultadosImagenes> findEaResultadosImagenesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EaResultadosImagenes.class));
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

    public EaResultadosImagenes findEaResultadosImagenes(EaResultadosImagenesPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EaResultadosImagenes.class, id);
        } finally {
            em.close();
        }
    }

    public int getEaResultadosImagenesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EaResultadosImagenes> rt = cq.from(EaResultadosImagenes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Integer getSigImg(int invnum, int numitm) {
        EntityManager em = getEntityManager();
        try {
            String sql = "SELECT COALESCE(MAX(numimg), 0) + 1 AS siguiente_numero FROM ea_resultados_imagenes WHERE invnum = '"+invnum+"' AND numitm = '"+numitm+"'";
            Query consultaNativa = em.createNativeQuery(sql);
            /*consultaNativa.setParameter("invnum", invnum);
            consultaNativa.setParameter("numitm", numitm);*/

            Integer resultado = (Integer) consultaNativa.getSingleResult();
            return resultado;
        } catch (Exception ex) {
            System.err.println("Error en obtenerSiguienteImagen: " + ex.getMessage());
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            EaResultadosImagenesJpaController eaDAO = new EaResultadosImagenesJpaController();
            Integer i = eaDAO.getSigImg(19595, 1);

            System.out.println(i);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
