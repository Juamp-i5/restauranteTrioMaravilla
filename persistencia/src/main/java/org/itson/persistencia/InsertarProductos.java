/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.persistencia;

import DAOs.ProductoDAO;
import entidades.Producto;
import entidades.enums.TipoProducto;
import excepciones.PersistenciaException;

/**
 *
 * @author Jp
 */
public class InsertarProductos {

    public static void main(String[] args) {
        try {
            ProductoDAO productoDAO = new ProductoDAO();

            Producto producto1 = new Producto();
            producto1.setNombre("Latte");
            producto1.setPrecio(55.0);
            producto1.setTipo(TipoProducto.BEBIDA);
            productoDAO.persistirProducto(producto1);
        } catch (PersistenciaException e) {
            System.out.println("Error al insertar producto 1");
            e.printStackTrace();
        }
    }

}
