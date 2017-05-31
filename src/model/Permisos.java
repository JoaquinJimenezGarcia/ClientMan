package model;

/**
 * Created by joaquinjimenezgarcia on 31/05/2017.
 */
public class Permisos {
    private boolean escribir;
    private boolean leer;

    public Permisos() {
        this.escribir = false;
        this.leer = false;
    }

    public Permisos(boolean escribir, boolean leer) {
        this.setEscribir(escribir);
        this.setLeer(leer);
    }

    public boolean isEscribir() {
        return escribir;
    }

    public void setEscribir(boolean escribir) {
        this.escribir = escribir;
    }

    public boolean isLeer() {
        return leer;
    }

    public void setLeer(boolean leer) {
        this.leer = leer;
    }

    @Override
    public String toString() {
        return "Permisos (" +
                "escritura = " + escribir +
                ", lectura = " + leer +
                " )";
    }
}
