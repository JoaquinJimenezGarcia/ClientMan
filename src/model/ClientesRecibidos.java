package model;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by garci on 16/05/2017.
 */
public class ClientesRecibidos {
    private LinkedList<Cliente> clientesRecibidos;

    public ClientesRecibidos(){
        clientesRecibidos = new LinkedList<>();
    }

    public void registarCliente(Cliente cliente){
        if (clientesRecibidos.contains(cliente)){
            cliente = null;
            System.out.println("Este cliente ya ha recibido su máquina.");
        }

        if (cliente != null){
            clientesRecibidos.add(cliente);
        }
    }

    public int longitud(){
        return clientesRecibidos.size();
    }

    public void mostrarClientes(){
        Collections.sort(clientesRecibidos, Cliente.comparadorPorID);

        for (Cliente cliente: clientesRecibidos){
            System.out.println(cliente);
        }
    }

    public void borrarCliente(int id){
        Iterator<Cliente> itCliente = clientesRecibidos.iterator();
        while (itCliente.hasNext()){
            Cliente cliente = itCliente.next();

            if (cliente.getId() == id){
                itCliente.remove();
            }
        }
    }
}