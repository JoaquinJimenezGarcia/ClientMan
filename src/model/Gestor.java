package model;


import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */

/**
 * Clase encargada de llevar y trabajar la lista de los clientes generales.
 */
public class Gestor {
    private LinkedList<Cliente> clientes;

    /**
     * Constructor para crear el LinkedList
     */
    public Gestor() {
        clientes = new LinkedList<>();
    }

    /**
     * Recibido un cliente, lo añadirá en la lista en caso de no tenerlo ya.
     * Lo verificará por su dni/nif
     * @param cliente
     */
    public void registarCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            cliente = null;
            System.out.println("Ya hay un cliente con este NIF/DNI");
        }

        if (cliente != null) {
            clientes.add(cliente);
            guardarClientesRegistrados();
        }
    }

    /**
     * Calcula la longitud de la lista
     * @return el número de clientes en registrados
     */
    public int longitud() {
        return clientes.size();
    }

    /**
     * Ordena los clientes por nombre y los muestra
     */
    public void mostrarClientes() {
        Collections.sort(clientes,Cliente.comparadorPorNombre);

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Boora un cliente identificado por su dni/nif dado si existiese.
     * En caso contrario, lanzará mensaje al usuario.
     * @param identificador
     */
    public void borrarCliente(String identificador) {
        String comprobador = null;
        Iterator<Cliente> itCliente = clientes.iterator();
        while (itCliente.hasNext()) {
            Cliente cliente = itCliente.next();

            if (cliente.getDni_nif().equals(identificador)) {
                itCliente.remove();
                comprobador = "";
                guardarClientesRegistrados();
            }
        }
        if (comprobador == null){
            System.out.println("El Cliente no existe.");
        }
    }

    /**
     * Buscará un cliente según un nombre dado y lo devolverá
     * @param nombre
     * @return cliente buscado
     */
    public Cliente buscarClientesPorNombre(String nombre){
        for (Cliente c: clientes){
            if (c.getNombre().equals(nombre)){
                return c;
            }
        }

        return null; // En caso de no encontrarse el nombre entre los clientes devolverá null
    }

    /**
     * Busca un cliente según un dni/nif dado y lo devolverá
     * @param dni
     * @return cliente buscado
     */
    public Cliente buscarClientesPorDNI(String dni){
        for (Cliente c: clientes){
            if (c.getDni_nif().equals(dni)){
                return c;
            }
        }

        return null; // En caso de no encontrarse el dni/nif entre los clientes devolverá null
    }

    /**
     * Imprimirá por pantalla el cliente buscado ya sea por nombre o dni/nif.
     *
     * En caso de no haber encontrado ninguno. Avisará de que no se ha encontrado o de que
     * no existe si se dio un mal dni/nif o nombre.
     * @param cliente
     */
    public void mostrarClientesBuscados(Cliente cliente){
        try {
            if (cliente!=null) {
                System.out.println(cliente);
            }else{
                System.out.println("No se ha encontrado el cliente.");
            }
        }catch (NullPointerException e){
            System.out.println("No se ha encontrado el cliente");
        }
    }

    /**
     * Buscará un cliente por su dni/nif y lo devolverá para poder trabajar con el
     * @param identificador
     * @return cliente solicitado por dni/nif
     */
    public Cliente transicionCliente(String identificador) {
        Cliente cliente = null;

        for (Cliente c: clientes) {
            if (c.getDni_nif().equals(identificador)) {
                cliente = c;
            }
        }
        return cliente;
    }

    /**
     * Dado un email como parámetro, comprobará si cumple el patrón para verificarlo
     * como email
     * @param email
     * @return true si cumple el parámetro o falso si no lo hace
     */
    public Boolean comprobarMail(String email){
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(email).matches()){
            return true;
        }else{
            System.out.println("Introduzca un email correcto.");
        }

        return false;
    }

    /**
     * Escribirá la lista actual de clientes en info/clientesRegistrados.dat
     */
    public void guardarClientesRegistrados() {
        try {
            ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("info/clientesRegistrados.dat"));
            fos.writeObject(clientes);
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
    public void cargarClientesRegistrados(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info/clientesRegistrados.dat"));

            clientes = (LinkedList<Cliente>) ois.readObject();

            ois.close();
        } catch (IOException e) {
        } catch (ClassNotFoundException e){

        }
    }
}