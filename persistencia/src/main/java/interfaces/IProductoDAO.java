package interfaces;

import entidades.Producto;
import excepciones.PersistenciaException;

public interface IProductoDAO {

    public Producto persistirProducto(Producto producto) throws PersistenciaException;
}
