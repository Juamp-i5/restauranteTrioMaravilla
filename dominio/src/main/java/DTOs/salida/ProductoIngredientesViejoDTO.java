/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs.salida;

/**
 *
 * @author Jp
 */
public class ProductoIngredientesViejoDTO {

    private Long id;
    private Integer cantidad;
    private Long idProducto; 
    private Long idIngrediente;

    public ProductoIngredientesViejoDTO() {
    }

    public ProductoIngredientesViejoDTO(Long id, Integer cantidad, Long idProducto, Long idIngrediente) {
        this.id = id;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.idIngrediente = idIngrediente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    @Override
    public String toString() {
        return "ProductoIngredientesDTO{" + "id=" + id + ", cantidad=" + cantidad + ", idProducto=" + idProducto + ", idIngrediente=" + idIngrediente + '}';
    }
    
    
}
