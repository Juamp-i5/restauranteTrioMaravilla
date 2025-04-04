package BOs;

import DAOs.IngredienteDAO;
import DTOs.entrada.IngredienteNuevoDTO;
import DTOs.salida.IngredienteViejoDTO;
import DTOs.salida.UnidadMedidaDTO;
import entidades.Ingrediente;
import enums.UnidadMedida;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import mappers.MapperIngrediente;

/**
 *
 * @author norma
 */
public class IngredienteBO implements IIngredienteBO {

    private final IIngredienteDAO ingredienteDAO = new IngredienteDAO();

    @Override
    public void registrarNuevoIngrediente(IngredienteNuevoDTO ingrediente) throws NegocioException, PersistenciaException {

        if (ingrediente == null) {
            throw new NegocioException("El ingrediente no puede ser nulo.");
        }

        if (ingrediente.getNombre() == null || ingrediente.getNombre().trim().isEmpty()
                || ingrediente.getUnidadMedida() == null || ingrediente.getCantidadStock() == null) {
            throw new NegocioException("Se tiene que llenar todos los campos.");
        }

        if (ingrediente.getCantidadStock() < 0) {
            throw new NegocioException("La cantidad de stock no puede ser menor a 0.");
        }

        if (ingredienteDAO.comprobarExistenciaIngrediente(ingrediente.getNombre(), ingrediente.getUnidadMedida())) {
            throw new NegocioException("Ya existe un ingrediente con el mismo nombre y unidad de medida.");
        }

        ingredienteDAO.persistirIngrediente(MapperIngrediente.toEntity(ingrediente));
    }

    @Override
    public List<UnidadMedidaDTO> obtenerUnidadesMedida() {
        return Arrays.stream(UnidadMedida.values())
                .map(unidad -> new UnidadMedidaDTO(unidad.name()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean eliminarIngrediente(Long idIngrediente) throws PersistenciaException, NegocioException {
        if (idIngrediente <= 0) {
            throw new NegocioException("El ID debe ser un número válido.");
        }

        boolean eliminado = ingredienteDAO.eliminarIngrediente(idIngrediente);
        if (!eliminado) {
            throw new NegocioException("No se pudo eliminar el ingrediente con ID: " + idIngrediente);
        }
        return eliminado;
    }

    @Override
    public List<IngredienteViejoDTO> obtenerIngredientes() throws PersistenciaException, NegocioException {
        try {
            List<Ingrediente> ingredientes = ingredienteDAO.obtenerIngredientes();
            if (ingredientes == null || ingredientes.isEmpty()) {
                throw new NegocioException("No se encontraron ingredientes en la base de datos.");
            }
            return MapperIngrediente.toViejoDTOList(ingredientes);
        } catch (PersistenciaException e) {
            throw e;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la lista de ingredientes.", e);
        }
    }

    @Override
    public List<IngredienteViejoDTO> obtenerIngredientesDisponibles() throws PersistenciaException, NegocioException {
        try {
            List<Ingrediente> ingredientesDisponibles = ingredienteDAO.obtenerIngredientesDisponibles();
            if (ingredientesDisponibles == null || ingredientesDisponibles.isEmpty()) {
                throw new NegocioException("No hay ingredientes disponibles en stock.");
            }
            return MapperIngrediente.toViejoDTOList(ingredientesDisponibles);
        } catch (PersistenciaException e) {
            throw e;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la lista de ingredientes disponibles.", e);
        }
    }

    @Override
    public boolean aumentarStock(Long idIngrediente, Integer cantidad) throws PersistenciaException, NegocioException {
        if (idIngrediente == null || idIngrediente <= 0) {
            throw new NegocioException("El ID del ingrediente es inválido.");
        }
        if (cantidad == null || cantidad <= 0) {
            throw new NegocioException("La cantidad a aumentar debe ser mayor que cero.");
        }

        try {
            boolean resultado = ingredienteDAO.aumentarStock(idIngrediente, cantidad);
            if (!resultado) {
                throw new NegocioException("Ingrediente con ID " + idIngrediente + " no encontrado.");
            }
            return true;
        } catch (PersistenciaException e) {
            throw e;
        } catch (Exception e) {
            throw new PersistenciaException("Error al aumentar el stock del ingrediente.", e);
        }
    }

    @Override
    public boolean reducirStock(Long idIngrediente, Integer cantidad) throws PersistenciaException, NegocioException {
        if (idIngrediente == null || idIngrediente <= 0) {
            throw new NegocioException("El ID del ingrediente es inválido.");
        }
        if (cantidad == null || cantidad <= 0) {
            throw new NegocioException("La cantidad a reducir debe ser mayor que cero.");
        }

        try {
            boolean resultado = ingredienteDAO.reducirStock(idIngrediente, cantidad);
            if (!resultado) {
                throw new NegocioException("Ingrediente con ID " + idIngrediente + " no encontrado.");
            }
            return true;
        } catch (PersistenciaException e) {
            throw e;
        } catch (Exception e) {
            throw new PersistenciaException("Error al reducir el stock del ingrediente.", e);
        }
    }

    @Override
    public List<IngredienteViejoDTO> obtenerIngredientesFiltrados(String filtroNombre, String filtroUnidad) throws NegocioException, ListaVaciaException {
        try {
            if (filtroNombre == null) {
                filtroNombre = "";
            }
            if (filtroUnidad == null) {
                filtroUnidad = "";
            }

            List<Ingrediente> ingredientesFiltrados = ingredienteDAO.obtenerIngredientesFiltrados(filtroNombre, filtroUnidad);
            if (ingredientesFiltrados.isEmpty()) {
                throw new ListaVaciaException("No hay productos habilitados");
            }

            return MapperIngrediente.toViejoDTOList(ingredientesFiltrados);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los productos habilitados", e);
        }
    }

}
