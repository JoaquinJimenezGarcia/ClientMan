package controller;

import model.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by garci on 11/05/2017.
 */

/**
 * Clase de la aplicación que se encarga de llevar a cabo la lógica de la misma
 */
public class GestorApp {
    Gestor gestor;
    ClientesPendientes clientesPendientes;
    ClientesRecibidos clientesRecibidos;
    ListaUsuarios listaUsuarios;
    Usuario usuario;
    Usuario usuarioFinal;

    /**
     * Constructor para instanciar automáticamente las listas
     */
    public GestorApp() {
        gestor = new Gestor();
        clientesPendientes = new ClientesPendientes();
        clientesRecibidos = new ClientesRecibidos();
        listaUsuarios = new ListaUsuarios();
    }

    public void inicioSesion(){
        listaUsuarios.cargarUsuariosRegistrados();

        Scanner input = new Scanner(System.in);
        String nombre;
        String passwd;

        System.out.println("Nombre de usuario: ");
        nombre = input.next();

        System.out.println("Contraseña usuario: ");
        passwd = input.next();

        usuario = new Usuario(nombre,passwd);

        try {
            usuarioFinal = listaUsuarios.contiene(usuario);
            if (usuarioFinal!=null){
                System.out.println("Bienvenido " + usuarioFinal.getNombre());
                run();
            }
        } catch (NullPointerException e) {
            System.out.println("El usuario no existe.");
        }
    }

    /**
     * Es el método al que llama el Main, se encarga de llamar a su vez a una u otra
     * función dependiendo de lo que el usuario haya elegido en el menú
     */
    public void run(){
        int option;

        // Antes de nada carga los datos de todos los clientes guardados en la aplicación.
        gestor.cargarClientesRegistrados();
        clientesRecibidos.cargarClientesRecibidos();
        clientesPendientes.cargarClientesPendientes();

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
                    if (gestor.longitud()>0){
                        gestor.mostrarClientesBuscados(gestor.buscarClientesPorNombre(leerNombre()));
                    }
                    break;
                case 7:
                    if (clientesPendientes.longitud()>0){
                        clientesPendientes.mostrarClientes();
                    }
                    break;
                case 8:
                    if (clientesPendientes.longitud()>0){
                        clienteRecibido(clientesPendientes.comprobarLlegada());
                    }
                    break;
                case 9:
                    if (clientesRecibidos.longitud()>0){
                        clientesRecibidos.mostrarClientes();
                    }
                    break;
                case 10:
                    if (gestor.longitud()>0){
                        gestor.mostrarClientesBuscados(gestor.buscarClientesPorDNI(leerIdentificador()));
                    }
                    break;
                default:
                    break;
            }
        }

        // Al salir d ela aplicación guarda todos los datos para su posterior uso.
        gestor.guardarClientesRegistrados();
        clientesRecibidos.guardarClientesRecibidos();
        clientesPendientes.guardarClientesPendientes();
    }

    /**
     * Registra un cliente dado en Clientes Recibidos
     * @param cliente
     */
    public void clienteRecibido(Cliente cliente){
        clientesRecibidos.registarCliente(cliente);
    }

    /**
     * Lee un nombre de un cliente para buscarlo en la lista.
     * @return nombre que buscará
     */
    public String leerNombre(){
        String nombre;
        Scanner input = new Scanner(System.in);

        System.out.println("Inserte NOMBRE a buscar: ");
        nombre = input.nextLine();

        return nombre;
    }

    /**
     * Método usado para vender una Thermomix a un cliente.
     * Copia el cliente seleccionado, y si no existe en clients pendientes,
     * lo envía y le manda un correo.
     */
    public void venderThermomix(){
        Cliente cliente = clienteComprador(); // Copia el cliente solicitado

        try{
            if (!clientesPendientes.existencia(cliente)){ // Comprueba que no existe ya
                gestor.enviarCorreo(cliente); // Manda email avisando de su compra
                clientesPendientes.registarCliente(cliente); // Lo registra en Clientes pendientes
            }
        }catch (NullPointerException e){

        }
    }

    /**
     * Muestra menú con las diferentes opciones para que el usuario indique
     * qué desea hacer.
     * @return
     */
    public int showMenu(){
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("Usuario: " + usuarioFinal.getNombre());
        System.out.println("**********************************");
        System.out.println("* 1. Registrar cliente (persona) *");
        System.out.println("* 2. Registrar cliente (empresa) *");
        if (gestor.longitud()>0) {
            System.out.println("* 3. Clientes registrados        *");
            System.out.println("* 4. Borrar Clientes             *");
            System.out.println("* 5. Vender Thermomix            *");
            System.out.println("* 6. Buscar por Nombre           *");
            System.out.println("* 10. Buscar por DNI/NIF         *");
        }
        if (clientesPendientes.longitud()>0){
            System.out.println("* 7. Clientes Pendientes         *");
            System.out.println("* 8. Comprobar Llegada           *");
        }
        if (clientesRecibidos.longitud()>0){
            System.out.println("* 9. Transaciones Terminadas     *");
        }
        System.out.println("* 0. Salir                       *");
        System.out.println("**********************************");

        System.out.println("Opción: ");

        /**
         * Te obliga a seleccionar siempre una opción correcta. En caso
         * contrario, te obligará a volver a elegir una.
         */
        try {
            option = input.nextInt();
            return option;
        }catch (InputMismatchException e){
            System.out.println("Opción inválida.");
        }
        return showMenu();
    }

    /**
     * Devuelve un cliente seleccionado que ha comprado una máquina, para
     * poder ponerlo en la lista de espera.
     * @return cliente comprador
     */
    public Cliente clienteComprador(){
        Scanner input = new Scanner(System.in);
        Cliente cliente;
        String identificador;

        gestor.mostrarClientes(); // Muestra todos los clientes

        System.out.println("Introduzca el DNI/NIF: ");

        /**
         * Busca por DNI en la lista de todos los clientes. Tras encontrarlo, en caso de no
         * existir en los clientes pendientes, establece a true la venta, le vende la máquina
         * y devuelve el cliente para mandarlo a dicha lista de espera.
         *
         * En caso de que ya esté en dicha lista, lanza un mensaje informando y no lo vuelve
         * a pasar.
         *
         * Si el cliente no existe, manda un aviso.
         */
        try {
                identificador = input.next();
                cliente = gestor.transicionCliente(identificador);
                if (!clientesPendientes.existencia(cliente)) {
                    cliente.setVendido(true);
                    cliente.venta();
                    return cliente; // Devuelve el cliente a meter
                }else{
                    System.out.println("El cliente ya está esperando una máquina");
                }
                return null; // Devuelve null porque el cliente ya está dentro
            } catch (NullPointerException e) {
                System.out.println("DNI inexistente."); // Mensaje si el cliente no existe.
            }

        return null;
    }

    /**
     * Devuelve el DNI/NIF del cliente para poder tratarlo
     * y realizar otras acciones
     * @return dni de un cliente en concreto
     */
    public String leerIdentificador(){
        Scanner input = new Scanner (System.in);
        String identificador;

        System.out.println("Introduzca el DNI/NIF: ");
        identificador = input.next();

        return identificador;
    }

    /**
     * Obliga a meter solamente números
     * @return numero de telefono (solo caracteres numércos)
     */
    public int numeroTelf(){
        Scanner input = new Scanner(System.in);
        int telf;

        try {
            telf = input.nextInt();
            return telf;
        } catch (InputMismatchException e) {
            System.out.println("Introduzca un número correcto: ");
        }

        return numeroTelf();
    }

    /**
     * Devuelve el correo en caso de que haya pasado la comprobación.
     * En caso contrario, volverá a pedirlo hasta que se ingrese uno válido
     * @return correo cliente válido
     */
    public String correo(){
        Scanner input = new Scanner(System.in);
        String email;

        System.out.println("Introduzca E-Mail Contacto: ");
        email = input.next();

        if (gestor.comprobarMail(email)) {
            return email;
        } else {
            return correo();
        }
    }

    /**
     * Lee datos de una persona y devuelve un objeto Cliente-Persona.
     * @return Cliente - Persona
     */
    public Cliente leerPersona(){
        Scanner input = new Scanner (System.in);
        String nombre;
        String apellidos;
        String emailContacto;
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

            emailContacto = correo();

        do {
            System.out.println("Introduzca el número del cliente: ");
            telf = numeroTelf();
        }while(telf < 600000000 || telf > 799999999);

        do {
            System.out.println("DNI Cliente: ");
            dni = input.next();
        }while (dni.length() != 9 );

        input.nextLine();

        do {
            System.out.println("Dirección de Facturación: ");
            direccionFacturacion = input.nextLine();
        }while (direccionFacturacion.equals(""));

        do{
            System.out.println("Télefono Contacto: ");
            telfContacto = numeroTelf();
        }while (telfContacto < 600000000 || telfContacto > 799999999);



        cliente = new Persona(direccionFacturacion, telfContacto, dni, emailContacto, nombre, apellidos, telf);

        return cliente;
    }

    /**
     * Lee datos de una empresa y devuelve un objeto Cliente-Empresa.
     * @return Cliente - Empresa
     */
    public Cliente leerEmpresa(){
        Scanner input = new Scanner (System.in);
        String nombre;
        String nif;
        String direccion;
        String encargado;
        String emailContacto;
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
        }while (nif.length() != 9);

        input.nextLine();

        do {
            System.out.println("Direccion Empresa: ");
            direccion = input.nextLine();
        }while (direccion.equals(""));

        do {
            System.out.println("Nombre Encargado Empresa: ");
            encargado = input.nextLine();
        }while (encargado.equals(""));

        do{
            System.out.println("Télefono Encargado: ");
            telfEncargado = numeroTelf();
        }while(telfEncargado < 600000000 || telfEncargado > 799999999);

        do {
            System.out.println("Dirección de Facturación: ");
            direccionFacturacion = input.nextLine();
        }while (direccionFacturacion.equals(""));

        do {
            System.out.println("Email de Contacto: ");
            emailContacto = input.nextLine();
        }while (emailContacto.equals(""));

        do {
            System.out.println("Télefono Contacto: ");
            telfContacto = numeroTelf();
        }while (telfContacto < 600000000 || telfContacto > 799999999);

        cliente = new Empresa(direccionFacturacion, telfContacto, nif, emailContacto, nombre, direccion, encargado, telfEncargado);

        return cliente;
    }
}
