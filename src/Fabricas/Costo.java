/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class Costo {
    private int oro, madera, metal;
    
    public Costo(int oro, int madera, int metal) {
        this.oro = oro;
        this.madera = madera;
        this.metal = metal;
    }
    
    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getMadera() {
        return madera;
    }

    public void setMadera(int madera) {
        this.madera = madera;
    }

    public int getMetal() {
        return metal;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }
}
