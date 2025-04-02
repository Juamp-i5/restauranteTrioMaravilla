package interfaces;

import entidades.IngredienteProducto;
import entidades.Producto;
import excepciones.PersistenciaException;
import java.util.List;

public interface IProductoDAO {

    public Producto obtenerProducto(Long idProducto) throws PersistenciaException;
    
    public List<Producto> obtenerProductos() throws PersistenciaException;
    
    public List<Producto> obtenerProductosDisponibles() throws PersistenciaException;
    
    public List<Producto> obtenerProductosHabilitadosFiltrados(String filtroProducto, String filtroCategoria) throws PersistenciaException;
    
    public Boolean isProductoDisponible(Long idProducto) throws PersistenciaException;
    
    public Producto persistirProducto(Producto producto) throws PersistenciaException;
    
    public void agregarIngredienteProducto(Producto producto, IngredienteProducto ingredienteProducto) throws PersistenciaException;
}
