/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Unidades;

import Fabricas.Costo;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class CostoUnidades {
    private static Costo costoMilitia = new Costo(50, 50, 0);
    private static Costo costoFootman = new Costo(50, 50, 0);
    private static Costo costoPaladin = new Costo(50, 50, 0);
    private static Costo costoDruid = new Costo(50, 50, 0);
    private static Costo costoHuntress = new Costo(50, 50, 0);
    private static Costo costoWarden = new Costo(50, 50, 0);
    private static Costo costoAcolyte = new Costo(50, 50, 0);
    private static Costo costoDeathKnight = new Costo(50, 50, 0);
    private static Costo costoNecromancer = new Costo(50, 50, 0);
    private static Costo costoGrunt = new Costo(50, 50, 0);
    private static Costo costoShaman = new Costo(50, 50, 0);
    private static Costo costoBlademaster = new Costo(50, 50, 0); 
    
    public static Costo getCosto(String type) {
        switch(type){
            case "militia":
                return costoMilitia;
            case "footman":
                return costoFootman;
            case "paladin":
                return costoPaladin;
            case "druid":
                return costoDruid;
            case "huntress":
                return costoHuntress;
            case "warden":
                return costoWarden;
            case "acolyte":
                return costoAcolyte;
            case "deathknight":
                return costoDeathKnight;
            case "necromancer":
                return costoNecromancer;
            case "grunt":
                return costoGrunt;
            case "shaman":
                return costoShaman;
            case "blademaster":
                return costoBlademaster;
        }
    return null;
    }

    public static Costo getCostoMilitia() {
        return costoMilitia;
    }

    public static Costo getCostoFootman() {
        return costoFootman;
    }

    public static Costo getCostoPaladin() {
        return costoPaladin;
    }

    public static Costo getCostoDruid() {
        return costoDruid;
    }

    public static Costo getCostoHuntress() {
        return costoHuntress;
    }

    public static Costo getCostoWarden() {
        return costoWarden;
    }

    public static Costo getCostoAcolyte() {
        return costoAcolyte;
    }

    public static Costo getCostoDeathKnight() {
        return costoDeathKnight;
    }

    public static Costo getCostoNecromancer() {
        return costoNecromancer;
    }

    public static Costo getCostoGrunt() {
        return costoGrunt;
    }

    public static Costo getCostoShaman() {
        return costoShaman;
    }

    public static Costo getCostoBlademaster() {
        return costoBlademaster;
    }   
    
}
