package DAOs;

import DTOs.salida.MostrarMesaDTO;
import conexion.Conexion;
import entidades.Mesa;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MesaDAO implements IMesaDAO {

    @Override
    public Mesa persistirMesa(Mesa mesa) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mesa);
            em.getTransaction().commit();

            return mesa;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al persistir mesa", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<MostrarMesaDTO> obtenerMesasDisponibles() throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            Query query = em.createQuery("SELECT new DTOs.salida.MostrarMesaDTO(m.id, m.nombre) FROM Mesa m WHERE m.disponible = true", MostrarMesaDTO.class);

            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener mesas disponibles", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
