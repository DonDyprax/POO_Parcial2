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
    private int vida = 2000, nivel = 1;
    private int oroMax = 10000, maderaMax = 5000, metalMax = 3000;
    
    @Override
    public Integer getNivel() {
        return this.nivel;
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
    public Integer getFaseCreacion(){
        return null;
    }
    
    @Override
    public Integer getTiempoCreacion(){
        return null;
    }
}
