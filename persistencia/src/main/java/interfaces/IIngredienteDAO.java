package interfaces;

import entidades.Ingrediente;
import enums.UnidadMedida;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author norma
 */
public interface IIngredienteDAO {

    public Ingrediente persistirIngrediente(Ingrediente ingrediente) throws PersistenciaException;

    public boolean eliminarIngrediente(Long idIngrediente) throws PersistenciaException;

    public List<Ingrediente> obtenerIngredientes() throws PersistenciaException;

    public List<Ingrediente> obtenerIngredientesDisponibles() throws PersistenciaException;

    public boolean aumentarStock(Long idIngrediente, Integer cantidad) throws PersistenciaException;

    public boolean reducirStock(Long idIngrediente, Integer cantidad) throws PersistenciaException;

    public List<Ingrediente> obtenerIngredientesFiltrados(String filtroNombre, String filtroUnidad) throws PersistenciaException;

    public boolean comprobarExistenciaIngrediente(String nombre, UnidadMedida unidadMedida) throws PersistenciaException;

}
