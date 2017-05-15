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
    private String dni;

    public Persona() {
        this.nombre = "Desconocido";
        this.apellidos = "Desconocido";
        this.email = "Desconocido";
        this.telf = 0;
        this.dni = "Desconocido";
    }

    public Persona(String direccionFacturacion, int telfContacto, Date date, String nombre, String apellidos, String email, int telf, String dni) {
        super(direccionFacturacion, telfContacto, date);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setEmail(email);
        this.setTelf(telf);
        this.setDni(dni);
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni.equals("")) {
            this.dni = "Desconocido";
        } else {
            this.dni = dni;
        }
    }

    @Override
    public String toString() {
        return  "Persona( " +
                "ID = " + super.getId() +
                ", Nombre = " + nombre +
                ", Apellidos = " + apellidos +
                ", E-mail = " + email +
                ", Teléfono = " + telf +
                ", DNI = " + dni +
                " - " + super.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){ return true; }
        if (obj == null){ return false;}
        if (this.getClass() != obj.getClass()){ return false; }

        Persona p = (Persona)obj;

        return Objects.equals(this.getDni(), p.getDni());
    }
}
