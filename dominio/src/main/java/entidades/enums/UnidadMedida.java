/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.enums;

/**
 *
 * @author norma
 */
public enum UnidadMedida {
    GRAMOS("gr"),
    MILILITROS("ml"),
    PIEZAS("pza");
    
    private final String simbolo;

    UnidadMedida(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
