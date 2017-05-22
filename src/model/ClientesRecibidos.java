package model;

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
            System.out.println("El cliente con DNI " + cliente.getDni_nif() + ", ya había recibido una máquina. No se volverá a añadir a la lista.");
            cliente = null;
        }

        if (cliente != null){
            clientesRecibidos.add(cliente);
            System.out.println("Un cliente ya ha recibido su Thermomix.");
        }
    }

    public int longitud(){
        return clientesRecibidos.size();
    }

    public void mostrarClientes(){
        for (Cliente cliente: clientesRecibidos){
            System.out.println(cliente);
        }
    }
}
