/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Estructuras.Elfos;

import Fabricas.Estructuras.Estructura;
/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class AncientOfLore implements Estructura{
    private String nombre = "Ancient Of Lore";
    private int vida, faseCreacion, tiempoCreacion = 1;
    
    public AncientOfLore(int fase){
        this.faseCreacion = fase;
    }
    
    @Override
    public Integer getNivel() {
        return null;
    }
    
    @Override
    public Integer getRecursoGenerado(){
        return null;
    }
    
    @Override
    public String getNombre(){
        return this.nombre;
    }
    
    @Override
    public int getVida(){
        return this.vida;
    }
    
    @Override
    public void setVida(int vida){
        this.vida = vida;
    }
    
    @Override
    public Integer getFaseCreacion() {
        return faseCreacion;
    }
    
    @Override
    public Integer getTiempoCreacion() {
        return tiempoCreacion;
    }
}
