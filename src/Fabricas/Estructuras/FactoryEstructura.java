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
        }
        return null;
    }
}
