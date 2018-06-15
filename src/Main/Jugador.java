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
                    System.out.println("3.) Mejorar Centro de Mando - Nivel Actual: " + Estructuras.get(0).getNivel());
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
                                    
                                case "elfos":
                                    menuEstructurasElfo();                                   
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
                                            if(validarCosto(CostoEstructuras.getCosto("ancientoflore"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("ancientoflore")); 
                                                descontarCosto(CostoEstructuras.getCosto("ancientoflore"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir un Ancient Of Lore");
                                            break;
                                        case 5:
                                            if(validarCosto(CostoEstructuras.getCosto("ancientofwar"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("ancientofwar")); 
                                                descontarCosto(CostoEstructuras.getCosto("ancientofwar"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir un Ancient Of War");
                                            break;
                                        case 6:
                                            if(validarCosto(CostoEstructuras.getCosto("treeoflife"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("treeoflife")); 
                                                descontarCosto(CostoEstructuras.getCosto("treeoflife"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir un Tree Of Life");
                                            break;
                                        case 7:
                                            break;
                                    }
                                    break;
                                    
                                case "orcos":
                                    menuEstructurasOrco();                                   
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
                                            if(validarCosto(CostoEstructuras.getCosto("greathall"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("greathall")); 
                                                descontarCosto(CostoEstructuras.getCosto("greathall"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir un Great Hall");
                                            break;
                                        case 5:
                                            if(validarCosto(CostoEstructuras.getCosto("voodolounge"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("voodoolounge")); 
                                                descontarCosto(CostoEstructuras.getCosto("voodoolounge"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir un Voodoo Lounge");
                                            break;
                                        case 6:
                                            if(validarCosto(CostoEstructuras.getCosto("spiritlodge"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("spiritlodge")); 
                                                descontarCosto(CostoEstructuras.getCosto("spiritlodge"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir un Spirit Lodge");
                                            break;
                                        case 7:
                                            break;
                                    }
                                    break; 
                                    
                                case "undead":
                                    menuEstructurasUndead();                                   
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
                                            if(validarCosto(CostoEstructuras.getCosto("necropolis"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("necropolis")); 
                                                descontarCosto(CostoEstructuras.getCosto("necropolis"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir una Necropolis");
                                            break;
                                        case 5:
                                            if(validarCosto(CostoEstructuras.getCosto("crypt"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("crypt")); 
                                                descontarCosto(CostoEstructuras.getCosto("crypt"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir una Crypt");
                                            break;
                                        case 6:
                                            if(validarCosto(CostoEstructuras.getCosto("sacrificialpit"))){
                                                estructurasEnProceso.add(factoryEstructura.getEstructura("sacrificialpit")); 
                                                descontarCosto(CostoEstructuras.getCosto("sacrificialpit"));
                                                break;
                                            }
                                            System.out.println("No tienes suficientes recursos para construir un Sacrificial Pit");
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
                            switch(Estructuras.get(0).getNivel()) {
                                case 1:
                                    
                            }
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
                                            if(!revisarEstructura("AncientOfLore")) {
                                                System.out.println("Debes construir un Ancient Of Lore para entrenar un Druid");
                                                break;
                                            } else {
                                                if(validarCosto(CostoUnidades.getCosto("druid"))){
                                                    unidadesEnProceso.add(factoryUnidad.getUnidad("druid")); 
                                                    descontarCosto(CostoUnidades.getCosto("druid"));
                                                    break;
                                                } else {
                                                    System.out.println("No tienes suficientes recursos para entrenar un Druid");
                                                }                                  
                                            }
                                            break;                                           

                                        case 2:
                                            if(!revisarEstructura("AncientOfWar")) {
                                                System.out.println("Debes construir un Ancient Of War para entrenar una Huntress");
                                                break;
                                            } else {
                                                if(validarCosto(CostoUnidades.getCosto("huntress"))){
                                                    unidadesEnProceso.add(factoryUnidad.getUnidad("huntress")); 
                                                    descontarCosto(CostoUnidades.getCosto("huntress"));
                                                    break;
                                                } else {
                                                    System.out.println("No tienes suficientes recursos para entrenar una Huntress");
                                                }                                  
                                            }
                                            break;
                                            
                                        case 3:
                                            if(revisarSpecialist("warden")) {
                                                System.out.println("Solo se puede tener un Warden a la vez");
                                            }
                                            else {
                                                if(!revisarEstructura("TreeOfLife")) {
                                                System.out.println("Debes construir un Tree Of Life para entrenar un Warden");
                                                break;
                                                } else {
                                                    if(validarCosto(CostoUnidades.getCosto("warden"))){
                                                        unidadesEnProceso.add(factoryUnidad.getUnidad("warden")); 
                                                        descontarCosto(CostoUnidades.getCosto("warden"));
                                                        break;
                                                    } else {
                                                        System.out.println("No tienes suficientes recursos para entrenar un Warden");
                                                    }                                  
                                                }
                                            }
                                            break;
                                            
                                    }
                                    break;
                                    
                                case "orcos":
                                    menuUnidadesOrco();                                   
                                    opcTer = leer.nextInt();
                                    System.out.println("\n");
                                    switch(opcTer) {
                                        case 1:
                                            if(!revisarEstructura("GreatHall")) {
                                                System.out.println("Debes construir un Great Hall para entrenar un Grunt");
                                                break;
                                            } else {
                                                if(validarCosto(CostoUnidades.getCosto("grunt"))){
                                                    unidadesEnProceso.add(factoryUnidad.getUnidad("grunt")); 
                                                    descontarCosto(CostoUnidades.getCosto("grunt"));
                                                    break;
                                                } else {
                                                    System.out.println("No tienes suficientes recursos para entrenar un Grunt");
                                                }                                  
                                            }
                                            break;                                           

                                        case 2:
                                            if(!revisarEstructura("VoodooLounge")) {
                                                System.out.println("Debes construir un Voodoo Lounge para entrenar un Shaman");
                                                break;
                                            } else {
                                                if(validarCosto(CostoUnidades.getCosto("shaman"))){
                                                    unidadesEnProceso.add(factoryUnidad.getUnidad("shaman")); 
                                                    descontarCosto(CostoUnidades.getCosto("shaman"));
                                                    break;
                                                } else {
                                                    System.out.println("No tienes suficientes recursos para entrenar un Shaman");
                                                }                                  
                                            }
                                            break;
                                            
                                        case 3:
                                            if(revisarSpecialist("blademaster")) {
                                                System.out.println("Solo se puede tener un Blademaster a la vez");
                                            }
                                            else {
                                                if(!revisarEstructura("SpiritLodge")) {
                                                System.out.println("Debes construir un Spirit Lodge para entrenar un Blademaster");
                                                break;
                                                } else {
                                                    if(validarCosto(CostoUnidades.getCosto("blademaster"))){
                                                        unidadesEnProceso.add(factoryUnidad.getUnidad("blademaster")); 
                                                        descontarCosto(CostoUnidades.getCosto("blademaster"));
                                                        break;
                                                    } else {
                                                        System.out.println("No tienes suficientes recursos para entrenar un Blademaster");
                                                    }                                  
                                                }
                                            }
                                            break;
                                            
                                    }
                                    break;
                                    
                                case "undead":
                                    menuUnidadesUndead();                                   
                                    opcTer = leer.nextInt();
                                    System.out.println("\n");
                                    switch(opcTer) {
                                        case 1:
                                            if(!revisarEstructura("Necropolis")) {
                                                System.out.println("Debes construir una Necropolis para entrenar un Acolyte");
                                                break;
                                            } else {
                                                if(validarCosto(CostoUnidades.getCosto("acolyte"))){
                                                    unidadesEnProceso.add(factoryUnidad.getUnidad("acolyte")); 
                                                    descontarCosto(CostoUnidades.getCosto("acolyte"));
                                                    break;
                                                } else {
                                                    System.out.println("No tienes suficientes recursos para entrenar un Acolyte");
                                                }                                  
                                            }
                                            break;                                           

                                        case 2:
                                            if(!revisarEstructura("Crypt")) {
                                                System.out.println("Debes construir una Crypt para entrenar un Necromancer");
                                                break;
                                            } else {
                                                if(validarCosto(CostoUnidades.getCosto("necromancer"))){
                                                    unidadesEnProceso.add(factoryUnidad.getUnidad("necromancer")); 
                                                    descontarCosto(CostoUnidades.getCosto("necromancer"));
                                                    break;
                                                } else {
                                                    System.out.println("No tienes suficientes recursos para entrenar un Necromancer");
                                                }                                  
                                            }
                                            break;
                                            
                                        case 3:
                                            if(revisarSpecialist("deathknight")) {
                                                System.out.println("Solo se puede tener un Death Knight a la vez");
                                            }
                                            else {
                                                if(!revisarEstructura("SacrificialPit")) {
                                                System.out.println("Debes construir un Sacrificial Pit para entrenar un Death Knight");
                                                break;
                                                } else {
                                                    if(validarCosto(CostoUnidades.getCosto("deathknight"))){
                                                        unidadesEnProceso.add(factoryUnidad.getUnidad("deathknight")); 
                                                        descontarCosto(CostoUnidades.getCosto("deathknight"));
                                                        break;
                                                    } else {
                                                        System.out.println("No tienes suficientes recursos para entrenar un Death Knight");
                                                    }                                  
                                                }
                                            }
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
        System.out.println("1.) Militia (Requiere: Barracks) - Costo(Oro: " + CostoUnidades.getCostoMilitia().getOro() + " Madera: " + CostoUnidades.getCostoMilitia().getMadera() + " Metal: " + CostoUnidades.getCostoMilitia().getMetal() + ")");
        System.out.println("2.) Footman (Requiere: Barracks) - Costo(Oro: " + CostoUnidades.getCostoFootman().getOro() + " Madera: " + CostoUnidades.getCostoFootman().getMadera() + " Metal: " + CostoUnidades.getCostoFootman().getMetal() + ")");
        System.out.println("3.) Paladin - Specialist (Requiere: Sanctuary) - Costo(Oro: " + CostoUnidades.getCostoPaladin().getOro() + " Madera: " + CostoUnidades.getCostoPaladin().getMadera() + " Metal: " + CostoUnidades.getCostoPaladin().getMetal() + ")");
        System.out.println("4.) Atras");
        System.out.print("Elija una opcion: ");
    }
    
    public void menuEstructurasHumano() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Mine - Costo(Oro: " + CostoEstructuras.getCostoMine().getOro() + " Madera: " + CostoEstructuras.getCostoMine().getMadera() + " Metal: " + CostoEstructuras.getCostoMine().getMetal() + ")");
        System.out.println("2.) Sawmill - Costo(Oro: " + CostoEstructuras.getCostoSawmill().getOro() + " Madera: " + CostoEstructuras.getCostoSawmill().getMadera() + " Metal: " + CostoEstructuras.getCostoSawmill().getMetal() + ")");
        System.out.println("3.) Forge - Costo(Oro: " + CostoEstructuras.getCostoForge().getOro() + " Madera: " + CostoEstructuras.getCostoForge().getMadera() + " Metal: " + CostoEstructuras.getCostoForge().getMetal() + ")");
        System.out.println("4.) Barracks - Costo(Oro: " + CostoEstructuras.getCostoBarracks().getOro() + " Madera: " + CostoEstructuras.getCostoBarracks().getMadera() + " Metal: " + CostoEstructuras.getCostoBarracks().getMetal() + ")");
        System.out.println("5.) Sanctuary - Costo(Oro: " + CostoEstructuras.getCostoSanctuary().getOro() + " Madera: " + CostoEstructuras.getCostoSanctuary().getMadera() + " Metal: " + CostoEstructuras.getCostoSanctuary().getMetal() + ")");
        System.out.println("6.) Workshop - Costo(Oro: " + CostoEstructuras.getCostoWorkshop().getOro() + " Madera: " + CostoEstructuras.getCostoWorkshop().getMadera() + " Metal: " + CostoEstructuras.getCostoWorkshop().getMetal() + ")");
        System.out.println("7.) Atras");
        System.out.print("Elija una opcion: ");
    }

    public void menuUnidadesElfo() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Druid (Requiere: Ancient of Lore) - Costo(Oro: " + CostoUnidades.getCostoDruid().getOro() + " Madera: " + CostoUnidades.getCostoDruid().getMadera() + " Metal: " + CostoUnidades.getCostoDruid().getMetal() + ")");
        System.out.println("2.) Huntress (Requiere: Ancient of War) - Costo(Oro: " + CostoUnidades.getCostoHuntress().getOro() + " Madera: " + CostoUnidades.getCostoHuntress().getMadera() + " Metal: " + CostoUnidades.getCostoHuntress().getMetal() + ")");
        System.out.println("3.) Warden - Specialist (Requiere: Tree of Life) - Costo(Oro: " + CostoUnidades.getCostoWarden().getOro() + " Madera: " + CostoUnidades.getCostoWarden().getMadera() + " Metal: " + CostoUnidades.getCostoWarden().getMetal() + ")");
        System.out.println("4.) Atras");
        System.out.print("Elija una opcion: ");
    }
    
    public void menuEstructurasElfo() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Mine - Costo(Oro: " + CostoEstructuras.getCostoMine().getOro() + " Madera: " + CostoEstructuras.getCostoMine().getMadera() + " Metal: " + CostoEstructuras.getCostoMine().getMetal() + ")");
        System.out.println("2.) Sawmill - Costo(Oro: " + CostoEstructuras.getCostoSawmill().getOro() + " Madera: " + CostoEstructuras.getCostoSawmill().getMadera() + " Metal: " + CostoEstructuras.getCostoSawmill().getMetal() + ")");
        System.out.println("3.) Forge - Costo(Oro: " + CostoEstructuras.getCostoForge().getOro() + " Madera: " + CostoEstructuras.getCostoForge().getMadera() + " Metal: " + CostoEstructuras.getCostoForge().getMetal() + ")");
        System.out.println("4.) Ancient of Lore - Costo(Oro: " + CostoEstructuras.getCostoAncientOfLore().getOro() + " Madera: " + CostoEstructuras.getCostoAncientOfLore().getMadera() + " Metal: " + CostoEstructuras.getCostoAncientOfLore().getMetal() + ")");
        System.out.println("5.) Ancient of War - Costo(Oro: " + CostoEstructuras.getCostoAncientOfWar().getOro() + " Madera: " + CostoEstructuras.getCostoAncientOfWar().getMadera() + " Metal: " + CostoEstructuras.getCostoAncientOfWar().getMetal() + ")");
        System.out.println("6.) Tree of Life - Costo(Oro: " + CostoEstructuras.getCostoTreeOfLife().getOro() + " Madera: " + CostoEstructuras.getCostoTreeOfLife().getMadera() + " Metal: " + CostoEstructuras.getCostoTreeOfLife().getMetal() + ")");
        System.out.println("7.) Atras");
        System.out.print("Elija una opcion: ");
    }
    
    public void menuUnidadesOrco() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Grunt (Requiere: Great Hall) - Costo(Oro: " + CostoUnidades.getCostoGrunt().getOro() + " Madera: " + CostoUnidades.getCostoGrunt().getMadera() + " Metal: " + CostoUnidades.getCostoGrunt().getMetal() + ")");
        System.out.println("2.) Shaman (Requiere: Voodoo Lounge) - Costo(Oro: " + CostoUnidades.getCostoShaman().getOro() + " Madera: " + CostoUnidades.getCostoShaman().getMadera() + " Metal: " + CostoUnidades.getCostoShaman().getMetal() + ")");
        System.out.println("3.) Blademaster - Specialist (Requiere: Spirit Lodge) - Costo(Oro: " + CostoUnidades.getCostoBlademaster().getOro() + " Madera: " + CostoUnidades.getCostoBlademaster().getMadera() + " Metal: " + CostoUnidades.getCostoBlademaster().getMetal() + ")");
        System.out.println("4.) Atras");
        System.out.print("Elija una opcion: ");
    }
    
    public void menuEstructurasOrco() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Mine - Costo(Oro: " + CostoEstructuras.getCostoMine().getOro() + " Madera: " + CostoEstructuras.getCostoMine().getMadera() + " Metal: " + CostoEstructuras.getCostoMine().getMetal() + ")");
        System.out.println("2.) Sawmill - Costo(Oro: " + CostoEstructuras.getCostoSawmill().getOro() + " Madera: " + CostoEstructuras.getCostoSawmill().getMadera() + " Metal: " + CostoEstructuras.getCostoSawmill().getMetal() + ")");
        System.out.println("3.) Forge - Costo(Oro: " + CostoEstructuras.getCostoForge().getOro() + " Madera: " + CostoEstructuras.getCostoForge().getMadera() + " Metal: " + CostoEstructuras.getCostoForge().getMetal() + ")");
        System.out.println("4.) Great Hall - Costo(Oro: " + CostoEstructuras.getCostoGreatHall().getOro() + " Madera: " + CostoEstructuras.getCostoGreatHall().getMadera() + " Metal: " + CostoEstructuras.getCostoGreatHall().getMetal() + ")");
        System.out.println("5.) Voodoo Lounge - Costo(Oro: " + CostoEstructuras.getCostoVoodooLounge().getOro() + " Madera: " + CostoEstructuras.getCostoVoodooLounge().getMadera() + " Metal: " + CostoEstructuras.getCostoVoodooLounge().getMetal() + ")");
        System.out.println("6.) Spirit Lodge - Costo(Oro: " + CostoEstructuras.getCostoSpiritLodge().getOro() + " Madera: " + CostoEstructuras.getCostoSpiritLodge().getMadera() + " Metal: " + CostoEstructuras.getCostoSpiritLodge().getMetal() + ")");
        System.out.println("7.) Atras");
        System.out.print("Elija una opcion: ");
    }
    
    public void menuUnidadesUndead() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Acolyte (Requiere: Necropolis) - Costo(Oro: " + CostoUnidades.getCostoAcolyte().getOro() + " Madera: " + CostoUnidades.getCostoAcolyte().getMadera() + " Metal: " + CostoUnidades.getCostoAcolyte().getMetal() + ")");
        System.out.println("2.) Necromancer (Requiere: Crypt) - Costo(Oro: " + CostoUnidades.getCostoNecromancer().getOro() + " Madera: " + CostoUnidades.getCostoNecromancer().getMadera() + " Metal: " + CostoUnidades.getCostoNecromancer().getMetal() + ")");
        System.out.println("3.) Death Knight - Specialist (Requiere: Sacrificial Pit) - Costo(Oro: " + CostoUnidades.getCostoDeathKnight().getOro() + " Madera: " + CostoUnidades.getCostoDeathKnight().getMadera() + " Metal: " + CostoUnidades.getCostoDeathKnight().getMetal() + ")");
        System.out.println("4.) Atras");
        System.out.print("Elija una opcion: ");
    }
    
    public void menuEstructurasUndead() {
        System.out.println("====== Fase " + Main.fase + " ==========" + "Turno de " + nombre + "======== " + this.raza.toUpperCase() +" =======");
        System.out.println("Oro: " + oro + "\t" + "Madera: " + madera + "\t" + "\t" + "Metal: " + metal);
        System.out.print("\n");
        System.out.println("1.) Mine - Costo(Oro: " + CostoEstructuras.getCostoMine().getOro() + " Madera: " + CostoEstructuras.getCostoMine().getMadera() + " Metal: " + CostoEstructuras.getCostoMine().getMetal() + ")");
        System.out.println("2.) Sawmill - Costo(Oro: " + CostoEstructuras.getCostoSawmill().getOro() + " Madera: " + CostoEstructuras.getCostoSawmill().getMadera() + " Metal: " + CostoEstructuras.getCostoSawmill().getMetal() + ")");
        System.out.println("3.) Forge - Costo(Oro: " + CostoEstructuras.getCostoForge().getOro() + " Madera: " + CostoEstructuras.getCostoForge().getMadera() + " Metal: " + CostoEstructuras.getCostoForge().getMetal() + ")");
        System.out.println("4.) Necropolis - Costo(Oro: " + CostoEstructuras.getCostoNecropolis().getOro() + " Madera: " + CostoEstructuras.getCostoNecropolis().getMadera() + " Metal: " + CostoEstructuras.getCostoNecropolis().getMetal() + ")");
        System.out.println("5.) Crypt - Costo(Oro: " + CostoEstructuras.getCostoCrypt().getOro() + " Madera: " + CostoEstructuras.getCostoCrypt().getMadera() + " Metal: " + CostoEstructuras.getCostoCrypt().getMetal() + ")");
        System.out.println("6.) Sacrificial Pit - Costo(Oro: " + CostoEstructuras.getCostoSacrificialPit().getOro() + " Madera: " + CostoEstructuras.getCostoSacrificialPit().getMadera() + " Metal: " + CostoEstructuras.getCostoSacrificialPit().getMetal() + ")");
        System.out.println("7.) Atras");
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
                
            case "undead":
                for(Unidad u : Unidades){
                    if(u.getNombre() != null) {
                        switch(u.getNombre()) {
                            case "acolyte":
                                u1 += 1;
                                break;
                            case "necromancer":
                                u2 += 1;
                                break;
                            case "deathknight":
                                u3 += 1;
                                break;
                            default:
                                break;
                        }
                    }
                }
                System.out.println("Acolyte: " + u1);
                System.out.println("Necromancer: " + u2);
                System.out.println("Death Knight: " + u3);
                break;
                
            case "orcos":
                for(Unidad u : Unidades){
                    if(u.getNombre() != null) {
                        switch(u.getNombre()) {
                            case "grunt":
                                u1 += 1;
                                break;
                            case "shaman":
                                u2 += 1;
                                break;
                            case "blademaster":
                                u3 += 1;
                                break;
                            default:
                                break;
                        }
                    }
                }
                System.out.println("Grunt: " + u1);
                System.out.println("Shaman: " + u2);
                System.out.println("Blademaster: " + u3);
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
