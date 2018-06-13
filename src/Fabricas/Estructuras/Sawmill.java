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
public class Sawmill implements Estructura{
    private String nombre = "Sawmill";
    private int vida = 400, faseCreacion, tiempoCreacion = 1, maderaGenerada = 40;
    
    public Sawmill(int fase){
        this.faseCreacion = fase;
    }
    
    @Override
    public Integer getRecursoGenerado(){
        return this.maderaGenerada;
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
