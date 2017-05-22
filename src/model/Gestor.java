package model;

import controller.EnvioCorreo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Gestor {
    private LinkedList<Cliente> clientes;

    Persona p1 = new Persona("Avd/ Alcalde Luis", 687149550, "77847616E", "Joaquin", "Jimenez", "garcia.jjimenez@gmail.com", 687149550);
    Persona p2 = new Persona("Avd/ Cofradia", 689678502, "89675434R", "Jorge", "Caro", "semana@santa.com", 624859602);
    Persona p3 = new Persona("Avd/ Bat Cueva", 687149550, "65895434T", "Batman", "Jimenez", "soy@batman.com", 687149550);

    public Gestor() {
        clientes = new LinkedList<>();

        clientes.add(p1);
        clientes.add(p2);
        clientes.add(p3);
    }

    public void registarCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            cliente = null;
            System.out.println("Ya hay un cliente con este NIF/DNI");
        }

        if (cliente != null) {
            clientes.add(cliente);
        }
    }

    public int longitud() {
        return clientes.size();
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void borrarCliente(String identificador) {
        String comprobador = null;
        Iterator<Cliente> itCliente = clientes.iterator();
        while (itCliente.hasNext()) {
            Cliente cliente = itCliente.next();

            if (cliente.getDni_nif().equals(identificador)) {
                itCliente.remove();
                System.out.println("Cliente borrado con éxito.");
                comprobador = "";
            }
        }
        if (comprobador == null){
            System.out.println("El Cliente no existe.");
        }
    }

    public Cliente buscarClientesPorNombre(String nombre){
        for (Cliente c: clientes){
            if (c.getNombre().equals(nombre)){
                return c;
            }
        }

        return null;
    }

    public void mostrarClientesPorNombre(Cliente cliente){
        try {
            if (cliente!=null) {
                System.out.println(cliente);
            }else{
                System.out.println("No se ha encontrado el cliente.");
            }
        }catch (NullPointerException e){
            System.out.println("No se ha encontrado el cliente");
        }
    }

    public Cliente transicionCliente(String identificador) {
        Cliente cliente = null;

        for (Cliente c: clientes) {
            if (c.getDni_nif().equals(identificador)) {
                cliente = c;
            }
        }
        return cliente;
    }

    public void enviarCorreo(Persona persona){
        Correo c = new Correo();
        EnvioCorreo controlador = new EnvioCorreo();

        c.setPasswd("PASSWD");
        c.setUsuarioCorreo("CORREO");
        c.setAsunto("Thermomix Vendida");
        c.setDestino(persona.getEmail());
        c.setMsg("Este mensaje se ha generado automáticamente para " +
                "avisarle de que su nueva Thermomix ya se encuentra en trámites" +
                "y será entregada en su domicilio indicado tan pronto como" +
                "sea posible. " +
                "Esperamos que la disfrute.");

        if (controlador.enviarCorreo(c)){
            System.out.println("Enviado correo de venta");
        }else{
            System.out.println("No se ha podido enviar el correo de venta.");
        }
    }
}