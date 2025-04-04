package DAOs;

import Encriptador.Encriptador;
import conexion.Conexion;
import entidades.Cliente;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import excepciones.PersistenciaException;
import interfaces.IClienteDAO;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author pablo
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public Cliente obtenerClienteFrecuente(Long idClienteFrecuente) throws PersistenciaException {
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
    public List<ClienteFrecuente> obtenerClientesFrecuentes(){
        EntityManager em = Conexion.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ClienteFrecuente c", ClienteFrecuente.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de clientes frecuentes");
        } finally {
            em.close();
        }
        return null;
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

            ClienteFrecuente cliente = (ClienteFrecuente) em.find(Cliente.class, idCliente);
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

    @Override
    public List<Cliente> obtenerClientesFiltrados(String filtroNombre, String filtroCorreo, String filtroTelefono) throws PersistenciaException {
        EntityManager em = Conexion.getEntityManager();
        try {
            String queryString = "SELECT c FROM ClienteFrecuente c WHERE 1=1";
            if (!filtroNombre.isEmpty()) {
                queryString += " AND c.nombres LIKE :nombre";
            }
            Query query = em.createQuery(queryString, Cliente.class);

            if (!filtroNombre.isEmpty()) {
                query.setParameter("nombre", "%" + filtroNombre + "%");
            }
            List<Cliente> clientes = query.getResultList();
            return clientes.stream()
                    .filter(c -> (filtroCorreo.isEmpty() || desencriptar(c.getCorreoElectronico()).contains(filtroCorreo)))
                    .filter(c -> (filtroTelefono.isEmpty() || desencriptar(c.getTelefono()).contains(filtroTelefono)))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener clientes filtrados", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    private String desencriptar(String datoEncriptado) {
        try {
            return Encriptador.desencriptarBase64(datoEncriptado);
        } catch (Exception e) {
            return "";
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
