package model;

import java.util.Date;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public abstract class Cliente {
    private String direccionFacturacion;
    private int telfContacto;
    Date date;

    public Cliente() {
        this.direccionFacturacion = "NS/NC";
        this.telfContacto = 0;
        this.date = new Date();
    }

    public Cliente(String direccionFacturacion, int telfContacto, Date date) {
        this.setDireccionFacturacion(direccionFacturacion);
        this.setTelfContacto(telfContacto);
        this.date = new Date();
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
        return "Cliente (" +
                "direccionFacturacion = " + direccionFacturacion +
                ", telfContacto = " + telfContacto +
                ", date = " + date +
                " )";
    }
}
