package model;

import java.io.Serializable;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Persona extends Cliente implements Comprobador, Serializable{
    private static final long serialVersionUID = -7105788630314414532L;
    private String apellidos;
    private int telf;

    /**
     * Constructor por defecto de Persona
     */
    public Persona() {
        this.apellidos = "Desconocido";
        this.telf = 0;
    }

    /**
     * Constructor que se usará comunmente para construir el objeto Persona
     * @param direccionFacturacion
     * @param telfContacto
     * @param dni_nif
     * @param emailContacto
     * @param nombre
     * @param apellidos
     * @param telf
     */
    public Persona(String direccionFacturacion, int telfContacto, String dni_nif, String emailContacto, String nombre, String apellidos, int telf) {
        super(nombre, direccionFacturacion, telfContacto, dni_nif, emailContacto);
        this.setApellidos(apellidos);
        this.setTelf(telf);
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

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    @Override
    public String toString() {
        return  "Persona( " +
                "Nombre = " + super.getNombre() +
                ", Apellidos = " + apellidos +
                ", E-mail = " + super.getEmailContacto() +
                ", Teléfono = " + telf +
                " - " + super.toString();
    }
}
