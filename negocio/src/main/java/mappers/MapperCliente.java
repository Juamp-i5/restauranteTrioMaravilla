/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import DTOs.entrada.ClienteNuevoDTO;
import DTOs.salida.ClienteViejoDTO;
import entidades.Cliente;
import entidades.ClienteFrecuente;

/**
 *
 * @author pablo
 */
public class MapperCliente {
    public static ClienteNuevoDTO toClienteNuevoDTO(Cliente cliente) {
        return new ClienteNuevoDTO(
            cliente.getNombres(),
            cliente.getApellidoPaterno(),
            cliente.getApellidoMaterno(),
            cliente.getTelefono(),
            cliente.getCorreoElectronico(),
            cliente.getFechaRegistro()
        );
    }
    
    public static ClienteViejoDTO toClienteViejoDTO(Cliente cliente) {
        return new ClienteViejoDTO(
            cliente.getId(),
            cliente.getNombres(),
            cliente.getApellidoPaterno(),
            cliente.getApellidoMaterno(),
            cliente.getTelefono(),
            cliente.getCorreoElectronico(),
            cliente.getFechaRegistro()
        );
    }
    
    public static Cliente toEntity(ClienteNuevoDTO cliente){
        return new ClienteFrecuente(
            cliente.getNombres(),
            cliente.getApellidoP(),
            cliente.getApellidoM(),
            cliente.getTelefono(),
            cliente.getCorreo(),
            cliente.getFechaRegistro()
        );
    }
}
