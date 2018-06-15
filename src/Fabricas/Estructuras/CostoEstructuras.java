/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Estructuras;

import Fabricas.Costo;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class CostoEstructuras {
    private static Costo costoMine = new Costo(50, 50, 0);
    private static Costo costoSawmill = new Costo(50, 50, 0);
    private static Costo costoForge = new Costo(50, 50, 0);
    private static Costo costoBarracks = new Costo(50, 50, 0);
    private static Costo costoSanctuary = new Costo(50, 50, 0);
    private static Costo costoWorkshop = new Costo(50, 50, 0);
    private static Costo costoAncientOfLore = new Costo(50, 50, 0);
    private static Costo costoAncientOfWar = new Costo(50, 50, 0);
    private static Costo costoTreeOfLife = new Costo(50, 50, 0);
    private static Costo costoNecropolis = new Costo(50, 50, 0);
    private static Costo costoCrypt = new Costo(50, 50, 0);
    private static Costo costoSacrificialPit = new Costo(50, 50, 0);
    private static Costo costoGreatHall = new Costo(50, 50, 0);
    private static Costo costoVoodooLounge = new Costo(50, 50, 0);
    private static Costo costoSpiritLodge = new Costo(50, 50, 0);
    
    public static Costo getCosto(String type) {
        switch(type){
            case "mine":
                return costoMine;
            case "sawmill":
                return costoSawmill;
            case "forge":
                return costoForge;
            case "barracks":
                return costoBarracks;
            case "sanctuary":
                return costoSanctuary;
            case "workshop":
                return costoWorkshop;
            case "ancientoflore":
                return costoAncientOfLore;
            case "ancientofwar":
                return costoAncientOfWar;
            case "treeoflife":
                return costoTreeOfLife;
            case "necropolis":
                return costoNecropolis;
            case "crypt":
                return costoCrypt;
            case "sacrificialpit":
                return costoSacrificialPit;
            case "greathall":
                return costoGreatHall;
            case "voodoolounge":
                return costoVoodooLounge;
            case "spiritlodge":
                return costoSpiritLodge;
        }
    return null;
    }

    public static Costo getCostoMine() {
        return costoMine;
    }

    public static Costo getCostoSawmill() {
        return costoSawmill;
    }

    public static Costo getCostoForge() {
        return costoForge;
    }

    public static Costo getCostoBarracks() {
        return costoBarracks;
    }

    public static Costo getCostoSanctuary() {
        return costoSanctuary;
    }

    public static Costo getCostoWorkshop() {
        return costoWorkshop;
    }

    public static Costo getCostoAncientOfLore() {
        return costoAncientOfLore;
    }

    public static Costo getCostoAncientOfWar() {
        return costoAncientOfWar;
    }

    public static Costo getCostoTreeOfLife() {
        return costoTreeOfLife;
    }

    public static Costo getCostoNecropolis() {
        return costoNecropolis;
    }

    public static Costo getCostoCrypt() {
        return costoCrypt;
    }

    public static Costo getCostoSacrificialPit() {
        return costoSacrificialPit;
    }

    public static Costo getCostoGreatHall() {
        return costoGreatHall;
    }

    public static Costo getCostoVoodooLounge() {
        return costoVoodooLounge;
    }

    public static Costo getCostoSpiritLodge() {
        return costoSpiritLodge;
    }
    
    
}
