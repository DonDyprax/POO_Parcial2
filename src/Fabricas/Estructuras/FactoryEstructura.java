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
            case "barracks":
                return new Barracks();
            case "sanctuary":
                return new Sanctuary();
            case "workshop":
                return new Workshop();
        }
        return null;
    }
}
