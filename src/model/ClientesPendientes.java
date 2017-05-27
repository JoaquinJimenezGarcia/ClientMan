package model;

import java.io.*;
import java.util.Date;
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

    public boolean existencia(Cliente cliente){
        if (clientesPendientes.contains(cliente)){
            return true;
        }else {
            return false;
        }
    }

    public void registarCliente(Cliente cliente){
        if (clientesPendientes.contains(cliente)){
            cliente = null;
            System.out.println("Este cliente ya está pendiente de una máquina.");
        }

        if (cliente != null){
            clientesPendientes.add(cliente);
            System.out.println("Cliente añadido a la espera.");
            guardarClientesPendientes();
        }else{
            System.out.println("Cliente no añadido.");
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

    public Cliente comprobarLlegada(){
        Date actual = new Date();

        Iterator<Cliente> itCliente = clientesPendientes.iterator();
        while (itCliente.hasNext()){
            Cliente cliente = itCliente.next();

            try {
                if (cliente.getFechaRecesion() != null) {
                    if (cliente.getFechaRecesion().before(actual)) {
                        clientesPendientes.remove(cliente);
                        guardarClientesPendientes();
                        return cliente;
                    }else{
                        System.out.println("Aún no ha llegado ningún pedido.");
                    }
                }
            }catch (NullPointerException e){
                System.out.println("No hay clientes");
            }
        }

        return null;
    }

    public void guardarClientesPendientes() {
        try {
            ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("info/clientesPendientes.dat"));
            fos.writeObject(clientesPendientes);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarClientesPendientes(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info/clientesPendientes.dat"));

            clientesPendientes = (LinkedList<Cliente>) ois.readObject();

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){

        }
    }
}
