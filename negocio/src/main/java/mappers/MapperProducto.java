package mappers;

import DTOs.salida.ProductoResumenDTO;
import entidades.Producto;

public class MapperProducto {

    public static ProductoResumenDTO toProductoResumenDTO(Producto producto) {
        return new ProductoResumenDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getTipo(),
                producto.getPrecio()
        );
    }
}
