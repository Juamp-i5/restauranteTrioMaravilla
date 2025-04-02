/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs.entrada;

import entidades.enums.UnidadMedida;

/**
 *
 * @author norma
 */
public class IngredienteNuevoDTO {
    private String nombre;
    private UnidadMedida unidadMedida;
    private Integer cantidadStock;

    public IngredienteNuevoDTO() {
    }

    public IngredienteNuevoDTO(String nombre, UnidadMedida unidadMedida, Integer cantidadStock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadStock = cantidadStock;
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
        return "IngredienteNuevoDTO{" + "nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", cantidadStock=" + cantidadStock + '}';
    }
    
}
