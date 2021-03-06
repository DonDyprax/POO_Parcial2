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
public class Acolyte implements Unidad{
    private final String nombre = "acolyte";
    private int vida, ataqueUnidad, ataqueEstructura = 50;
    private int faseCreacion, faseAtaque, tiempoCreacion = 1;
    
    public Acolyte(int fase) {
        this.faseCreacion = fase;
    }
    
    @Override
    public void setFaseAtaque(int fase){
        this.faseAtaque = fase;
    }
    
    @Override
    public void atacar(Estructura estructura){
        estructura.setVida(estructura.getVida() - this.ataqueEstructura);
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
