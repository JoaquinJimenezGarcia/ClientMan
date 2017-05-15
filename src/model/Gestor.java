package model;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Gestor {
    private LinkedList<Cliente> clientes;

    public Gestor(){
        clientes = new LinkedList<>();
    }

    public void registarCliente(Cliente cliente){
        if (clientes.contains(cliente)){
            cliente = null;
            System.out.println("Ya hay un cliente con este NIF/DNI");
        }

        if (cliente != null){
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
}
