package controller;

import model.Cliente;
import model.Gestor;
import model.Persona;

import java.util.Date;
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
                    gestor.registarCliente(leerPersona());
                    break;
                case 2:
                    if (gestor.longitud()>0){
                    }
                    break;
                case 3:
                    if (gestor.longitud()>0){
                        gestor.mostrarClientes();
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

        System.out.println("**********************************");
        System.out.println("* 1. Registrar cliente (persona) *");
        if (gestor.longitud()>0) {
            System.out.println("* 3. Clientes registrados        *");
        }
        System.out.println("* 0. Salir                       *");
        System.out.println("**********************************");

        System.out.println("Opción: ");
        option = input.nextInt();

        return option;
    }

    public Cliente leerPersona(){
        Scanner input = new Scanner (System.in);
        String nombre;
        String apellidos;
        String email;
        int telf;
        String dni;
        String direccionFacturacion;
        int telfContacto;
        Date fechaAlta;
        Cliente cliente;

        do {
            System.out.println("Nombre Cliente: ");
            nombre = input.next();
        }while (nombre.equals(""));

        do {
            System.out.println("Apellidos Cliente: ");
            apellidos = input.next();
        }while (apellidos.equals(""));

        do {
            System.out.println("E-Mail Cliente: ");
            email = input.next();
        }while (email.equals(""));

        do {
            System.out.println("Télefono Cliente: ");
            telf = input.nextInt();
        }while (telf <= 0);

        do {
            System.out.println("DNI Cliente: ");
            dni = input.next();
        }while (dni.equals(""));

        do {
            System.out.println("Dirección de Facturación: ");
            direccionFacturacion = input.next();
        }while (direccionFacturacion.equals(""));

        do {
            System.out.println("Télefono Contacto: ");
            telfContacto = input.nextInt();
        }while (telfContacto <= 0);

        fechaAlta = new Date();

        cliente = new Persona(direccionFacturacion, telfContacto, fechaAlta, nombre, apellidos, email, telf, dni);

        return cliente;
    }
}
