package model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by garci on 16/05/2017.
 */
public class ClientesPendientes {
    private LinkedList<Cliente> clientesPendientes;

    public ClientesPendientes(){
        clientesPendientes = new LinkedList<>();
    }

    public void registarCliente(Cliente cliente){
        if (clientesPendientes.contains(cliente)){
            cliente = null;
            System.out.println("Este cliente ya está pendiente de una máquina.");
        }

        if (cliente != null){
            clientesPendientes.add(cliente);
            System.out.println("Cliente añadido a la espera.");
        }else{
            System.out.println("Cliente no encontrado.");
        }
    }

    public int longitud(){
        return clientesPendientes.size();
    }

    public void mostrarClientes(){
        for (Cliente cliente: clientesPendientes){
            System.out.println(cliente);
        }
    }

    public void borrarCliente(int id){
        Iterator<Cliente> itCliente = clientesPendientes.iterator();
        while (itCliente.hasNext()){
            Cliente cliente = itCliente.next();

            if (cliente.getDni_nif().equals(id)){
                itCliente.remove();
            }
        }
    }
}
