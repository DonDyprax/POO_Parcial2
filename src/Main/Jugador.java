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
import Fabricas.Estructuras.CostoEstructuras;
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
    private int oroTemp = 0, maderaTemp = 0, metalTemp = 0;
    private ArrayList<Estructura> Estructuras = new ArrayList<>();
    private ArrayList<Unidad> Unidades = new ArrayList<>();
    private ArrayList<Unidad> unidadesEnProceso = new ArrayList<>();
    private ArrayList<Estructura> estructurasEnProceso = new ArrayList<>();

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
        
        
        Iterator<Unidad> itU = unidadesEnProceso.iterator();
        Iterator<Estructura> itE = estructurasEnProceso.iterator();
        
        if(!Estructuras.isEmpty()){
            for(Estructura e : Estructuras){
                if("Mine".equals(e.getNombre()) || "Sawmill".equals(e.getNombre()) || "Forge".equals(e.getNombre())){
                    switch(e.getNombre()){
                        case "Mine":
                            this.oroTemp += e.getRecursoGenerado();
                            break;
                        case "Sawmill":
                            this.maderaTemp += e.getRecursoGenerado();
                            break;
                        case "Forge":
                            this.metalTemp += e.getRecursoGenerado();
                            break;
                    }
                }
            }
        }
        
        if(!unidadesEnProceso.isEmpty()){
            while(itU.hasNext()){
                Unidad unidad = itU.next();
                if(Main.fase == unidad.getFaseCreacion() + unidad.getTiempoCreacion()){
                    Unidades.add(unidad);
                    System.out.println(unidad.getNombre() + " esta listo para ser usado!");
                    itU.remove();
                }
            }
        }
        
        if(!estructurasEnProceso.isEmpty()){
            while(itE.hasNext()){
                Estructura estructura = itE.next();
                if(Main.fase == estructura.getFaseCreacion() + estructura.getTiempoCreacion()){
                    Estructuras.add(estructura);
                    System.out.println(estructura.getNombre() + " esta lista para ser usada!");
                    itE.remove();
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
                            switch (this.raza) {
                                case "humanos":
                                    menuEstructurasHumano();                                   
                                    opcTer = leer.nextInt();
                                    System.out.println("\n");
                                    switch(opcTer) {
                                        case 1:
                                            if(validarCosto(CostoEstructuras.getCosto("mine"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("mine")); 
                                                descontarCosto(CostoEstructuras.getCosto("mine"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir una Mine");
                                            break;                                           

                                        case 2:
                                            if(validarCosto(CostoEstructuras.getCosto("sawmill"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("sawmill")); 
                                                descontarCosto(CostoEstructuras.getCosto("sawmill"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir una Sawmill");
                                            break;
                                        case 3:
                                            if(validarCosto(CostoEstructuras.getCosto("forge"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("forge")); 
                                                descontarCosto(CostoEstructuras.getCosto("forge"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir una Forge");
                                            break;
                                        case 4:
                                            if(validarCosto(CostoEstructuras.getCosto("barracks"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("barracks")); 
                                                descontarCosto(CostoEstructuras.getCosto("barracks"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir un Barracks");
                                            break;
                                        case 5:
                                            if(validarCosto(CostoEstructuras.getCosto("sanctuary"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("sanctuary")); 
                                                descontarCosto(CostoEstructuras.getCosto("sanctuary"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir un Sanctuary");
                                            break;
                                        case 6:
                                            if(validarCosto(CostoEstructuras.getCosto("workshop"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("workshop")); 
                                                descontarCosto(CostoEstructuras.getCosto("workshop"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir una Workshop");
                                            break;
                                        case 7:
                                            break;
                                    }
                                    break;                                                                       
                            }
                            break;
                            
                        case 2:
                            System.out.println("Mostrar Estructuras");
                            System.out.println(Estructuras);
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
                                            if(!revisarEstructura("Barracks")) {
                                                System.out.println("Debes construir un Barracks para entrenar una Militia");
                                                break;
                                            } else {
                                                if(validarCosto(CostoUnidades.getCosto("militia"))){
                                                    unidadesEnProceso.add(factoryUnidad.getUnidad("militia")); 
                                                    descontarCosto(CostoUnidades.getCosto("militia"));
                                                    break;
                                                } else {
                                                    System.out.println("No tienes suficientes recursos para entrenar una Militia");
                                                }                                  
                                            }
                                            break;                                           

                                        case 2:
                                            if(!revisarEstructura("Barracks")) {
                                                System.out.println("Debes construir un Barracks para entrenar un Footman");
                                                break;
                                            } else {
                                                if(validarCosto(CostoUnidades.getCosto("footman"))){
                                                    unidadesEnProceso.add(factoryUnidad.getUnidad("footman")); 
                                                    descontarCosto(CostoUnidades.getCosto("footman"));
                                                    break;
                                                } else {
                                                    System.out.println("No tienes suficientes recursos para entrenar un Footman");
                                                }                                  
                                            }
                                            break;
                                            
                                        case 3:
                                            if(revisarSpecialist("paladin")) {
                                                System.out.println("Solo se puede tener un Paladin a la vez");
                                            }
                                            else {
                                                if(!revisarEstructura("Sanctuary")) {
                                                System.out.println("Debes construir un Sanctuary para entrenar un Paladin");
                                                break;
                                                } else {
                                                    if(validarCosto(CostoUnidades.getCosto("paladin"))){
                                                        unidadesEnProceso.add(factoryUnidad.getUnidad("paladin")); 
                                                        descontarCosto(CostoUnidades.getCosto("paladin"));
                                                        break;
                                                    } else {
                                                        System.out.println("No tienes suficientes recursos para entrenar un Paladin");
                                                    }                                  
                                                }
                                            }
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
                            if(Unidades.isEmpty()){
                                System.out.println("No tienes ninguna unidad para poder atacar");
                                break;
                            }
                            else{
                                mostrarEstructurasEnemigas(otroJugador);
                            }
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
                    recolectarRecursos();
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
        System.out.println("1.) Militia (Requiere: Barracks)");
        System.out.println("2.) Footman (Requiere: Barracks");
        System.out.println("3.) Paladin - Specialist (Requiere: Sanctuary)");
        System.out.println("4.) Atras");
        System.out.print("Elija una opcion: ");
    }
    
    public void menuEstructurasHumano() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Mine");
        System.out.println("2.) Sawmill");
        System.out.println("3.) Forge");
        System.out.println("4.) Barracks");
        System.out.println("5.) Sanctuary");
        System.out.println("6.) Workshop");
        System.out.println("7.) Atras");
        System.out.print("Elija una opcion: ");
    }

    public void menuUnidadesElfo() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Druid");
        System.out.println("2.) Huntress");
        System.out.println("3.) Warden - Specialist");
        System.out.println("4.) Atras");
        System.out.print("Elija una opcion: ");
    }
    
    public void recolectarRecursos(){
        this.oro += this.oroTemp;
        this.oroTemp = 0;
        this.madera += this.maderaTemp;
        this.maderaTemp = 0;
        this.metal += this.metalTemp;
        this.metalTemp = 0;
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
        System.out.println("====================== Estructuras de " + this.otroJugador.getNombre() + " ======================");
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
    
    public boolean revisarEstructura(String nombre){
        for(int i = 0 ; i < Estructuras.size() ; i++) {
            if(nombre.equals(Estructuras.get(i).getNombre())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean revisarSpecialist(String nombre) {       
        for(int i = 0 ; i < unidadesEnProceso.size() ; i++){
            if(nombre.equals(unidadesEnProceso.get(i).getNombre())){
                return true;
            }
        }
        
        for(int i = 0 ; i < Unidades.size() ; i++) {
            if(nombre.equals(Unidades.get(i).getNombre())) {
                return true;
            }
        }
        
        return false;
    }
    
    
}
