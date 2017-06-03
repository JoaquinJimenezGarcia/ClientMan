package model;

import java.sql.*;

/**
 * Created by joaquinjimenezgarcia on 03/06/2017.
 */
public class ConexionBBDD {
    private Connection conexion = null;
    private String nombre;
    private String pass;
    private Boolean lectura;
    private Boolean escritura;
    private Boolean comprobacion;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public Boolean getLectura() {
        return lectura;
    }

    public void setLectura(Boolean lectura) {
        this.lectura = lectura;
    }

    public Boolean getEscritura() {
        return escritura;
    }

    public void setEscritura(Boolean escritura) {
        this.escritura = escritura;
    }

    public void conectar() throws SQLException{
        String jdbc = "jdbc:mysql://localhost:3306/usuarios";
        String user = "root";
        String passwd = "undertaker97";

        conexion = DriverManager.getConnection(jdbc,user,passwd);
        conexion.setAutoCommit(false);
    }

    public void cerrar() throws SQLException{
        if (conexion != null){
            conexion.close();
        }
    }

    public boolean consultaUsuario(String nombre, String password) throws SQLException {
        String query = "select nombre, pass, lectura, escritura from usuario where nombre = ? && pass = ? ";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, nombre);
        statement.setString(2, password);
        ResultSet set = statement.executeQuery();

        while(set.next()){
            this.comprobacion = true;

            boolean leer = set.getBoolean("lectura");
            boolean escribir = set.getBoolean("escritura");

            this.nombre = nombre;
            this.pass = password;
            this.setLectura(leer);
            this.setEscritura(escribir);
        }

        if (this.comprobacion){
            set.close();
            statement.close();
            return true;
        } else {
            System.out.println("El usuario no existe.");

            set.close();
            statement.close();

            return false;
        }
    }
}
