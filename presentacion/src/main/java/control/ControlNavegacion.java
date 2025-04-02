package control;

import BOs.ProductoBO;
import DTOs.salida.ProductoResumenDTO;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import interfaces.IProductoBO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pantallas.PantallaInicioSesion;
import pantallas.PantallaMenuOpciones;
import pantallas.PantallaRegistroCliente;
import pantallas.PantallaTipoCliente;
import pantallas.PantallaMenuProducto;
import pantallas.PantallaTablaProductos;

public class ControlNavegacion {

    private static ModoMenu modoMenu;

    private static IProductoBO productoBO = new ProductoBO();

    public static void mostrarPantallaInicioSesion() {
        JFrame frame = new PantallaInicioSesion();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void mostrarPantallaMenuOpciones() {
        JFrame frame = new PantallaMenuOpciones();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void mostrarPantallaMenuProducto() {
        JFrame frame = new PantallaMenuProducto();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void mostrarPantallaTablaProductos(){
        mostrarPantallaTablaProductos("", "");
    }

    public static void mostrarPantallaTablaProductos(String filtroProducto, String filtroCategoria) {
        List<ProductoResumenDTO> productos = new ArrayList<>();
        try {
            productos = productoBO.getProductosHabilitadosFiltrados(filtroProducto, filtroCategoria);
        } catch (ListaVaciaException ex) {
            JOptionPane.showMessageDialog(null, "No hay productos", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error desconocido, ver consola", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }
        
        JFrame frame = new PantallaTablaProductos(productos);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static ModoMenu getModoMenu() {
        return ControlNavegacion.modoMenu;
    }

    public static void setModoMenu(ModoMenu modoMenu) {
        ControlNavegacion.modoMenu = modoMenu;
    }
    
    public static void mostrarRegistroCliente() {
        JFrame frame = new PantallaRegistroCliente();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void mostrarTipoCliente() {
        JFrame frame = new PantallaTipoCliente();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
}
