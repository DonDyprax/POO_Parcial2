/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Estructuras;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class TownCenter implements Estructura{
    private String nombre = "Town Center";
    private int vida, nivel = 1;
    
    @Override
    public String getNombre(){
        return this.nombre;
    }
    
    @Override
    public int getVida(){
        return this.vida;
    }
    
    @Override
    public Integer getFaseCreacion(){
        return null;
    }
    
    @Override
    public Integer getTiempoCreacion(){
        return null;
    }
}
