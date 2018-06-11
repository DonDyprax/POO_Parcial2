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
        }
    return null;
    }
}
