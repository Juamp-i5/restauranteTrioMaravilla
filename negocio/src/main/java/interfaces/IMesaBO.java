/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.salida.MostrarMesaDTO;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Jp
 */
public interface IMesaBO {
    public List<MostrarMesaDTO> obtenerMesasDisponibles() throws NegocioException, ListaVaciaException;
    
    public void persistirMuchasMesas() throws NegocioException;
}
