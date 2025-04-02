/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.IngredienteDAO;
import DTOs.entrada.IngredienteNuevoDTO;
import DTOs.salida.UnidadMedidaDTO;
import entidades.enums.UnidadMedida;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IIngredienteDAO;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import mappers.MapperIngrediente;

/**
 *
 * @author norma
 */
public class IngredienteBO {

    private final IIngredienteDAO ingredienteDAO = new IngredienteDAO();

    public void registrarNuevoIngrediente(IngredienteNuevoDTO ingrediente) throws NegocioException, PersistenciaException {

        if (ingrediente == null) {
            throw new NegocioException("El ingrediente no puede ser nulo.");
        }
        if (ingrediente.getNombre() == null || ingrediente.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre del ingrediente no puede estar vacío.");
        }
        if (ingrediente.getUnidadMedida() == null) {
            throw new NegocioException("La unidad de medida no puede ser nula.");
        }

        if (ingredienteDAO.comprobarExistenciaIngrediente(ingrediente.getNombre(), ingrediente.getUnidadMedida())) {
            throw new NegocioException("Ya existe un ingrediente con le mismo nombre y unidad de medida.");
        }

        ingredienteDAO.persistirIngrediente(MapperIngrediente.toEntity(ingrediente));
    }

    public List<UnidadMedidaDTO> obtenerUnidadesMedida() {
        return Arrays.stream(UnidadMedida.values()) 
                .map(unidad -> new UnidadMedidaDTO(unidad.name())) 
                .collect(Collectors.toList()); 
    }

}
