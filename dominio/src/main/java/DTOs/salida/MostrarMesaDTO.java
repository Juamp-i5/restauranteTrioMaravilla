package DTOs.salida;

public class MostrarMesaDTO {

    Long idMesa;
    String nombre;

    public MostrarMesaDTO() {
    }

    public MostrarMesaDTO(Long idMesa, String nombre) {
        this.idMesa = idMesa;
        this.nombre = nombre;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "MostrarMesaDTO{" + "nombre=" + nombre + '}';
    }

}
