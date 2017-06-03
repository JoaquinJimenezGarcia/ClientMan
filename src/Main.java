import controller.GestorApp;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args){
        GestorApp gestorApp = new GestorApp();
        try {
            gestorApp.inicioSesion();
        } catch (SQLException e) {
            System.out.println("Ha habido un problema conectando a la base de datos. Por favor, verifique su conexión.");
        }

    }
}
