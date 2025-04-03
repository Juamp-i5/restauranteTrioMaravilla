/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.entrada.ClienteNuevoDTO;
import DTOs.salida.ClienteViejoDTO;
import entidades.Cliente;
import entidades.ClienteFrecuente;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IClienteBO {
    public Cliente persistirClienteFrecuente(ClienteNuevoDTO cliente) throws NegocioException;
    
    public List<ClienteViejoDTO> obtenerClientesFiltrados(String filtroNombre, String filtroCorreo, String filtroTelefono) throws NegocioException, ListaVaciaException;
    
    public void asignarComandaACliente(Long idComanda, Long idCliente) throws NegocioException;
    
    public ClienteViejoDTO obtenerClienteFrecuente(Long idClienteFrecuente) throws NegocioException;
}
