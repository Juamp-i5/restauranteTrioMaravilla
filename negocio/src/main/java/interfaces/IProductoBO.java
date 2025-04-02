package interfaces;

import DTOs.salida.ProductoResumenDTO;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import java.util.List;

public interface IProductoBO {

    public List<ProductoResumenDTO> getProductosHabilitadosFiltrados(String filtroProducto, String filtroCategoria) throws NegocioException, ListaVaciaException;
}
