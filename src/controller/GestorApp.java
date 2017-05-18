package controller;

import model.*;

import java.util.Scanner;

/**
 * Created by garci on 11/05/2017.
 */
public class GestorApp {
    Gestor gestor;
    ClientesPendientes clientesPendientes;
    ClientesRecibidos clientesRecibidos;

    public GestorApp(){
        gestor = new Gestor();
        clientesPendientes = new ClientesPendientes();
        clientesRecibidos = new ClientesRecibidos();
    }

    public void run(){
        int option;

        while ((option = showMenu())!= 0){
            switch (option) {
                case 1:
                    gestor.registarCliente(leerPersona());
                    break;
                case 2:
                    gestor.registarCliente(leerEmpresa());
                    break;
                case 3:
                    if (gestor.longitud()>0){
                        gestor.mostrarClientes();
                    }
                    break;
                case 4:
                    if (gestor.longitud()>0){
                        gestor.borrarCliente(leerIdentificador());
                    }
                    break;
                case 5:
                    if (gestor.longitud()>0){
                        venderThermomix();
                    }
                    break;
                case 6:
                    if (clientesPendientes.longitud()>0){
                        clientesPendientes.mostrarClientes();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void venderThermomix(){
        clientesPendientes.registarCliente(clienteComprador());
    }

    public int showMenu(){
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("**********************************");
        System.out.println("* 1. Registrar cliente (persona) *");
        System.out.println("* 2. Registrar cliente (empresa) *");
        if (gestor.longitud()>0) {
            System.out.println("* 3. Clientes registrados        *");
            System.out.println("* 4. Borrar Clientes             *");
            System.out.println("* 5. Vender Thermomix            *");
        }
        if (clientesPendientes.longitud()>0){
            System.out.println("* 6. Clientes Pendientes         *");
        }
        System.out.println("* 0. Salir                       *");
        System.out.println("**********************************");

        System.out.println("Opción: ");
        option = input.nextInt();

        return option;
    }

    public Cliente clienteComprador(){
        Scanner input = new Scanner(System.in);
        Cliente cliente;
        String identificador;

        gestor.mostrarClientes();

        System.out.println("Introduzca el DNI/NIF: ");
        identificador = input.next();

        cliente = gestor.transicionCliente(identificador);
        cliente.setVendido(true);

        return cliente;
    }

    public String leerIdentificador(){
        Scanner input = new Scanner (System.in);
        String identificador;

        gestor.mostrarClientes();

        System.out.println("Introduzca el DNI/NIF: ");
        identificador = input.next();

        return identificador;
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
        Cliente cliente;

        do {
            System.out.println("Nombre Cliente: ");
            nombre = input.nextLine();
        }while (nombre.equals("") || nombre.length()<3);

        do {
            System.out.println("Apellidos Cliente: ");
            apellidos = input.nextLine();
        }while (apellidos.equals(""));

        do {
            System.out.println("E-Mail Cliente: ");
            email = input.next();
        }while (email.equals(""));

        do {
            System.out.println("Télefono Cliente: ");
            telf = input.nextInt();
        }while (telf <= 600000000);

        do {
            System.out.println("DNI Cliente: ");
            dni = input.next();
        }while (dni.equals("") || dni.length()<9);

        do {
            System.out.println("Dirección de Facturación: ");
            direccionFacturacion = input.nextLine();
        }while (direccionFacturacion.equals(""));

        do {
            System.out.println("Télefono Contacto: ");
            telfContacto = input.nextInt();
        }while (telfContacto <= 600000000);

        cliente = new Persona(direccionFacturacion, telfContacto, dni, nombre, apellidos, email, telf);

        return cliente;
    }

    public Cliente leerEmpresa(){
        Scanner input = new Scanner (System.in);
        String nombre;
        String nif;
        String direccion;
        String encargado;
        int telfEncargado;
        String direccionFacturacion;
        int telfContacto;
        Cliente cliente;

        do {
            System.out.println("Nombre Empresa: ");
            nombre = input.nextLine();
        }while (nombre.equals("")|| nombre.length()<5);

        do {
            System.out.println("NIF Empresa: ");
            nif = input.next();
        }while (nif.equals("")|| nif.length()<9);

        do {
            System.out.println("Direccion Empresa: ");
            direccion = input.nextLine();
        }while (direccion.equals(""));

        do {
            System.out.println("Nombre Encargado Empresa: ");
            encargado = input.nextLine();
        }while (encargado.equals(""));

        do {
            System.out.println("Télefono Encargado: ");
            telfEncargado = input.nextInt();
        }while (telfEncargado <= 600000000);

        do {
            System.out.println("Dirección de Facturación: ");
            direccionFacturacion = input.nextLine();
        }while (direccionFacturacion.equals(""));

        do {
            System.out.println("Télefono Contacto: ");
            telfContacto = input.nextInt();
        }while (telfContacto <= 600000000);

        cliente = new Empresa(direccionFacturacion, telfContacto, nif, nombre, direccion, encargado, telfEncargado);

        return cliente;
    }
}
