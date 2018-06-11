/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Fabricas.AbstractFactory;
import Fabricas.Estructuras.Estructura;
import Fabricas.FactoryProducer;
import Fabricas.Unidades.Unidad;
import java.util.ArrayList;
import java.util.Scanner;
import Fabricas.Costo;
import Fabricas.Unidades.CostoUnidades;


/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class Jugador {
    AbstractFactory factoryUnidad = FactoryProducer.getFactory("unidad");
    AbstractFactory factoryEstructura = FactoryProducer.getFactory("estructura");
    private String nombre, raza;
    private int oro, madera, metal;
    private ArrayList<Estructura> Estructuras = new ArrayList<>();
    private ArrayList<Unidad> Unidades = new ArrayList<>();

    public ArrayList<Estructura> getEstructuras() {
        return Estructuras;
    }

    public ArrayList<Unidad> getUnidades() {
        return Unidades;
    }

    public Jugador() {

        Estructuras.add(factoryEstructura.getEstructura("townCenter"));

        this.oro = 200;
        this.madera = 200;
        this.metal = 200;
    }

    public void realizarTurno() {
        int opc = 0, opcSec, opcTer;
        Scanner leer = new Scanner(System.in);

        while (opc != 4) {
            System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
            System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
            System.out.print("\n");
            System.out.println("1.) Administrar Estructuras");
            System.out.println("2.) Administrar Unidades");
            System.out.println("3.) Recolectar Recursos");
            System.out.println("4.) Finalizar Turno");

            System.out.print("Que desea hacer?: ");
            opc = leer.nextInt();
            System.out.print("\n");

            switch (opc) {
                case 1:
                    System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
                    System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
                    System.out.print("\n");
                    System.out.println("1.) Construir Estructura");
                    System.out.println("2.) Mostrar Estructuras");
                    System.out.println("3.) Mejorar Centro de Mando");
                    System.out.println("4.) Atras");
                    System.out.print("Elija una opcion: ");
                    opcSec = leer.nextInt();
                    System.out.println("\n");

                    switch (opcSec) {
                        case 1:
                            System.out.println("Construir Estructura");
                            System.out.println("\n");
                            Estructuras.clear();
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
                    }
                    break;

                case 2:
                    System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
                    System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
                    System.out.print("\n");
                    System.out.println("1.) Entrenar Unidad");
                    System.out.println("2.) Mostrar Unidades");
                    System.out.println("3.) Enviar a atacar");
                    System.out.println("4.) Atras");
                    System.out.print("Elija una opcion: ");
                    opcSec = leer.nextInt();
                    System.out.println("\n");

                    switch (opcSec) {
                        case 1:
                            System.out.println("Entrenar Unidad");
                            System.out.println("\n");
                            switch (this.raza) {
                                case "humanos":
                                    menuUnidadesHumano();                                   
                                    opcTer = leer.nextInt();
                                    System.out.println("\n");
                                    switch(opcTer) {
                                        case 1:
                                            if(validarCosto(CostoUnidades.getCosto("militia"))){
                                                Unidades.add(factoryUnidad.getUnidad("militia")); 
                                                descontarCosto(CostoUnidades.getCosto("militia"));
                                                System.out.println("Se ha entrenado una Militia");
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar una Militia");
                                            break;                                           

                                        case 2:
                                            if(validarCosto(CostoUnidades.getCosto("footman"))){
                                                Unidades.add(factoryUnidad.getUnidad("footman")); 
                                                descontarCosto(CostoUnidades.getCosto("footman"));
                                                System.out.println("Se ha entrenado un Footman");
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar un Footman");
                                            break;
                                        case 3:
                                            if(validarCosto(CostoUnidades.getCosto("paladin"))){
                                                Unidades.add(factoryUnidad.getUnidad("paladin")); 
                                                descontarCosto(CostoUnidades.getCosto("paladin"));
                                                System.out.println("Se ha entrenado un Paladin");
                                                break;
                                            }                                           
                                            System.out.println("No tienes suficientes recursos para entrenar un Paladin");
                                            break;
                                    }
                                    break;
                                        
                                case "elfos":
                                    menuUnidadesElfo();
                                    opcTer = leer.nextInt();
                                    System.out.println("\n");
                                    switch(opcTer) {
                                        case 1:
                                            if(validarCosto(CostoUnidades.getCosto("druid"))){
                                                Unidades.add(factoryUnidad.getUnidad("druid")); 
                                                descontarCosto(CostoUnidades.getCosto("druid"));
                                                System.out.println("Se ha entrenado un Druid");
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar un Druid");
                                            break;
                                        case 2:
                                            if(validarCosto(CostoUnidades.getCosto("huntress"))){
                                                Unidades.add(factoryUnidad.getUnidad("huntress")); 
                                                descontarCosto(CostoUnidades.getCosto("huntress"));
                                                System.out.println("Se ha entrenado una Huntress");
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar una Huntress");
                                            break;
                                        case 3:
                                            if(validarCosto(CostoUnidades.getCosto("warden"))){
                                                Unidades.add(factoryUnidad.getUnidad("warden")); 
                                                descontarCosto(CostoUnidades.getCosto("warden"));
                                                System.out.println("Se ha entrenado un Warden");
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar un Warden");
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Mostrar Unidades");
                            System.out.println("\n");
                            break;
                        case 3:
                            System.out.println("Enviar a atacar");
                            System.out.println("\n");
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Elija una opcion valida");
                            System.out.println("\n");
                    }
                    break;

                case 3:
                    System.out.println("Recursos recolectados");
                    System.out.print("\n");
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Elija una opcion valida");
            }

        }
    }

    public void menuUnidadesHumano() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Militia");
        System.out.println("2.) Footman");
        System.out.println("3.) Paladin");
        System.out.println("4.) Atras");
        System.out.print("Elija una opcion: ");
    }

    public void menuUnidadesElfo() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Druid");
        System.out.println("2.) Huntress");
        System.out.println("3.) Warden");
        System.out.println("4.) Atras");
        System.out.print("Elija una opcion: ");
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
    
    public void descontarCosto(Costo costo) {
        this.oro -= costo.getOro();
        this.madera -= costo.getMadera();
        this.metal -= costo.getMetal();
    }
    
    public boolean validarCosto(Costo costo) {
        return this.oro >= costo.getOro() && this.madera >= costo.getMadera() && this.metal >= costo.getMetal();
    }

    public void setRaza(int opc) {
        switch (opc) {
            case 1:
                this.raza = "humanos";
                break;
            case 2:
                this.raza = "elfos";
                break;
            case 3:
                this.raza = "orcos";
                break;
            case 4:
                this.raza = "undead";
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }
    }

}
