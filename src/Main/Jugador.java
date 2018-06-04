/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class Jugador {
    private String nombre, raza;
    private int oro, madera, metal;

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
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(int opc) {
        switch(opc){
            case 1:
                this.raza = "Humano";
                break;
            case 2:
                this.raza = "Elfo";
                break;
            case 3:
                this.raza = "Orco";
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }
    }
    
}
