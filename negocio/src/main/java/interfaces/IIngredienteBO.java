/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.entrada.IngredienteNuevoDTO;
import DTOs.salida.IngredienteViejoDTO;
import DTOs.salida.UnidadMedidaDTO;
import entidades.enums.UnidadMedida;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author norma
 */
public interface IIngredienteBO {

    public void registrarNuevoIngrediente(IngredienteNuevoDTO ingrediente) throws NegocioException, PersistenciaException;

    public List<UnidadMedidaDTO> obtenerUnidadesMedida();

    public boolean eliminarIngrediente(Long idIngrediente) throws PersistenciaException, NegocioException;

    public IngredienteViejoDTO obtenerIngredientePorId(Long idIngrediente) throws PersistenciaException, NegocioException;

    public List<IngredienteViejoDTO> obtenerIngredientes() throws PersistenciaException, NegocioException;

    public List<IngredienteViejoDTO> obtenerIngredientesDisponibles() throws PersistenciaException, NegocioException;

    public boolean aumentarStock(Long idIngrediente, Integer cantidad) throws PersistenciaException, NegocioException;

    public boolean reducirStock(Long idIngrediente, Integer cantidad) throws PersistenciaException, NegocioException;

    public List<IngredienteViejoDTO> obtenerIngredientesFiltrados(String filtroNombre, String filtroUnidad) throws PersistenciaException;

  

}
