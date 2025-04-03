/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.negocio;

import BOs.ClienteBO;
import DTOs.entrada.ClienteNuevoDTO;
import excepciones.NegocioException;
import java.time.LocalDate;

/**
 *
 * @author pablo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteBO clienteBO = new ClienteBO();
//        try{
//            ClienteNuevoDTO cliente = new ClienteNuevoDTO();
//        
//        LocalDate fechaActual = LocalDate.now();
//        cliente.setNombres("Pepe");
//        cliente.setApellidoP("Perez");
//        cliente.setApellidoM("");
//        cliente.setTelefono("102938475");
//        cliente.setCorreo("Ejemplo");
//        cliente.setFechaRegistro(fechaActual);
//        long id = 1;
//        clienteBO.obtenerClienteFrecuente(id);
//            System.out.println();
//        }catch(NegocioException e){
//           System.err.println("Error de negocio: " + e.getMessage());
//        }
        
        try{
           long id = 1;
            System.out.println(clienteBO.obtenerClienteFrecuente(id));
            System.out.println();
        }catch(NegocioException e){
           System.err.println("Error de negocio: " + e.getMessage());
        }
            
        
    }
    
}
