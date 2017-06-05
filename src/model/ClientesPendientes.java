package model;

import java.io.*;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by garci on 16/05/2017.
 */
public class ClientesPendientes {
    private LinkedList<Cliente> clientesPendientes; // Crea el LinkedList dónde guardará los clientes.

    public ClientesPendientes(){
        clientesPendientes = new LinkedList<>();
    }

    /**
     * Comprueba si el clciente dado está en la lista. En caso positivo, devolverá verdadero
     * y en caso negativo, devolverá falso
     * @param cliente
     * @return booleano
     */
    public boolean existencia(Cliente cliente){
        if (clientesPendientes.contains(cliente)){
            return true;
        }else {
            return false;
        }
    }

    public Cliente devolverCliente(int indice){
        Cliente cliente = clientesPendientes.get(indice);

        return cliente;
    }

    public void eliminarCliente(int indice){
        clientesPendientes.remove(indice);
    }

    /**
     * Primero comprueba si el cliente dado ya está en la lista, y en dicho caso, lo indica al usuario y devuelve
     * null, para que en el siguiente paso no lo vuelva a añadir.
     *
     * Luego comprueba que sea válido, y en dicho caso lo añade a la lista y guarda la lista de clientes, por seguridad.
     * En caso de problemas, indica que no fue añadido
     * @param cliente
     */
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

    /**
     * Obtiene el tamaño de la lista
     * @return tamaño de la lista
     */
    public int longitud(){
        return clientesPendientes.size();
    }

    /**
     * Ordena la lista por nombre y los muestra en pantalla.
     */
    public void mostrarClientes(){
        Collections.sort(clientesPendientes,Cliente.comparadorPorNombre);

        for (Cliente cliente: clientesPendientes){
            System.out.println(cliente);
        }
    }

    /**
     * Comprobará si hay clientes a los que le han llegado la máquina y lo devolverá para
     * añadirlo en la lista de clientes recibidos y lo comunicará
     * @return cliente en caso de haberlo
     */
    public Cliente comprobarLlegada(){
        Date actual = new Date();

        Iterator<Cliente> itCliente = clientesPendientes.iterator();
        while (itCliente.hasNext()){
            Cliente cliente = itCliente.next();

            try {
                if (cliente.getFechaRecesion() != null) {
                    if (cliente.getFechaRecesion().before(actual)) {
                        clientesPendientes.remove(cliente); // Borra el cliente de esta lista se ya le llegó
                        guardarClientesPendientes(); // Guarda datos
                        return cliente; // Devuelve el cliente para usarlo en la otra lista
                    }else{
                        System.out.println("Aún no ha llegado ningún pedido.");
                    }
                }
            }catch (NullPointerException e){
                System.out.println("No hay clientes");
            }
        }

        return null; // En caso de no haber clientes disponibles, devuelve null
    }

    /**
     * Escribirá la lista actual de clientes en info/clientesPendientes.dat
     */
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

    /**
     * Cargará la lista guardada de clientes en info/clientesPendientes.dat
     */
    public void cargarClientesPendientes(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info/clientesPendientes.dat"));

            clientesPendientes = (LinkedList<Cliente>) ois.readObject();

            ois.close();
        } catch (IOException e) {
        } catch (ClassNotFoundException e){
        }
    }
}
