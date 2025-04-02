package BOs;

import DAOs.ProductoDAO;
import DTOs.salida.ProductoResumenDTO;
import entidades.Producto;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IProductoBO;
import interfaces.IProductoDAO;
import java.util.List;
import java.util.stream.Collectors;
import mappers.MapperProducto;

public class ProductoBO implements IProductoBO {

    private final IProductoDAO productoDAO = new ProductoDAO();

    @Override
    public List<ProductoResumenDTO> getProductosHabilitadosFiltrados(String filtroProducto, String filtroCategoria) throws NegocioException, ListaVaciaException {
        try {
            List<Producto> productos = productoDAO.obtenerProductosHabilitadosFiltrados(filtroProducto, filtroCategoria);

            if (productos.isEmpty()) {
                throw new ListaVaciaException("No hay productos habilitados");
            }

            return productos.stream()
                    .map(p -> MapperProducto.toProductoResumenDTO(p))
                    .collect(Collectors.toList());

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los productos habilitados", e);
        }
    }

}
