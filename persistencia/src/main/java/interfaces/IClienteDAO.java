package interfaces;

import entidades.Cliente;
import entidades.ClienteFrecuente;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IClienteDAO {
    public Cliente obtenerClienteFrecuente(Long idClienteFrecuente) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerClientesFrecuentesPorNombre(String nombreCliente) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerClientesFrecuentesPorCorreo(String CorreoCliente) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerClienteFrecuentePorTelefono(String TelefonoCliente) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerClientesFrecuentes() throws PersistenciaException;
    
    public Cliente persistirCliente(Cliente cliente) throws PersistenciaException;
    
    public void asignarComandaACliente(Long idComanda, Long idCliente) throws PersistenciaException;
    
    public List<Cliente> obtenerClientesFiltrados(String filtroNombre, String filtroCorreo, String filtroTelefono) throws PersistenciaException;
    
//    public ClienteFrecuente calcularHistorialCliente(Long idCliente) throws PersistenciaException;
}
