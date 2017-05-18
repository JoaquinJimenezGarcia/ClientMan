package model;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Persona extends Cliente implements Comprobador{
    private String apellidos;
    private String email;
    private int telf;

    public Persona() {
        this.apellidos = "Desconocido";
        this.email = "Desconocido";
        this.telf = 0;
    }

    public Persona(String direccionFacturacion, int telfContacto, String dni_nif, String nombre, String apellidos, String email, int telf) {
        super(nombre, direccionFacturacion, telfContacto, dni_nif);
        this.setApellidos(apellidos);
        this.setEmail(email);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.equals("")) {
            this.email = "Desconocido";
        } else {
            this.email = email;
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
                ", E-mail = " + email +
                ", Teléfono = " + telf +
                " - " + super.toString();
    }
}
