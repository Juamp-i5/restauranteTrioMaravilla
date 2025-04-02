/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import entidades.Ingrediente;
import entidades.enums.UnidadMedida;
import excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import interfaces.IIngredienteDAO;

/**
 *
 * @author norma
 */
public class IngredienteDAO implements IIngredienteDAO {

    @Override
    public Ingrediente persistirIngrediente(Ingrediente ingrediente) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ingrediente);
            em.getTransaction().commit();

            return ingrediente;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al persistir ingrediente", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean eliminarIngrediente(Long idIngrediente) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            em.getTransaction().begin();
            Ingrediente ingrediente = em.find(Ingrediente.class, idIngrediente);
            if (ingrediente != null) {
                em.remove(ingrediente);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar ingrediente", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Ingrediente obtenerIngredientePorId(Long idIngrediente) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            return em.find(Ingrediente.class, idIngrediente);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener ingrediente", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Ingrediente> obtenerIngredientes() throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la lista de ingredientes", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

    }

    @Override
    public List<Ingrediente> obtenerIngredientesDisponibles() throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.cantidadStock > 0", Ingrediente.class)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la lista de ingredientes disponibles", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean aumentarStock(Long idIngrediente, Integer cantidad) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            em.getTransaction().begin();
            Ingrediente ingrediente = em.find(Ingrediente.class, idIngrediente);
            if (ingrediente != null) {
                ingrediente.setCantidadStock(ingrediente.getCantidadStock() + cantidad);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al aumentar stock", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean reducirStock(Long idIngrediente, Integer cantidad) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            em.getTransaction().begin();
            Ingrediente ingrediente = em.find(Ingrediente.class, idIngrediente);
            if (ingrediente != null) {
                ingrediente.setCantidadStock(ingrediente.getCantidadStock() - cantidad);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al reducir stock", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Ingrediente> obtenerIngredientesPorNombre(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.nombre LIKE :nombre", Ingrediente.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener lista de ingredientes por nombre", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Ingrediente> obtenerIngredientesPorUnidadMedida(UnidadMedida unidadMedida) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.unidadMedida = :unidadMedida", Ingrediente.class)
                    .setParameter("unidadMedida", unidadMedida)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener lista de ingredientes por unidad de medida", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean comprobarExistenciaIngrediente(String nombre, UnidadMedida unidadMedida) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            Long count = em.createQuery(
                    "SELECT COUNT(i) FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidadMedida",
                    Long.class)
                    .setParameter("nombre", nombre)
                    .setParameter("unidadMedida", unidadMedida)
                    .getSingleResult();
            return count > 0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al comprobar la existencia del ingrediente", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

}
