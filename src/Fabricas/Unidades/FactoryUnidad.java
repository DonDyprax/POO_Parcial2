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
import Fabricas.Unidades.Orcos.Grunt;
import Fabricas.Unidades.Orcos.Shaman;
import Fabricas.Unidades.Orcos.Blademaster;
import Fabricas.Unidades.Muertos.Acolyte;
import Fabricas.Unidades.Muertos.Necromancer;
import Fabricas.Unidades.Muertos.DeathKnight;
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
            case "grunt":
                return new Grunt(Main.fase);
            case "shaman":
                return new Shaman(Main.fase);
            case "blademaster":
                return new Blademaster(Main.fase);
            case "acolyte":
                return new Acolyte(Main.fase);
            case "necromancer":
                return new Necromancer(Main.fase);
            case "deathknight":
                return new DeathKnight(Main.fase);
        }
        return null;
    }
}
