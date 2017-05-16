package model;

import java.util.Date;

/**
 * Created by garci on 16/05/2017.
 */
public class VenderThermomix {
    private Date fecha;
    private int cantidad;
    private final int precioUd = 1000;
    private int precioTotal;

    public VenderThermomix() {
        this.setFecha();
        this.cantidad = 1;
        this.setPrecioTotal();
    }

    public VenderThermomix(int cantidad) {
        this.setFecha();
        this.setCantidad(cantidad);
        this.setPrecioTotal();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha() {
        this.fecha = new Date();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 1) {
            this.cantidad = 1;
        } else {
            this.cantidad = cantidad;
        }
    }

    public int getPrecioUd() {
        return precioUd;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal() {
        this.precioTotal = this.cantidad * this.precioUd;
    }

    @Override
    public String toString() {
        return "Thermomix( " +
                "Fecha Venta = " + fecha +
                ", Cantidad = " + cantidad +
                ", Precio/UD = " + precioUd +
                ", Rrecio Total = " + precioTotal +
                " )";
    }
}
