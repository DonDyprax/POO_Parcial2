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
public class Forge implements Estructura{
    private String nombre = "Forge";
    private int vida = 500, faseCreacion, tiempoCreacion = 1, metalGenerado = 40;
    
    public Forge(int fase){
        this.faseCreacion = fase;
    }
    
    @Override
    public Integer getRecursoGenerado(){
        return this.metalGenerado;
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
    public Integer getFaseCreacion() {
        return faseCreacion;
    }
    
    @Override
    public Integer getTiempoCreacion() {
        return tiempoCreacion;
    }
}
