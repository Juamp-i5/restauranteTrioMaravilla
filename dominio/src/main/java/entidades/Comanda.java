package entidades;

import entidades.enums.EstadoComanda;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String folio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoComanda estado;

    @Column(nullable = false)
    private LocalDateTime fechaHoraRegistro;

    @ManyToOne()
    @JoinColumn(name = "ID_MESA", nullable = false)
    private Mesa mesa;

    @OneToMany(mappedBy = "comanda", cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetalleComanda> detallesComanda;
    
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    public Comanda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public List<DetalleComanda> getDetallesComanda() {
        return detallesComanda;
    }

    public void setDetallesComanda(List<DetalleComanda> detallesComanda) {
        this.detallesComanda = detallesComanda;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", folio=" + folio + ", estado=" + estado + ", fechaHoraRegistro=" + fechaHoraRegistro + ", mesa=" + mesa + ", detallesComanda=" + detallesComanda + ", cliente=" + cliente + '}';
    }
}
