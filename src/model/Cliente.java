package model;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public abstract class Cliente {
    private int id;
    private String direccionFacturacion;
    private int telfContacto;
    Date date;

    public Cliente() {
        this.direccionFacturacion = "NS/NC";
        this.telfContacto = 0;
        this.date = new Date();
        this.id++;
    }

    public Cliente(String direccionFacturacion, int telfContacto, Date date) {
        this.id++;
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

    public int getId(){ return id; }

    @Override
    public String toString() {
        return "Dirección de Facturación = " + direccionFacturacion +
                ", Teléfono de Contacto = " + telfContacto +
                ", Fecha de Registro = " + date +
                " )";
    }

    public static Comparator<Cliente> comparadorPorID = new Comparator<Cliente>() {
        @Override
        public int compare(Cliente c1, Cliente c2) {
            return c1.getId() - c2.getId();
        }
    };
}
