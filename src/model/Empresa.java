package model;

import java.util.Date;
import java.util.Objects;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Empresa extends Cliente{
    private String nombre;
    private String nif;
    private String direccion;
    private String encargado;
    private int telfEncargado;

    public Empresa() {
        this.nombre = "Desconocido";
        this.nif = "Desconocido";
        this.direccion = "NS/NC";
        this.encargado = "Sin encargado";
        this.telfEncargado = 0;
    }

    public Empresa(String direccionFacturacion, int telfContacto, Date date, String nombre, String nif, String direccion, String encargado, int telfEncargado) {
        super(direccionFacturacion, telfContacto, date);
        this.setNombre(nombre);
        this.setNif(nif);
        this.setDireccion(direccion);
        this.setEncargado(encargado);
        this.setTelfEncargado(telfEncargado);
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        if (nif.equals("")) {
            this.nif = "Desconocido";
        } else {
            this.nif = nif;
        }
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
        return "Empresa (" +
                "ID = " + super.getId() +
                ", Nombre = " + nombre +
                ", NIF = " + nif +
                ", Dirección = " + direccion +
                ", Encargado = " + encargado +
                ", Teléfono del Encargado = " + telfEncargado +
                " - " + super.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){ return true; }
        if (obj == null){ return false;}
        if (this.getClass() != obj.getClass()){ return false; }

        Empresa emp = (Empresa)obj;

        return Objects.equals(this.getNif(), emp.getNif());
    }
}
