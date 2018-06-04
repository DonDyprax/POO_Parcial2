/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;

/**
 *
 * @author Juan Pablo Acosta <DonDyprax at github.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("====================================================");
        System.out.print("Ingrese el nombre del jugador 1: ");
        j1.setNombre(leer.nextLine());
        System.out.print("Ingrese el nombre del jugador 2: ");
        j2.setNombre(leer.nextLine());
        System.out.println("====================================================");
        
        MenuRazas.mostrar();
        
        System.out.print(j1.getNombre() + ", eliga una raza: ");
        j1.setRaza(leer.nextInt());
        System.out.print(j2.getNombre() + ", eliga una raza: ");
        j2.setRaza(leer.nextInt());
        System.out.println(j1.getRaza());
        System.out.println(j2.getRaza());
        
    }
    
}
