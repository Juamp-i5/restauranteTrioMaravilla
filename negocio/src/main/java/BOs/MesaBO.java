package BOs;

import DAOs.MesaDAO;
import DTOs.salida.MostrarMesaDTO;
import entidades.Mesa;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IMesaBO;
import interfaces.IMesaDAO;
import java.util.List;

public class MesaBO implements IMesaBO{

    IMesaDAO mesaDAO = new MesaDAO();

    @Override
    public void persistirMuchasMesas() throws NegocioException {
        for (int i = 0; i < 5; i++) {
            try {
                Mesa mesa = new Mesa();
                mesa.setNombre("Mesa #" + i + 1);
                mesaDAO.persistirMesa(mesa);
            } catch (PersistenciaException ex) {
                throw new NegocioException("Error al agregar mesas", ex);
            }
        }

        for (int i = 0; i < 3; i++) {
            try {
                Mesa mesa = new Mesa();
                mesa.setNombre("Mesa VIP #" + i + 1);
                mesaDAO.persistirMesa(mesa);
            } catch (PersistenciaException ex) {
                throw new NegocioException("Error al agregar mesas", ex);
            }
        }
    }

    @Override
    public List<MostrarMesaDTO> obtenerMesasDisponibles() throws NegocioException, ListaVaciaException {
        try {
            List<MostrarMesaDTO> mesas = mesaDAO.obtenerMesasDisponibles();
            if (mesas.isEmpty()) {
                throw new ListaVaciaException("No hay mesas disponibles");
            }

            return mesas;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener mesas disponibles", e);
        }
    }
}
