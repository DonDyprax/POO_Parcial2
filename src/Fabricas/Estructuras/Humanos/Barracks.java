/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Estructuras.Humanos;

import Fabricas.Estructuras.Estructura;
/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class Barracks implements Estructura{
    private String nombre = "Barracks";
    private int vida;
    
    @Override
    public String getNombre(){
        return this.nombre;
    }
    
    @Override
    public int getVida(){
        return this.vida;
    }
}
