package control;

import BOs.ClienteBO;
import BOs.ProductoBO;
import DTOs.entrada.ClienteNuevoDTO;
import DTOs.salida.ClienteViejoDTO;
import DTOs.salida.ProductoResumenDTO;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import interfaces.IClienteBO;
import interfaces.IProductoBO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pantallas.PantallaInicioSesion;
import pantallas.PantallaMenuIngrediente;
import pantallas.PantallaMenuOpciones;
import pantallas.PantallaRegistroCliente;
import pantallas.PantallaTipoCliente;
import pantallas.PantallaMenuProducto;
import pantallas.PantallaRegistrarNuevoIngrediente;
import pantallas.PantallaTablaClientes;
import pantallas.PantallaTablaProductos;

public class ControlNavegacion {

    private static ModoMenu modoMenu;

    private static IProductoBO productoBO = new ProductoBO();
    private static IClienteBO clienteBO = new ClienteBO();

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

    public static void mostrarPantallaTablaProductos(ModoTablaProductos modo) {
        mostrarPantallaTablaProductos("", "", modo);
    }

    public static void mostrarPantallaTablaProductos(String filtroProducto, String filtroCategoria, ModoTablaProductos modo) {
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

        JFrame frame = new PantallaTablaProductos(productos, modo);
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

    public static void mostrarPantallaMenuIngrediente() {
        JFrame frame = new PantallaMenuIngrediente();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public boolean validarRegistro(ClienteNuevoDTO cliente) {
        if (cliente.getNombres()==null || cliente.getApellidoP()==null|| cliente.getTelefono()==null) {
            JOptionPane.showMessageDialog(null, "Error: Todos los campos deben estar llenos", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!cliente.getTelefono().matches("\\d{12}")) {
            JOptionPane.showMessageDialog(null, "Error: El formato no es vàlido para el telefono", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Cliente registrado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static void mostrarPantallaRegistrarNuevoIngrediente() {
        JFrame frame = new PantallaRegistrarNuevoIngrediente();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void mostrarPantallaTablaCliente(){
        mostrarPantallaTablaCliente("","","");
    }
    
    public static void mostrarPantallaTablaCliente(String filtroNombre, String filtroCorreo, String filtroTelefono) {
        List<ClienteViejoDTO> clientes = new ArrayList<>();
        try {
            clientes = clienteBO.obtenerClientesFiltrados(filtroNombre, filtroCorreo, filtroTelefono);
        } catch (ListaVaciaException ex) {
            JOptionPane.showMessageDialog(null, "No hay productos", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error desconocido, ver consola", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }
        
        JFrame frame = new PantallaTablaClientes(clientes);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
