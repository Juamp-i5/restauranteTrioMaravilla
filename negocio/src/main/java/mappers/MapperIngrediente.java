/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DTOs.entrada.IngredienteNuevoDTO;
import DTOs.salida.IngredienteViejoDTO;
import entidades.Ingrediente;
import java.util.ArrayList;
import java.util.List;

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

    public static IngredienteViejoDTO toViejoDTO(Ingrediente ingrediente) {
        if (ingrediente == null) {
            return null;
        }
        return new IngredienteViejoDTO(
                ingrediente.getId(),
                ingrediente.getNombre(),
                ingrediente.getUnidadMedida(),
                ingrediente.getCantidadStock()
        );
    }

    public static Ingrediente toEntity(IngredienteViejoDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Ingrediente(
                dto.getId(),
                dto.getNombre(),
                dto.getUnidadMedida(),
                dto.getCantidadStock()
        );
    }
    
    public static List<IngredienteViejoDTO> toViejoDTOList(List<Ingrediente> listaIngredientes) {
        if (listaIngredientes == null || listaIngredientes.isEmpty()) {
            return new ArrayList<>();
        }

        List<IngredienteViejoDTO> listaDTO = new ArrayList<>();
        for (Ingrediente ingrediente : listaIngredientes) {
            listaDTO.add(toViejoDTO(ingrediente));
        }
        return listaDTO;
    }
}
