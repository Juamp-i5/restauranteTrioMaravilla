/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.entrada.ClienteNuevoDTO;
import entidades.Cliente;
import excepciones.NegocioException;

/**
 *
 * @author pablo
 */
public interface IClienteBO {
    public Cliente persistirClienteFrecuente(ClienteNuevoDTO cliente) throws NegocioException;
}
