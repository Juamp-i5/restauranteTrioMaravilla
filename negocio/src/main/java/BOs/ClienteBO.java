package BOs;

import DAOs.ClienteDAO;
import DTOs.entrada.ClienteNuevoDTO;
import entidades.Cliente;
import entidades.ClienteFrecuente;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IClienteBO;
import interfaces.IClienteDAO;
import mappers.MapperCliente;

/**
 *
 * @author pablo
 */
public class ClienteBO implements IClienteBO {

    private final IClienteDAO clienteDAO = new ClienteDAO();

    @Override
    public Cliente persistirClienteFrecuente(ClienteNuevoDTO cliente) throws NegocioException {
        try {
            ClienteFrecuente clienteF = (ClienteFrecuente) MapperCliente.toEntity(cliente);
            ClienteFrecuente clienteNuevo = (ClienteFrecuente) clienteDAO.persistirCliente(clienteF);
            if (clienteNuevo == null) {
                throw new NegocioException("Error, el cliente es nulo");
            }
            if (clienteNuevo.getNombres() == null || clienteNuevo.getApellidoPaterno() == null || clienteNuevo.getTelefono() == null) {
                throw new NegocioException("Error, los valores no pueden ser nulos");
            }
            return clienteNuevo;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los productos habilitados", e);
        }
    }
}
