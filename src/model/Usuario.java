package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by joaquinjimenezgarcia on 31/05/2017.
 */
public class Usuario extends Permisos implements Serializable{

    private String nombre;
    private String passwd;

    public Usuario(boolean escribir, boolean leer) {
        super(escribir, leer);
        this.nombre = "null";
        this.passwd = "null";
    }

    public Usuario(String nombre, String passwd){
        this.setNombre(nombre);
        this.setPasswd(passwd);
    }

    public Usuario(boolean escribir, boolean leer, String nombre, String passwd) {
        super(escribir, leer);
        this.setNombre(nombre);
        this.setPasswd(passwd);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Usuario (" +
                "nombre = " + nombre +
                ", contraseña = " + passwd +
                ")" + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        // Self check
        if (this == obj){ return true; }

        // Null chek
        if (obj == null){ return false; }

        // Type check and cast
        if (this.getClass() != obj.getClass()){ return  false; }

        // Field comparaison
        Usuario user = (Usuario) obj;
        return
                Objects.equals(this.nombre, user.nombre)&&
                        Objects.equals(this.passwd, user.passwd);
    }
}
