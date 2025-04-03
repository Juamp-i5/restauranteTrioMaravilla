/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs.salida;

import enums.UnidadMedida;

/**
 *
 * @author norma
 */
public class IngredienteViejoDTO {
    
    private Long id;
    private String nombre;
    private UnidadMedida unidadMedida;
    private Integer cantidadStock;

    public IngredienteViejoDTO() {
    }

    public IngredienteViejoDTO(Long id, String nombre, UnidadMedida unidadMedida, Integer cantidadStock) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadStock = cantidadStock;
    }

    
    public IngredienteViejoDTO(String nombre, UnidadMedida unidadMedida, Integer cantidadStock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadStock = cantidadStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public String toString() {
        return "IngredienteViejoDTO{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", cantidadStock=" + cantidadStock + '}';
    }
    
}
