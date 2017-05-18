package model;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Gestor {
    private LinkedList<Cliente> clientes;

    Persona p1 = new Persona("Avd/ Alcalde Luis", 687149550, "77847616E", "Joaquin", "Jimenez", "garcia@joaquin.com", 687149550);
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
        Iterator<Cliente> itCliente = clientes.iterator();
        while (itCliente.hasNext()) {
            Cliente cliente = itCliente.next();

            if (cliente.getDni_nif().equals(identificador)) {
                itCliente.remove();
            }else{
                System.out.println("El Cliente no existe.");
            }
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
}