/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.persistencia;

import DAOs.ClienteDAO;
import excepciones.PersistenciaException;

/**
 *
 * @author pablo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Long idCliente = 1L;
        Long idComanda = 1L;
        System.out.println(clienteDAO.obtenerClientesFrecuentes());
    }
    
}
