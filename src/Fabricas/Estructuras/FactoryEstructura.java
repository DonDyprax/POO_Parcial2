/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Estructuras;

import Fabricas.AbstractFactory;
import Fabricas.Estructuras.Humanos.Barracks;
import Fabricas.Estructuras.Humanos.Sanctuary;
import Fabricas.Estructuras.Humanos.Workshop;
import Fabricas.Estructuras.Elfos.AncientOfLore;
import Fabricas.Estructuras.Elfos.AncientOfWar;
import Fabricas.Estructuras.Elfos.TreeOfLife;
import Fabricas.Estructuras.Orcos.GreatHall;
import Fabricas.Estructuras.Orcos.VoodooLounge;
import Fabricas.Estructuras.Orcos.SpiritLodge;
import Fabricas.Estructuras.Muertos.Necropolis;
import Fabricas.Estructuras.Muertos.Crypt;
import Fabricas.Estructuras.Muertos.SacrificialPit;

import Fabricas.Unidades.Unidad;
import Main.Main;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class FactoryEstructura implements AbstractFactory{
    @Override
    public Unidad getUnidad(String type) {
        return null;
    }
    
    @Override
    public Estructura getEstructura(String type) {
        switch (type) {
            case "townCenter":
                return new TownCenter();
            case "mine":
                return new Mine(Main.fase);
            case "sawmill":
                return new Sawmill(Main.fase);
            case "forge":
                return new Forge(Main.fase);          
            case "barracks":
                return new Barracks(Main.fase);
            case "sanctuary":
                return new Sanctuary(Main.fase);
            case "workshop":
                return new Workshop(Main.fase);
            case "ancientoflore":
                return new AncientOfLore(Main.fase);
            case "ancientofwar":
                return new AncientOfWar(Main.fase);
            case "treeoflife":
                return new TreeOfLife(Main.fase);
            case "greathall":
                return new GreatHall(Main.fase);
            case "voodoolounge":
                return new VoodooLounge(Main.fase);
            case "spiritlodge":
                return new SpiritLodge(Main.fase);
            case "necropolis":
                return new Necropolis(Main.fase);
            case "crypt":
                return new Crypt(Main.fase);
            case "sacrificialpit":
                return new SacrificialPit(Main.fase);
        }
        return null;
    }
}
