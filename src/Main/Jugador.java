/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Fabricas.Estructuras.Estructura;
import Fabricas.Unidades.Unidad;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class Jugador {
    private String nombre, raza;
    private int oro, madera, metal;
    private ArrayList<Estructura> Estructuras = new ArrayList<>();
    private ArrayList<Unidad> Unidades = new ArrayList<>();

    public Jugador() {
        this.oro = 200;
        this.madera = 200;
        this.metal = 200;
    }
    
    public void realizarTurno(){
        int opc = 0, opcSec = 0;
        Scanner leer = new Scanner(System.in);
        
        while(opc != 4){
            System.out.println("====================" + "Turno de " + nombre + "====================");
            System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
            System.out.print("\n");
            System.out.println("1.) Administrar Estructuras");
            System.out.println("2.) Administrar Unidades");
            System.out.println("3.) Recolectar Recursos");
            System.out.println("4.) Finalizar Turno");

            System.out.print("Que desea hacer?: ");
            opc = leer.nextInt();
            System.out.print("\n");
            switch(opc){
                case 1:
                    System.out.println("====================" + "Turno de " + nombre + "====================");
                    System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
                    System.out.print("\n");
                    System.out.println("1.) Construir Estructura");
                    System.out.println("2.) Mostrar Estructuras");
                    System.out.println("3.) Mejorar Centro de Mando");
                    System.out.println("4.) Atras");
                    System.out.print("Elija una opcion: ");
                    opcSec = leer.nextInt();
                    System.out.println("\n");
                    
                    switch(opcSec){
                        case 1:
                            System.out.println("Construir Estructura");
                            System.out.println("\n");
                            break;
                        case 2:
                            System.out.println("Mostrar Estructuras");
                            System.out.println("\n");
                            break;
                        case 3:
                            System.out.println("Mejorar Centro de Mando");
                            System.out.println("\n");
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Elija una opcion valida");
                            System.out.println("\n");
                    };
            }
        }
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
            case 4:
                this.raza = "Undead";
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }
    }
    
}
