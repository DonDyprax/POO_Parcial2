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
import java.util.Iterator;


/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class Jugador {
    AbstractFactory factoryUnidad = FactoryProducer.getFactory("unidad");
    AbstractFactory factoryEstructura = FactoryProducer.getFactory("estructura");
    private Jugador otroJugador;
    private String nombre, raza;
    private int oro, madera, metal;
    private ArrayList<Estructura> Estructuras = new ArrayList<>();
    private ArrayList<Unidad> Unidades = new ArrayList<>();
    private ArrayList<Unidad> unidadesEnProceso = new ArrayList<>();

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
        
        
        Iterator<Unidad> it = unidadesEnProceso.iterator();
        
        if(!unidadesEnProceso.isEmpty()){
            while(it.hasNext()){
                Unidad unidad = it.next();
                if(Main.fase == unidad.getFaseCreacion() + unidad.getTiempoCreacion()){
                    Unidades.add(unidad);
                    System.out.println(unidad.getNombre() + " esta listo para ser usado!");
                    it.remove();
                }
            }
        }
        
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
                                                unidadesEnProceso.add(factoryUnidad.getUnidad("militia")); 
                                                descontarCosto(CostoUnidades.getCosto("militia"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar una Militia");
                                            break;                                           

                                        case 2:
                                            if(validarCosto(CostoUnidades.getCosto("footman"))){
                                                unidadesEnProceso.add(factoryUnidad.getUnidad("footman")); 
                                                descontarCosto(CostoUnidades.getCosto("footman"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar un Footman");
                                            break;
                                        case 3:
                                            if(validarCosto(CostoUnidades.getCosto("paladin"))){
                                                unidadesEnProceso.add(factoryUnidad.getUnidad("paladin")); 
                                                descontarCosto(CostoUnidades.getCosto("paladin"));
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
                                                unidadesEnProceso.add(factoryUnidad.getUnidad("druid")); 
                                                descontarCosto(CostoUnidades.getCosto("druid"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar un Druid");
                                            break;
                                        case 2:
                                            if(validarCosto(CostoUnidades.getCosto("huntress"))){
                                                unidadesEnProceso.add(factoryUnidad.getUnidad("huntress")); 
                                                descontarCosto(CostoUnidades.getCosto("huntress"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar una Huntress");
                                            break;
                                        case 3:
                                            if(validarCosto(CostoUnidades.getCosto("warden"))){
                                                unidadesEnProceso.add(factoryUnidad.getUnidad("warden")); 
                                                descontarCosto(CostoUnidades.getCosto("warden"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para entrenar un Warden");
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("====================== Unidades de " + this.nombre + " =====================");
                            mostrarUnidades();
                            System.out.println("==================================================================");
                            break;
                        case 3:
                            mostrarEstructurasEnemigas(otroJugador);
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
    
    public void mostrarUnidades() {
        int u1 = 0, u2 = 0, u3 = 0;
        switch(this.raza){
            case "humanos":
                for(Unidad u : Unidades){
                    if(u.getNombre() != null) {
                        switch(u.getNombre()) {
                            case "militia":
                                u1 += 1;
                                break;
                            case "footman":
                                u2 += 1;
                                break;
                            case "paladin":
                                u3 += 1;
                                break;
                            default:
                                break;
                        }
                    }
                }
                System.out.println("Militia: " + u1);
                System.out.println("Footman: " + u2);
                System.out.println("Paladin: " + u3);
                break;
            
            case "elfos":
                for(Unidad u : Unidades){
                    if(u.getNombre() != null) {
                        switch(u.getNombre()) {
                            case "druid":
                                u1 += 1;
                                break;
                            case "huntress":
                                u2 += 1;
                                break;
                            case "warden":
                                u3 += 1;
                                break;
                            default:
                                break;
                        }
                    }
                }
                System.out.println("Druid: " + u1);
                System.out.println("Huntress: " + u2);
                System.out.println("Warden: " + u3);
                break;
            
            default:
                break;
        }
    }
    
    public void mostrarEstructurasEnemigas(Jugador jugador){
        System.out.println("====================== Estructuras de " + this.otroJugador.getNombre() + " =====================");
        for(int i = 0 ; i < jugador.getEstructuras().size() ; i++ ) {
            System.out.println(i+1 + ".) " + jugador.getEstructuras().get(i).getNombre() + " - Vida Restante: " + jugador.getEstructuras().get(i).getVida());
        }
        System.out.println("==================================================================");
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

    public Jugador getOtroJugador() {
        return otroJugador;
    }

    public void setOtroJugador(Jugador otroJugador) {
        this.otroJugador = otroJugador;
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
