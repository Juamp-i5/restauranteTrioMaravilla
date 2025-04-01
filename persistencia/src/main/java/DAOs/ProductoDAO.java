package DAOs;

import conexion.Conexion;
import entidades.IngredienteProducto;
import entidades.Producto;
import excepciones.PersistenciaException;
import interfaces.IProductoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProductoDAO implements IProductoDAO {

    @Override
    public Producto obtenerProducto(Long idProducto) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            return em.find(Producto.class, idProducto);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener producto con id#" + idProducto, e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Producto> obtenerProductos() throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Producto p", Producto.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener lista de productos", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Producto> obtenerProductosDisponibles() throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            Query query = em.createQuery("SELECT DISTINCT p FROM Producto p WHERE p.estado = 'HABILITADO' AND NOT EXISTS (SELECT i FROM p.ingredientesProducto i WHERE i.cantidad > i.ingrediente.cantidadStock)", Producto.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener lista de productos disponibles", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Boolean isProductoDisponible(Long idProducto) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(p) FROM Producto p WHERE p.id = :idProducto AND p.estado = 'HABILITADO' AND NOT EXISTS (SELECT i FROM p.ingredientesProducto i WHERE i.cantidad > i.ingrediente.cantidadStock)");
            return (Long) query.getSingleResult() > 0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener lista de productos disponibles", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Producto persistirProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();

            return producto;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al persistir producto", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void agregarIngredienteProducto(Producto producto, IngredienteProducto ingredienteProducto) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        producto.getIngredientesProducto().add(ingredienteProducto);
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al agregar IngredienteProducto a Producto", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
    public void eliminarIngredienteProducto(Producto producto, IngredienteProducto ingredienteProducto) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        producto.getIngredientesProducto().remove(ingredienteProducto);
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al agregar IngredienteProducto a Producto", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

}
