package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Gestor {
    private ArrayList<Cliente> clientes;

    public Gestor(){
        clientes = new ArrayList<>();
    }

    public void registarCliente(Cliente cliente){
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
        clientes.remove(id);
    }
}
