package model;

import java.io.*;
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
            guardarClientesRecibidos();
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

    public void guardarClientesRecibidos() {
        try {
            ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("info/clientesRecibidos.dat"));
            fos.writeObject(clientesRecibidos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarClientesRecibidos(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info/clientesRecibidos.dat"));

            clientesRecibidos = (LinkedList<Cliente>) ois.readObject();

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){

        }
    }
}
