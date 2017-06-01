package model;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by joaquinjimenezgarcia on 31/05/2017.
 */
public class ListaUsuarios {

    private LinkedList<Usuario> usuariosRegistrados;

    public ListaUsuarios(){
        usuariosRegistrados = new LinkedList<>();
    }

    /**
     * Recibe un cliente al que le ha llegado la máquina y comprueba si ya está en la lista
     * por una compra previa.
     *
     * Si está, devuelve mensaje y no lo vuelve a añadir.
     * En caso de no estar, avisa que añadirá y añade.
     * @param usuario
     */
    public void registrarUsuario(Usuario usuario){
        if (usuariosRegistrados.contains(usuario)){
            System.out.println("El usuario " + usuario.getNombre() + ", ya está registrado.");
            usuario = null;
        }

        if (usuario != null){
            usuariosRegistrados.add(usuario);
            guardarUsuariosRegistrados();
            System.out.println("Un cliente ya ha recibido su Thermomix.");
        }
    }

    public Usuario contiene(Usuario usuario){
        if (usuariosRegistrados.contains(usuario)){
            return usuario;
        } else {
            System.out.println("El usuario no existe.");
            return null;
        }
    }

    /**
     * Devuelve el tamaño de la lista
     * @return longitud de clientes
     */
    public int longitud(){
        return usuariosRegistrados.size();
    }

    /**
     * Ordena los clientes por nombres y los muestra
     */
    public void mostrarUsuarios(){
        for (Usuario usuario: usuariosRegistrados){
            System.out.println(usuario);
        }
    }

    /**
     * Escribirá la lista actual de clientes en info/clientesRecibidos.dat
     */
    public void guardarUsuariosRegistrados() {
        try {
            ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("info/usuariosRegistrados.dat"));
            fos.writeObject(usuariosRegistrados);
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
    public void cargarUsuariosRegistrados(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info/usuariosRegistrados.dat"));

            usuariosRegistrados = (LinkedList<Usuario>) ois.readObject();

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){

        }


    }
}
