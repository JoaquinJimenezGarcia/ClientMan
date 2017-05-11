package model;

import java.util.ArrayList;

/**
 * Created by joaquinjimenezgarcia on 11/5/17.
 */
public class Gestor {
    private ArrayList<Cliente> clientes;

    public Gestor(){
        clientes = new ArrayList<>();
    }

    public int longitud(){
        return clientes.size();
    }
}
