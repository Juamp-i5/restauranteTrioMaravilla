/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs.salida;

import java.time.LocalDate;

/**
 *
 * @author pablo
 */
public class ClienteViejoDTO {
    private Long id;
    private String nombres;
    private String apellidoP;
    private String apellidoM;
    private String telefono;
    private String correo;
    private LocalDate fechaRegistro;
    private int puntosFidelidad;

    public ClienteViejoDTO(Long id, String nombres, String apellidoP, String apellidoM, String telefono, String correo, LocalDate fechaRegistro) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }
    
    public ClienteViejoDTO(String nombres, String apellidoP, String apellidoM, String telefono, String correo, LocalDate fechaRegistro) {
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "ClienteViejoDTO{" + "id=" + id + ", nombres=" + nombres + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", telefono=" + telefono + ", correo=" + correo + ", fechaRegistro=" + fechaRegistro + ", puntosFidelidad=" + puntosFidelidad + '}';
    }
    
    
}
