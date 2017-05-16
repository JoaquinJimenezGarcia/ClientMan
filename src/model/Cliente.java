package model;

import java.util.Date;
import java.util.Objects;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public abstract class Cliente {
    private String direccionFacturacion;
    private int telfContacto;
    Date date;
    String dni_nif;

    public Cliente() {
        this.direccionFacturacion = "NS/NC";
        this.telfContacto = 0;
        this.date = new Date();
        this.dni_nif = "AAAAAAA0";
    }

    public Cliente(String direccionFacturacion, int telfContacto, String dni_nif) {
        this.setDireccionFacturacion(direccionFacturacion);
        this.setTelfContacto(telfContacto);
        this.date = new Date();
        this.setDni_nif(dni_nif);
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

    @Override
    public String toString() {
        return "Dirección de Facturación = " + direccionFacturacion +
                ", Teléfono de Contacto = " + telfContacto +
                ", Fecha de Registro = " + date +
                ", DNI/NIF = " + dni_nif +
                " )";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){ return true; }
        if (obj == null){ return false;}
        if (this.getClass() != obj.getClass()){ return false; }

        Cliente c = (Persona)obj;

        return Objects.equals(this.getDni_nif(), c.getDni_nif());
    }
}
