package model;

import java.util.Date;
import java.util.Objects;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Persona extends Cliente implements Comprobador{
    private String nombre;
    private String apellidos;
    private String email;
    private int telf;

    public Persona() {
        this.nombre = "Desconocido";
        this.apellidos = "Desconocido";
        this.email = "Desconocido";
        this.telf = 0;
    }

    public Persona(String direccionFacturacion, int telfContacto, String dni_nif, String nombre, String apellidos, String email, int telf) {
        super(direccionFacturacion, telfContacto, dni_nif);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setEmail(email);
        this.setTelf(telf);
    }

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos.equals("")){
            this.apellidos = "Desconocido";
        }else{
            this.apellidos = apellidos;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.equals("")) {
            this.email = "Desconocido";
        } else {
            this.email = email;
        }
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    @Override
    public String toString() {
        return  "Persona( " +
                ", Nombre = " + nombre +
                ", Apellidos = " + apellidos +
                ", E-mail = " + email +
                ", Teléfono = " + telf +
                " - " + super.toString();
    }
}
