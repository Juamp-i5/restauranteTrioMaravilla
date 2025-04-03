/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.persistencia;

import DAOs.IngredienteDAO;
import entidades.Ingrediente;
import enums.UnidadMedida;
import excepciones.PersistenciaException;

/**
 *
 * @author norma
 */
public class InsertarIngrediente {

    public static void main(String[] args) {
        try {
            IngredienteDAO ingredienteDAO = new IngredienteDAO();

            Ingrediente ingrediente = new Ingrediente("Chocolate", UnidadMedida.GRAMOS, 100);
            ingredienteDAO.persistirIngrediente(ingrediente);
        } catch (PersistenciaException e) {
            System.out.println("Error al insertar ingrediente ");
            e.printStackTrace();
        }
    }
    
}
