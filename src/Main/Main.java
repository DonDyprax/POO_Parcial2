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
    public static int fase = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean juegoTerminado = false;
        
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("====================================================");
        System.out.print("Ingrese el nombre del jugador 1: ");
        j1.setNombre(leer.nextLine());
        System.out.print("Ingrese el nombre del jugador 2: ");
        j2.setNombre(leer.nextLine());
        System.out.println("====================================================");

        
        mostrarMenuRazas();
        System.out.print("\n");
        
        System.out.print(j1.getNombre() + ", elija una raza: ");
        j1.setRaza(leer.nextInt());
        System.out.print(j2.getNombre() + ", elija una raza: ");
        j2.setRaza(leer.nextInt());
        System.out.print("\n");
        
        while(!juegoTerminado){
            if(j1.getEstructuras().isEmpty() || j2.getEstructuras().isEmpty()){
                if(j1.getEstructuras().isEmpty()){
                    System.out.println(j2.getNombre() + " ha ganado la partida!");
                }
                else{
                    System.out.println(j1.getNombre() + " ha ganado la partida!");
                }
                juegoTerminado = true;
                break;
            }
            
            j1.realizarTurno();
            j2.realizarTurno();
            
            fase += 1;
        }
        
    }
    
    public static void mostrarMenuRazas(){
        System.out.println("\t Razas Disponibles");
        System.out.println("1.) Humans");
        System.out.println("2.) Night Elves");
        System.out.println("3.) Orcs");
        System.out.println("4.) Undead");
    }
    
}
