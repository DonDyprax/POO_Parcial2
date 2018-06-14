/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas.Unidades;

import Fabricas.Estructuras.Estructura;


/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public interface Unidad {
    void atacar(Estructura estructura);
    String getNombre();
    int getFaseCreacion();
    int getTiempoCreacion();
    int getFaseAtaque();
}
