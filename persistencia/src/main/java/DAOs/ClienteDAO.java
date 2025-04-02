package DAOs;

import conexion.Conexion;
import entidades.Cliente;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

/**
 *
 * @author pablo
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public ClienteFrecuente obtenerClienteFrecuente(Long idClienteFrecuente) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            return em.find(ClienteFrecuente.class, idClienteFrecuente);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el cliente frecuente por ID", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<ClienteFrecuente> obtenerClientesFrecuentesPorNombre(String nombreCliente) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            List<ClienteFrecuente> lista = em.createQuery("SELECT c FROM ClienteFrecuente c WHERE c.nombres = :nombre", ClienteFrecuente.class)
                    .setParameter("nombre", nombreCliente)
                    .getResultList();
            return lista;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el cliente frecuente por nombre", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<ClienteFrecuente> obtenerClientesFrecuentesPorCorreo(String CorreoCliente) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            List<ClienteFrecuente> lista = em.createQuery("SELECT c FROM ClienteFrecuente c WHERE c.correoElectronico = :correo", ClienteFrecuente.class)
                    .setParameter("correo", CorreoCliente)
                    .getResultList();
            return lista;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el cliente frecuente por correo", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<ClienteFrecuente> obtenerClienteFrecuentePorTelefono(String TelefonoCliente) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            List<ClienteFrecuente> lista = em.createQuery("SELECT c FROM ClienteFrecuente c WHERE c.telefono = :telefono", ClienteFrecuente.class)
                    .setParameter("telefono", TelefonoCliente)
                    .getResultList();
            System.out.println(lista);
            return lista;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el cliente frecuente por telefono", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<ClienteFrecuente> obtenerClientesFrecuentes() throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ClienteFrecuente c", ClienteFrecuente.class)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la lista de clientes frecuentes", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Cliente persistirCliente(Cliente cliente) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();

            return cliente;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al persistir el cliente", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void asignarComandaACliente(Long idComanda, Long idCliente) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, idCliente);
            if (cliente == null) {
                throw new PersistenciaException("Cliente con ID " + idCliente + " no encontrado.");
            }

            Comanda comanda = em.find(Comanda.class, idComanda);
            if (comanda == null) {
                throw new PersistenciaException("Comanda con ID " + idComanda + " no encontrada.");
            }

            if (comanda.getCliente() != null) {
                throw new PersistenciaException("La comanda ya está asignada a un cliente.");
            }

            comanda.setCliente(cliente);
            em.merge(comanda);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al asignar la comanda al cliente.", e);
        } finally {
            em.close();
        }
    }

//    @Override
//    public ClienteFrecuente calcularHistorialCliente(Long idCliente) throws PersistenciaException {
//        ClienteFrecuente cliente = obtenerClienteFrecuente(idCliente);
//        if (cliente == null) {
//            throw new PersistenciaException("Cliente no encontrado");
//        }
//
//        List<Comanda> historialCompras = cliente.getComandas();
//        int totalVisitas = historialCompras.size();
//        double gastoTotal = historialCompras.stream().mapToDouble(Comanda::getTotal).sum();
//        int puntosFidelidad = (int) (gastoTotal / 20);
//        
//        cliente.setVisitas(totalVisitas);
//        cliente.getTotalGastado(gastoTotal);
//        cliente.setPuntosFidelidad(puntosFidelidad);
//
//        return cliente;
//    }
}
