/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import Fabricas.Estructuras.Estructura;
import Fabricas.Unidades.Unidad;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public interface AbstractFactory {
    Estructura getEstructura(String type);
    Unidad getUnidad(String type);
}
