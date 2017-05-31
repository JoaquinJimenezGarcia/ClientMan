package model;

/**
 * Created by joaquinjimenezgarcia on 31/05/2017.
 */
public class Usuario extends Permisos {
    private String nombre;
    private String passwd;

    public Usuario(boolean escribir, boolean leer) {
        super(escribir, leer);
        this.nombre = "null";
        this.passwd = "null";
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
}
