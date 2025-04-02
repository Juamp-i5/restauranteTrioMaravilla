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
    public ClienteFrecuente obtenerClienteFrecuente(Long idClienteFrecuente) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerClienteFrecuentePorNombre(String nombreCliente) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerClienteFrecuentePorCorreo(String CorreoCliente) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerClienteFrecuentePorTelefono(String TelefonoCliente) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerClientesFrecuentes() throws PersistenciaException;
    
    public Cliente persistirCliente(Cliente cliente) throws PersistenciaException;
    
    public void asignarComandaACliente(Long idComanda, Long idCliente) throws PersistenciaException;
}
