package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Empresa extends Cliente implements Comprobador, Serializable{
    private static final long serialVersionUID = -4902841103307778671L;
    private String direccion;
    private String encargado;
    private int telfEncargado;

    public Empresa() {
        this.direccion = "NS/NC";
        this.encargado = "Sin encargado";
        this.telfEncargado = 0;
    }

    public Empresa(String direccionFacturacion, int telfContacto, String dni_nif, String emailContacto, String nombre, String direccion, String encargado, int telfEncargado) {
        super(nombre, direccionFacturacion, telfContacto, dni_nif,emailContacto);
        this.setDireccion(direccion);
        this.setEncargado(encargado);
        this.setTelfEncargado(telfEncargado);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion.equals("")) {
            this.direccion = "NS/NC";
        } else {
            this.direccion = direccion;
        }
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        if (encargado.equals("")) {
            this.encargado = "Sin encargado";
        } else {
            this.encargado = encargado;
        }
    }

    public int getTelfEncargado() {
        return telfEncargado;
    }

    public void setTelfEncargado(int telfEncargado) {
        this.telfEncargado = telfEncargado;
    }

    @Override
    public String toString() {
        return "Empresa( " +
                "Nombre = " + super.getNombre() +
                ", Dirección = " + direccion +
                ", Encargado = " + encargado +
                ", Teléfono del Encargado = " + telfEncargado +
                " - " + super.toString();
    }
}
