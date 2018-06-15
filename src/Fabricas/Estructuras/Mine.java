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
public class Mine implements Estructura{
    private String nombre = "Mine";
    private int vida = 600, faseCreacion, tiempoCreacion = 1, oroGenerado = 300;
    
    public Mine(int fase){
        this.faseCreacion = fase;
    }
    
    @Override
    public Integer getNivel() {
        return null;
    }
    
    @Override
    public Integer getRecursoGenerado(){
        return this.oroGenerado;
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
