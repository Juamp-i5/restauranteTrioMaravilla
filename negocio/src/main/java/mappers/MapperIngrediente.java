/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DTOs.entrada.IngredienteNuevoDTO;
import entidades.Ingrediente;

/**
 *
 * @author norma
 */
public class MapperIngrediente {

    public static Ingrediente toEntity(IngredienteNuevoDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Ingrediente(dto.getNombre(), dto.getUnidadMedida(), dto.getCantidadStock());
    }
}
