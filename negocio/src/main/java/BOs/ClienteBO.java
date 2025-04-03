package BOs;

import DAOs.ClienteDAO;
import DTOs.entrada.ClienteNuevoDTO;
import DTOs.salida.ClienteViejoDTO;
import entidades.Cliente;
import entidades.ClienteFrecuente;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IClienteBO;
import interfaces.IClienteDAO;
import java.util.List;
import java.util.stream.Collectors;
import mappers.MapperCliente;
import mappers.MapperProducto;

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
    
    @Override
    public List<ClienteViejoDTO> obtenerClientesFiltrados(String filtroNombre, String filtroCorreo, String filtroTelefono) throws NegocioException, ListaVaciaException  {
        try {
            List<Cliente>clientes = clienteDAO.obtenerClientesFiltrados(filtroNombre, filtroCorreo, filtroTelefono);
            
            if (filtroNombre == null) filtroNombre = "";
            if (filtroCorreo == null) filtroCorreo = "";
            if (filtroTelefono == null) filtroTelefono = "";
            if (clientes.isEmpty()) {
                throw new ListaVaciaException("No hay clientes registrados");
            }         
            return clientes.stream()
                    .map(p -> MapperCliente.toClienteViejoDTO(p))
                    .collect(Collectors.toList());

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al filtrar clientes", e);
        }
    }
}
