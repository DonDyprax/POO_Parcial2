/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Unidades.Elfos;


import Fabricas.Estructuras.Estructura;
import Fabricas.Unidades.Unidad;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class Warden implements Unidad{
    private final String nombre = "warden";
    private boolean estaHabilitado = false;
    private int vida, ataque;
    private int faseCreacion, tiempoCreacion = 3;
    
    public Warden(int fase) {
        this.faseCreacion = fase;
    }

    
    @Override
    public void atacar(Estructura estructura){
        
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

}
