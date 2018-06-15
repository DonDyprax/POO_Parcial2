/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Unidades.Muertos;


import Fabricas.Estructuras.Estructura;
import Fabricas.Unidades.Unidad;
import Main.Main;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class DeathKnight implements Unidad{
    private final String nombre = "deathknight";
    private int vida, ataqueEstructura, ataqueUnidad;
    private int faseCreacion, faseAtaque, tiempoCreacion = 3;
    
    public DeathKnight(int fase) {
        this.faseCreacion = fase;
    }
    
    @Override
    public void atacar(Estructura estructura){
        this.faseAtaque = Main.fase;
                
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public int getFaseCreacion() {
        return faseCreacion;
    }
    
    @Override
    public int getTiempoCreacion() {
        return tiempoCreacion;
    }
    
    @Override
    public int getFaseAtaque() {
        return faseAtaque;
    }

}
