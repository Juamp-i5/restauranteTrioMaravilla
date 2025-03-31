package entidades;

import entidades.enums.TipoProducto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoProducto tipo;

    @OneToMany(mappedBy = "producto")
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

}
