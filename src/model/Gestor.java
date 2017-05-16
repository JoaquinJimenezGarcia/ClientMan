package model;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Gestor {
    private int id;
    private LinkedList<Cliente> clientes;

    Persona p1 = new Persona("Avd/ Alcalde Luis",687149550,new Date(),"Joaquin", "Jimenez","garcia@joaquin.com", 687149550, "77847616E");
    Persona p2 = new Persona("Avd/ Cofradia",689678502,new Date(),"Jorge", "Caro","semana@santa.com", 624859602, "88756916D");
    Persona p3 = new Persona("Avd/ Bat Cueva",687149550,new Date(),"Batman", "Jimenez","soy@batman.com", 687149550, "77847616E");

    public Gestor(){
        clientes = new LinkedList<>();

        clientes.add(p1);
        clientes.add(p2);
        clientes.add(p3);
    }

    public int getId(){
        return id;
    }

    public void registarCliente(Cliente cliente){
        if (clientes.contains(cliente)){
            cliente = null;
            System.out.println("Ya hay un cliente con este NIF/DNI");
        }

        if (cliente != null){
            id++;
            clientes.add(cliente);
        }
    }

    public int longitud(){
        return clientes.size();
    }

    public void mostrarClientes(){
        Collections.sort(clientes, Cliente.comparadorPorID);

        for (Cliente cliente: clientes){
            System.out.println(cliente);
        }
    }

    public void borrarCliente(int id){
        Iterator<Cliente> itCliente = clientes.iterator();
        while (itCliente.hasNext()){
            Cliente cliente = itCliente.next();

            if (cliente.getId() == id){
                itCliente.remove();
            }
        }
    }

    public Cliente transicionCliente(int id){
        return clientes.get(id);
    }
}
