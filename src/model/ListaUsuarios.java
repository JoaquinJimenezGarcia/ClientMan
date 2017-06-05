package model;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by joaquinjimenezgarcia on 05/06/2017.
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
        }
    }

    /**
     * Comprobará si el usuario se encuentra entre los usuarios registrados
     * y si ha introducido bien la contraseña.
     * @param usuario
     * @return
     */
    public Usuario contiene(Usuario usuario){
        for (int i = 0; i < usuariosRegistrados.size(); i++) {
            if (usuariosRegistrados.get(i).equals(usuario)&&usuario.getPasswd().equals(usuariosRegistrados.get(i).getPasswd())){
                return usuariosRegistrados.get(i);
            }
        }
        System.out.println("El usuario no existe.");
        return null;
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
        } catch (ClassNotFoundException e){

        }


    }
}

