package mappers;

import DTOs.salida.UnidadMedidaDTO;
import enums.UnidadMedida;

/**
 *
 * @author norma
 */
public class MapperUnidadMedida {

    public static UnidadMedida fromDTOToEnum(UnidadMedidaDTO unidadMedidaDTO) {

        for (UnidadMedida unidad : UnidadMedida.values()) {
            if (unidad.getSimbolo().equalsIgnoreCase(unidadMedidaDTO.getNombre  ())) {
                return unidad;
            }
        }
        
        return null;

    }

    public static UnidadMedidaDTO fromEnumToDTO(UnidadMedida unidadMedida) {

        return new UnidadMedidaDTO(unidadMedida.getSimbolo());
    }
}
