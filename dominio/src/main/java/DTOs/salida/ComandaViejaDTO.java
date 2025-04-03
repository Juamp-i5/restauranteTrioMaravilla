/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs.salida;

import enums.EstadoComanda;
import java.time.LocalDate;

/**
 *
 * @author pablo
 */
public class ComandaViejaDTO {
    private Long id;
    private EstadoComanda estado;
    private String folio;
    private LocalDate fechaRegistro;

    public ComandaViejaDTO() {
    }
    
    public ComandaViejaDTO(Long id, EstadoComanda estado, String folio, LocalDate fechaRegistro) {
        this.id = id;
        this.estado = estado;
        this.folio = folio;
        this.fechaRegistro = fechaRegistro;
    }

    public ComandaViejaDTO(EstadoComanda estado, String folio, LocalDate fechaRegistro) {
        this.estado = estado;
        this.folio = folio;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
