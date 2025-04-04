/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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

    public Ingrediente obtenerIngredientePorId(Long idIngrediente) throws PersistenciaException;

    public List<Ingrediente> obtenerIngredientes() throws PersistenciaException;

    public List<Ingrediente> obtenerIngredientesDisponibles() throws PersistenciaException;

    public boolean aumentarStock(Long idIngrediente, Integer cantidad) throws PersistenciaException;

    public boolean reducirStock(Long idIngrediente, Integer cantidad) throws PersistenciaException;

    public List<Ingrediente> obtenerIngredientesFiltrados(String filtroNombre, String filtroUnidad) throws PersistenciaException;

    public boolean comprobarExistenciaIngrediente(String nombre, UnidadMedida unidadMedida) throws PersistenciaException;

}
