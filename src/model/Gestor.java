package model;

import controller.EnvioCorreo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Gestor {
    private LinkedList<Cliente> clientes;

    Cliente p1 = new Persona("Avd/ Alcalde Luis", 687149550, "77847616E", "garcia.jjimenez@gmail.com", "Joaquin", "Jimenez",  687149550);
    Cliente p2 = new Persona("Avd/ Cofradia", 689678502, "89675434R", "meloinvento2@gmail.com", "Jorge", "Caro",  624859602);
    Cliente p3 = new Persona("Avd/ Bat Cueva", 687149550, "65895434T","meloinvento@gmail.com", "Batman", "Jimenez", 687149550);

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
        Collections.sort(clientes,Cliente.comparadorPorNombre);

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

    public Cliente buscarClientesPorDNI(String dni){
        for (Cliente c: clientes){
            if (c.getDni_nif().equals(dni)){
                return c;
            }
        }

        return null;
    }

    public void mostrarClientesBuscados(Cliente cliente){
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

    public void enviarCorreo(Cliente cliente){
        Correo c = new Correo();
        EnvioCorreo controlador = new EnvioCorreo();

        c.setPasswd("PASSWD");
        c.setUsuarioCorreo("CORREO");
        c.setAsunto("Thermomix Vendida");
        c.setDestino(cliente.getEmailContacto());
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

    public void guardarClientesRegistrados() {
        try {
            ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("info/clientesRegistrados.dat"));
            fos.writeObject(clientes);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarClientesRegistrados(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info/clientesRegistrados.dat"));

            clientes = (LinkedList<Cliente>) ois.readObject();

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){

        }
    }
}