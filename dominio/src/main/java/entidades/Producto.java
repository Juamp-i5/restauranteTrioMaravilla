package entidades;

import entidades.enums.EstadoProducto;
import entidades.enums.TipoProducto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoProducto tipo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoProducto estado = EstadoProducto.HABILITADO;

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.LAZY)
    List<IngredienteProducto> ingredientesProducto;

    public Producto() {
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public List<IngredienteProducto> getIngredientesProducto() {
        return ingredientesProducto;
    }

    public void setIngredientesProducto(List<IngredienteProducto> ingredientesProducto) {
        this.ingredientesProducto = ingredientesProducto;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", estado=" + estado + ", ingredientesProducto=" + ingredientesProducto + '}';
    }

}
