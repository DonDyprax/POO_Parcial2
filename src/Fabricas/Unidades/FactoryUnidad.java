/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Unidades;

import Fabricas.AbstractFactory;
import Fabricas.Estructuras.Estructura;
import Fabricas.Unidades.Elfos.Druid;
import Fabricas.Unidades.Elfos.Huntress;
import Fabricas.Unidades.Elfos.Warden;
import Fabricas.Unidades.Humanos.Footman;
import Fabricas.Unidades.Humanos.Militia;
import Fabricas.Unidades.Humanos.Paladin;
import Main.Main;


/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class FactoryUnidad implements AbstractFactory{
    @Override
    public Estructura getEstructura(String type) {
        return null;
    }
    
    @Override
    public Unidad getUnidad(String type) {
        switch (type) {
            case "druid":
                return new Druid(Main.fase);
            case "huntress":
                return new Huntress(Main.fase);
            case "warden":
                return new Warden(Main.fase);
            case "footman":
                return new Footman(Main.fase);
            case "militia":
                return new Militia(Main.fase);
            case "paladin":
                return new Paladin(Main.fase);
        }
        return null;
    }
}
