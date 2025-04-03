package interfaces;

import DTOs.salida.MostrarMesaDTO;
import entidades.Mesa;
import excepciones.PersistenciaException;
import java.util.List;

public interface IMesaDAO {

    public Mesa persistirMesa(Mesa mesa) throws PersistenciaException;

    public List<MostrarMesaDTO> obtenerMesasDisponibles() throws PersistenciaException;
}
