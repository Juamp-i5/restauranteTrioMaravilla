/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.negocio;

import BOs.IngredienteBO;
import DTOs.entrada.IngredienteNuevoDTO;
import entidades.enums.UnidadMedida;
import excepciones.NegocioException;
import excepciones.PersistenciaException;

/**
 *
 * @author norma
 */
public class InsertarIngrediente {

    public static void main(String[] args) {
         try {
            IngredienteNuevoDTO ingrediente = new IngredienteNuevoDTO("Harina", UnidadMedida.GRAMOS, 100);

            IngredienteBO ingredienteBO = new IngredienteBO();

            ingredienteBO.registrarNuevoIngrediente(ingrediente);

            System.out.println("Ingrediente registrado correctamente.");

        } catch (NegocioException e) {
            System.err.println("Error de negocio: " + e.getMessage());
        } catch (PersistenciaException e) {
            System.err.println("Error de persistencia: " + e.getMessage());
        }
    }
}
