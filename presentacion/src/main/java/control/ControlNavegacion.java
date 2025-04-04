package control;

import BOs.MesaBO;
import control.enums.ModoMenu;
import control.enums.ModoTablaProductos;
import BOs.ClienteBO;
import BOs.IngredienteBO;
import BOs.ProductoBO;
import DTOs.entrada.ClienteNuevoDTO;
import DTOs.salida.MostrarMesaDTO;
import DTOs.salida.ProductoIngredientesDTO;
import DTOs.salida.ClienteViejoDTO;
import DTOs.salida.ComandaViejaDTO;
import DTOs.salida.IngredienteViejoDTO;
import DTOs.salida.ProductoResumenDTO;
import control.enums.ModoDetallesProducto;
import control.enums.ModoTablaIngredientes;
import excepciones.ListaVaciaException;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IMesaBO;
import interfaces.IClienteBO;
import interfaces.IIngredienteBO;
import interfaces.IProductoBO;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pantallas.PantallaDetallesProducto;
import pantallas.PantallaInicioSesion;
import pantallas.PantallaMenuIngrediente;
import pantallas.PantallaMenuOpciones;
import pantallas.PantallaRegistroCliente;
import pantallas.PantallaTipoCliente;
import pantallas.PantallaMenuProducto;
import pantallas.PantallaMesas;
import pantallas.PantallaRegistrarNuevoIngrediente;
import pantallas.PantallaTablaClientes;
import pantallas.PantallaTablaIngredientes;
import pantallas.PantallaTablaProductos;

public class ControlNavegacion {

    private static ModoMenu modoMenu;

    private static IProductoBO productoBO = new ProductoBO();
    private static IMesaBO mesaBO = new MesaBO();
    private static IClienteBO clienteBO = new ClienteBO();
    private static IIngredienteBO ingredienteBO = new IngredienteBO();

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
        JFrame frame = new PantallaTablaProductos(null, modo);
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

    public static void mostrarPantallaMesas() {
        List<MostrarMesaDTO> mesasDisponibles;
        try {
            mesasDisponibles = mesaBO.obtenerMesasDisponibles();
            JFrame frame = new PantallaMesas(mesasDisponibles);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error desconocido, mira consola", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (ListaVaciaException ex) {
            JOptionPane.showMessageDialog(null, "No hay mesas disponibles", "Atencion", JOptionPane.WARNING_MESSAGE);
        }

    }

    public boolean validarRegistro(ClienteNuevoDTO cliente) {
        if (cliente.getNombres() == null || cliente.getApellidoP() == null || cliente.getTelefono() == null) {
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

    public static void mostrarPantallaDetallesProducto(Long idProducto, ModoDetallesProducto modo) {
        ProductoIngredientesDTO producto = null;
        JFrame frame = new PantallaDetallesProducto(producto, modo);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void agregarMesas() {
        try {
            mesaBO.persistirMuchasMesas();
            JOptionPane.showMessageDialog(null, "Mesas agregadas", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Ya estan agregadas las mesas", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void mostrarPantallaTablaCliente() {
        mostrarPantallaTablaCliente("", "", "");
    }

    public static void mostrarPantallaTablaCliente(String filtroNombre, String filtroCorreo, String filtroTelefono) {
        List<ClienteViejoDTO> clientes = new ArrayList<>();
        ComandaViejaDTO comanda = new ComandaViejaDTO();

        try {
            clientes = clienteBO.obtenerClientesFiltrados(filtroNombre, filtroCorreo, filtroTelefono);
        } catch (ListaVaciaException ex) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error desconocido, ver consola", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }

        JFrame frame = new PantallaTablaClientes(clientes, comanda);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static List<ProductoResumenDTO> obtenerProductos(String filtroProducto, String filtroCategoria) {
        List<ProductoResumenDTO> productos = new ArrayList<>();
        try {
            productos = productoBO.getProductosHabilitadosFiltrados(filtroProducto, filtroCategoria);
            return productos;
        } catch (ListaVaciaException ex) {
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error desconocido, ver consola", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
    
    public static List<IngredienteViejoDTO> obtenerIngredientes(String filtroNombre, String filtroUnidadMedida) {
        List<IngredienteViejoDTO> ingredientes = new ArrayList<>();
        try {
            ingredientes = ingredienteBO.obtenerIngredientesFiltrados(filtroNombre, filtroUnidadMedida);
            return ingredientes;
        } catch (ListaVaciaException ex) {
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error desconocido, ver consola", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
    
    public static void mostrarPantallaTablaIngredientes(ModoTablaIngredientes modo) {
        mostrarPantallaTablaIngredientes("", "", modo);
    }
    
    public static void mostrarPantallaTablaIngredientes(String filtroNombre, String filtroUnidadMedida, ModoTablaIngredientes modo) {
        JFrame frame = new PantallaTablaIngredientes(null, modo);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    
    
    
    
}
