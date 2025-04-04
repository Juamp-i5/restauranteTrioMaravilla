package DTOs.salida;

import enums.TipoProducto;

public class ProductoResumenDTO {

    private Long id;
    private String nombre;
    private TipoProducto tipo;
    private Double precio;

    public ProductoResumenDTO() {
    }

    public ProductoResumenDTO(Long id, String nombre, TipoProducto tipo, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
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

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
