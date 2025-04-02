/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.swing.JFrame;
import pantallas.PantallaInicioSesion;
import pantallas.PantallaMenuOpciones;
import pantallas.PantallaRegistroCliente;

/**
 *
 * @author Jp
 */
public class ControlNavegacion {

    private static ModoMenu modoMenu;

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
}
