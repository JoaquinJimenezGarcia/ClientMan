package controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import model.Usuario;

import java.sql.*;

/**
 * Clase que establecerá una conexión con una base de datos para
 * llevar a cabo las tareas de usuario.
 *
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

    /**
     * Establecerá la conexión con el servidor
     * @throws SQLException si no se consigue conectar
     */
    public void conectar() throws SQLException{
        String jdbc = "jdbc:mysql://localhost:3306/usuarios";
        String user = "root"; //Usuario de la base de datos
        String passwd = "undertaker97"; //Contraseña de la base de datos

        conexion = DriverManager.getConnection(jdbc,user,passwd);
        conexion.setAutoCommit(false);
    }

    /**
     * Cierra la conexión con la base de datos.
     * @throws SQLException
     */
    public void cerrar() throws SQLException{
        if (conexion != null){
            conexion.close();
        }
    }

    /**
     * Dado un usuario, lo registrará en la base de datos para poder
     * acceder a la aplicación con dicho usuario con los permisos asignados
     *
     * @param usuario
     * @throws SQLException
     */
    public void registrarUsuario(Usuario usuario) throws SQLException{
        final String USUARIO = "Insert into usuario(nombre, pass, lectura, escritura) values(?, ?, ?, ?)";
        PreparedStatement usuarioNuevo = null;

        try{
            usuarioNuevo = conexion.prepareStatement(USUARIO);
            usuarioNuevo.setString(1, usuario.getNombre());
            usuarioNuevo.setString(2, usuario.getPasswd());
            usuarioNuevo.setBoolean(3, usuario.isLeer());
            usuarioNuevo.setBoolean(4, usuario.isEscribir());

            usuarioNuevo.executeUpdate();

            conexion.commit();

            System.out.println("Usuario "+ usuario.getNombre() + " registrado con éxito");
        }catch(MySQLIntegrityConstraintViolationException e) {
            conexion.rollback();
            System.out.println("El usuario ya existe.");
        } catch (SQLException p) {
            conexion.rollback();
            System.out.println("Ha habido un error con la conexion");
        }finally{
            if (usuarioNuevo != null){
                usuarioNuevo.close();
            }
        }
    }

    /**
     * Método que comprobará si un usuario existe o no en la base de datos.
     *
     * @param nombre
     * @param password
     * @return true si está o false si no
     * @throws SQLException
     */
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
