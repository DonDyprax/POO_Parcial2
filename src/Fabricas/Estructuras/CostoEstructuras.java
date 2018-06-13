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
        }
    return null;
    }
}
