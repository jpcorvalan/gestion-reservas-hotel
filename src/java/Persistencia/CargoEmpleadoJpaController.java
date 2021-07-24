/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.CargoEmpleado;
import Persistencia.exceptions.NonexistentEntityException;
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
 * @author Gold
 */
public class CargoEmpleadoJpaController implements Serializable {

    public CargoEmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public CargoEmpleadoJpaController(){
        emf = Persistence.createEntityManagerFactory("ReservasPU");
    }

    public void create(CargoEmpleado cargoEmpleado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cargoEmpleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CargoEmpleado cargoEmpleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cargoEmpleado = em.merge(cargoEmpleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cargoEmpleado.getId();
                if (findCargoEmpleado(id) == null) {
                    throw new NonexistentEntityException("The cargoEmpleado with id " + id + " no longer exists.");
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
            CargoEmpleado cargoEmpleado;
            try {
                cargoEmpleado = em.getReference(CargoEmpleado.class, id);
                cargoEmpleado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargoEmpleado with id " + id + " no longer exists.", enfe);
            }
            em.remove(cargoEmpleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CargoEmpleado> findCargoEmpleadoEntities() {
        return findCargoEmpleadoEntities(true, -1, -1);
    }

    public List<CargoEmpleado> findCargoEmpleadoEntities(int maxResults, int firstResult) {
        return findCargoEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<CargoEmpleado> findCargoEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CargoEmpleado.class));
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

    public CargoEmpleado findCargoEmpleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CargoEmpleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargoEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CargoEmpleado> rt = cq.from(CargoEmpleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
