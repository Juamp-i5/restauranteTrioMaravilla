package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author pablo
 */
@Entity
public class ClienteFrecuente extends Cliente implements Serializable {
    @Column(nullable = false)
    private Integer puntosFidelidad;
    
    @Column(nullable = false)
    private Integer visitas;
    
    @Column(nullable = false)
    private Double totalGastado;
    
    public ClienteFrecuente() {
    }

    public ClienteFrecuente(Integer puntosFidelidad, Integer visitas, Double totalGastado, Long idCliente, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, LocalDate fechaRegistro, List<Comanda> comandas) {
        super(idCliente, nombres, apellidoPaterno, apellidoMaterno, telefono, correoElectronico, fechaRegistro, comandas);
        this.puntosFidelidad = puntosFidelidad;
        this.visitas = visitas;
        this.totalGastado = totalGastado;
    }

    public ClienteFrecuente(Integer puntosFidelidad, Integer visitas, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, LocalDate fechaRegistro, List<Comanda> comandas) {
        super(nombres, apellidoPaterno, apellidoMaterno, telefono, correoElectronico, fechaRegistro, comandas);
        this.puntosFidelidad = puntosFidelidad;
        this.visitas = visitas;
    }

    public Integer getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(Integer puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public Double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(Double totalGastado) {
        this.totalGastado = totalGastado;
    }

    @Override
    public String toString() {
        return "ClienteFrecuente{" + "puntosFidelidad=" + puntosFidelidad + ", visitas=" + visitas + ", totalGastado=" + totalGastado + '}';
    }
}
