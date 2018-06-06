/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import Fabricas.Estructuras.FactoryEstructura;
import Fabricas.Unidades.FactoryUnidad;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String type) {
        switch(type){
            case "estructura":
                return new FactoryEstructura();
            case "unidad":
                return new FactoryUnidad();
        }
        return null;
    }
}
