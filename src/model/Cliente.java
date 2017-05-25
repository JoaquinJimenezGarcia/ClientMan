package model;

import controller.WrongMailException;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public abstract class Cliente implements Serializable{
    private static final long serialVersionUID = -3536209067986308293L;
    private String nombre;
    private String direccionFacturacion;
    private int telfContacto;
    private Date date;
    private String dni_nif;
    private boolean vendido;
    private Date fechaRecesion;
    private Date fechaVenta;
    private String emailContacto;

    public Cliente() {
        this.nombre = "Desconocido";
        this.direccionFacturacion = "NS/NC";
        this.telfContacto = 0;
        this.date = new Date();
        this.dni_nif = "AAAAAAA0";
        this.vendido = false;
        this.emailContacto = "Desconocido";
    }

    public Cliente(String nombre, String direccionFacturacion, int telfContacto, String dni_nif, String emailContacto) {
        this.setNombre(nombre);
        this.setDireccionFacturacion(direccionFacturacion);
        this.setTelfContacto(telfContacto);
        this.date = new Date();
        this.setDni_nif(dni_nif);
        this.setEmailContacto(emailContacto);
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    /*private static String leerMail() throws WrongMailException {
        Scanner s = new Scanner(System.in);
        String email;
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Introduce el email: ");
        email = s.next();

        if (pattern.matcher(email).matches()){
            System.out.println("Email correcto.");
        }else{
            throw new WrongMailException("Email incorrecto");
        }

        return email;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.equals("")){
            this.nombre = "Desconocido";
        }else {
            this.nombre = nombre;
        }
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public String getDni_nif() {
        return dni_nif;
    }

    public void setDni_nif(String dni_nif) {
        if (dni_nif.equals("")) {
            this.dni_nif = "000000A";
        } else {
            this.dni_nif = dni_nif;
        }
    }

    public Date getFechaRecesion(){
        return fechaRecesion;
    }

    public Date getFechaVenta(){
        return fechaVenta;
    }

    public String getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public void setDireccionFacturacion(String direccionFacturacion) {
        if (direccionFacturacion.equals("")){
            this.direccionFacturacion = "NS/NC";
        }else {
            this.direccionFacturacion = direccionFacturacion;
        }
    }

    public int getTelfContacto() {
        return telfContacto;
    }

    public void setTelfContacto(int telfContacto) {
        this.telfContacto = telfContacto;
    }

    public Date getDate() {
        return date;
    }

    public Date venta(){
        if (this.isVendido()){
            this.fechaVenta = new Date();
            fechaLlegada(fechaVenta);
            return fechaVenta;
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        if (this.isVendido()) {
            return "Dirección de Facturación = " + direccionFacturacion +
                    ", Teléfono de Contacto = " + telfContacto +
                    ", Fecha de Registro = " + date +
                    ", DNI/NIF = " + dni_nif +
                    ", Vendido en = " + fechaVenta +
                    ", Llegará en = " + fechaRecesion +
                    " )";
        } else {
            return "Dirección de Facturación = " + direccionFacturacion +
                    ", Teléfono de Contacto = " + telfContacto +
                    ", Fecha de Registro = " + date +
                    ", DNI/NIF = " + dni_nif +
                    " )";
        }
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){ return true; }
        if (obj == null){ return false;}
        if (this.getClass() != obj.getClass()){ return false; }

        Cliente c = (Persona)obj;

        return Objects.equals(this.getDni_nif(), c.getDni_nif());
    }

    public static Comparator<Cliente> comparadorPorNombre = new Comparator<Cliente>() {
        @Override
        public int compare(Cliente c1, Cliente c2) {
            return  c1.getNombre().compareToIgnoreCase(c2.getNombre());
        }
    };

    public Date fechaLlegada(Date fecha){
        Calendar calendar = Calendar.getInstance();
        final int DIAS_ESPERA = 30;

        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.SECOND, DIAS_ESPERA);  // numero de días a añadir, o restar en caso de días<0

        this.fechaRecesion = calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

        return fechaRecesion;
    }
}
