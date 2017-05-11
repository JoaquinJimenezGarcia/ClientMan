package controller;

import model.Gestor;

import java.util.Scanner;

/**
 * Created by garci on 11/05/2017.
 */
public class GestorApp {
    Gestor gestor;

    public GestorApp(){
        gestor = new Gestor();
    }

    public void run(){
        int option;

        while ((option = showMenu())!= 0){
            switch (option) {
                case 1:
                    break;
                case 2:
                    if (gestor.longitud()>0){
                    }
                    break;
                case 3:
                    if (gestor.longitud()>0){
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public int showMenu(){
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("***************************");
        System.out.println("* 1. Registrar cliente    *");
        if (gestor.longitud()>0) {
            System.out.println("* 2. Clientes registrados *");
        }
        System.out.println("* 0. Salir                *");
        System.out.println("***************************");

        System.out.println("Opción: ");
        option = input.nextInt();

        return option;
    }
}
