package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ingredientes_productos")
public class IngredienteProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "ID_INGREDIENTE", nullable = false)
    private Ingrediente ingrediente;

    public IngredienteProducto() {
    }

    public IngredienteProducto(Long id, Integer cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public IngredienteProducto(Integer cantidad) {
        this.cantidad = cantidad;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String toString() {
        return "IngredienteProducto{" + "id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + ", ingrediente=" + ingrediente + '}';
    }
    
    

}
