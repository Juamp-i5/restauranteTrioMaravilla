/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs.salida;

/**
 *
 * @author norma
 */
public class DetalleComandaViejaDTO {

    private Long id;
    private Integer cantidad;
    private String comentario;
    private Long idProducto;  
    private Long idComanda;

    public DetalleComandaViejaDTO() {
    }

    public DetalleComandaViejaDTO(Long id, Integer cantidad, String comentario, Long idProducto, Long idComanda) {
        this.id = id;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.idProducto = idProducto;
        this.idComanda = idComanda;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Long idComanda) {
        this.idComanda = idComanda;
    }

    @Override
    public String toString() {
        return "DetalleComandaViejaDTO{" + "id=" + id + ", cantidad=" + cantidad + ", comentario=" + comentario + ", idProducto=" + idProducto + ", idComanda=" + idComanda + '}';
    }
    
    
}
